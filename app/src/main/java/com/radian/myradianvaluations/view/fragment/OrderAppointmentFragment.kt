package com.radian.myradianvaluations.view.fragment

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentUris
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.ManageOrderResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.OrderAppointmentViewModelFactory
import com.radian.myradianvaluations.viewmodel.OrderAppoitmentViewModel
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog
import com.wdullaer.materialdatetimepicker.time.Timepoint
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.dialog_add_event.view.*
import kotlinx.android.synthetic.main.fragment_order_appointment.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.text.SimpleDateFormat
import java.util.*

class OrderAppointmentFragment : Fragment(), View.OnClickListener,
    DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    internal lateinit var view: View
    private val REQUEST_CODE = 101
    lateinit internal var dialogView: View
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var orderAppointmentViewModel: OrderAppoitmentViewModel
    lateinit var calendar: Calendar
    lateinit var timeCalender: Calendar
    private var dpd: DatePickerDialog? = null
    private var tpd: TimePickerDialog? = null
    private val dateFormat = SimpleDateFormat(Const.formatAppoinmnt)
    private lateinit var factory: OrderAppointmentViewModelFactory
    private var orderDetail = ManageOrderResponse.Data.OrderDetail()
    private val REQUIRED_PERMISSIONS =
        arrayOf("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR")
    private val REQUEST_CODE_CALENDAR = 102

    companion object {
        fun newInstance(orderDetail: ManageOrderResponse.Data.OrderDetail): OrderAppointmentFragment {
            val args = Bundle()
            args.putParcelable(Const.itemIdTag, orderDetail)
            val fragment = OrderAppointmentFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_order_appointment, container, false)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "Appointment_Launched")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        setToolbar()
        initViewModel()
        observeData()
        view.linearCall.setOnClickListener(this)
        view.linearEmail.setOnClickListener(this)
        view.edtDateTime.setOnClickListener(this)
        view.btnSave.setOnClickListener(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "Appointment_Launched")
        CommonUtils.addParamstoFirebaseEvent(firebaseAnalytics, Const.screenLaunched, firebaseParams)
        arguments?.let {
            orderDetail =
                it.getParcelable<ManageOrderResponse.Data.OrderDetail>(Const.itemIdTag) as ManageOrderResponse.Data.OrderDetail
        }
        setData()
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.appointmentTitle)
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
    }

    private fun initViewModel() {
        factory = OrderAppointmentViewModelFactory(context!!)
        orderAppointmentViewModel =
            ViewModelProvider(this, factory).get(OrderAppoitmentViewModel::class.java)
    }

    private fun observeData() {
        orderAppointmentViewModel.appointmentResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, true)) {
                    //check if event is already existing then reschedule it
                    if (CommonUtils.allPermissionsGranted(context!!)) {
                        if (orderDetail.appointmentTime != null) {
                            getCalendarEvents()
                        }
                    } else {
                        ActivityCompat.requestPermissions(
                            (context as BottomNavigationActivity),
                            REQUIRED_PERMISSIONS,
                            REQUEST_CODE_CALENDAR
                        )
                    }

                    showAddToCalenderDialog()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    Toast.makeText(
                        context!!,
                        it.errorInfo.get(0).errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun setData() {
        if (orderDetail.appointmentDate.isNullOrEmpty() || orderDetail.appointmentTime.isNullOrEmpty()) {
            view.txtApptTime.text = "NA"
        } else {
            view.txtApptTime.text =
                setValue(orderDetail.appointmentDate + " " + orderDetail.appointmentTime)

        }
        view.txtApptAdd.text = setValue(orderDetail.displayAddressInfo)
        view.txtApptName.text = setValue(orderDetail.borrowerName)
        view.txtApptPhone.text = setValue(orderDetail.borrowerPhone?.let {
            CommonUtils.formatNumber(
                it
            )
        })
        view.txtApptEmail.text = setValue(orderDetail.borrowerEmail)
    }

    private fun setValue(value: String?): String {
        if (value.isNullOrEmpty())
            return "NA"
        else
            return value
    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(view.edtDateTime.text.toString())) {
            view.snack(context!!.resources.getString(R.string.error_enter_appoinmnt)) {}
            return false
        } else if (TextUtils.isEmpty(view.edtNote.text)) {
            CommonUtils.hideKeybord(
                (context as BottomNavigationActivity).window.decorView.rootView,
                context!!
            )
            view.snack(context!!.resources.getString(R.string.error_enter_note)) {}
            return false
        }
        return true
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.edtDateTime -> {
                calendar = Calendar.getInstance()
                timeCalender = Calendar.getInstance()

                showDateTimePicker()
            }
            R.id.btnSave -> {
                if (isValid()) {
                    CommonUtils.hideKeybord(
                        (context as BottomNavigationActivity).window.decorView.rootView,
                        context!!
                    )
                    addInspection()
                }
            }
            R.id.linearCall -> {
                if (!orderDetail.borrowerPhone.isNullOrEmpty()) {
                    CommonUtils.showDialog(
                        context!!,
                        getString(R.string.call_dialog_title),
                        DialogInterface.OnClickListener { _, _ ->


                            if (CommonUtils.checkCallPermission(context!!)) {
                                val intent = Intent(Intent.ACTION_CALL)
                                intent.data =
                                    Uri.parse("tel:" + orderDetail.borrowerPhone)
                                startActivity(intent)
                            } else {
                                requestPermission()
                            }

                        },
                        DialogInterface.OnCancelListener { _ -> },
                        "Yes",
                        "No"
                    )

                }
            }
            R.id.linearEmail -> {
                val emailIntent = Intent(
                    Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "" + orderDetail.borrowerEmail, null
                    )
                )
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
                startActivity(Intent.createChooser(emailIntent, "Send email..."))
            }
        }
    }

    private fun addInspection() {
        var postParams = HashMap<String, Any?>()
        postParams.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParams.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParams.put("AppointmentDate", view.edtDateTime.text.toString())
        postParams.put("Notes", view.edtNote.text.toString())
        postParams.put("ItemId", orderDetail.itemId)
        postParams.put("ActionType", "")
        postParams.put("TimeZone", TimeZone.getDefault().id)
        orderAppointmentViewModel.addAppointment(postParams)
    }

    private fun showDateTimePicker() {

        if (dpd == null) {
            dpd = DatePickerDialog.newInstance(
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        } else {
            dpd!!.initialize(
                this,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        }
        dpd!!.setOnCancelListener { dialog ->
            dpd = null
        }
        dpd!!.minDate = calendar
        dpd!!.show(fragmentManager!!, "Datepickerdialog")
    }

    private fun getCalendarEvents() {
        var projection = arrayOf(
            CalendarContract.Events.CALENDAR_ID,
            CalendarContract.Events.TITLE,
            CalendarContract.Events.DESCRIPTION,
            CalendarContract.Events.DTSTART,
            CalendarContract.Events.DTEND,
            CalendarContract.Events.ALL_DAY,
            CalendarContract.Events.EVENT_LOCATION,
            CalendarContract.Events._ID

        )
        var appointmentDate = orderDetail.appointmentTime!!

        val eventDate: Date?
        val endCalendar = Calendar.getInstance()
        try {
            eventDate =
                dateFormat.parse(appointmentDate)
            calendar = Calendar.getInstance()

//            calendar.time = eventDate
            calendar.add(Calendar.DATE, -30)
            endCalendar.add(Calendar.DATE, 30)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        var eventTitle = "Inspection is Scheduled for " + orderDetail.itemId
        var selection =
            "(( " + CalendarContract.Events.TITLE + "= '" + eventTitle + "' ) AND (" + CalendarContract.Events.DTSTART + " >= " + calendar.getTimeInMillis() + " ) AND ( " + CalendarContract.Events.DTSTART + " <= " + endCalendar.getTimeInMillis() + " ) AND ( deleted != 1 ))"
        var cursor = context!!.getContentResolver().query(
            CalendarContract.Events.CONTENT_URI,
            projection,
            selection,
            null,
            null
        )

        var events = ArrayList<String>()
        if (cursor != null && cursor.getCount() > 0 && cursor.moveToFirst()) {
            do {
                events.add(cursor.getString(1))
                LogUtils.logD("Events", events.get(0))
                var deleteUri: Uri? = null
                deleteUri = ContentUris.withAppendedId(
                    CalendarContract.Events.CONTENT_URI,
                    cursor.getString(7).toLong()
                )
                var rows = context!!.getContentResolver().delete(deleteUri, null, null)
            } while (cursor.moveToNext())
        }
    }

    private fun showAddToCalenderDialog() {

        dialogView = LayoutInflater.from(context!!).inflate(R.layout.dialog_add_event, null)
        val builder =
            AlertDialog.Builder(context!!, R.style.FullScreenDialogTheme)

        builder.setView(dialogView)
        val dialog = Dialog(context!!, R.style.FullScreenDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogView)
        val lp = dialog.getWindow()!!.getAttributes()
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        dialog.getWindow()!!.setAttributes(lp)
        dialog.show()
        dialogView.txt_date.setText(view.edtDateTime.text.toString())
        dialogView.txt_product.setText(orderDetail.product)
        dialogView.txt_address.setText(orderDetail.displayAddressInfo)
        dialogView.img_close.setOnClickListener {
            dialog.dismiss()
            (context as BottomNavigationActivity).onBackPressed()
        }
        dialogView.btnAddEvent.setOnClickListener {
            setReminder(
                "Inspection is Scheduled for " + orderDetail.itemId,
                "Radian Valuation Services",
                view.edtDateTime.text.toString(),
                orderDetail.displayAddressInfo!!
            )
        }
        dialogView.btnOk.setOnClickListener {
            dialog.dismiss()
            (context as BottomNavigationActivity).onBackPressed()

        }
    }

    private fun setReminder(title: String, description: String, date: String, address: String) {
        var eventTitle = title //This is event title
        var eventDescription = description//This is event description
        var eventDate = date//This is the event date
        var eventLocation = address //This is the address ffor your event location
        val cal = Calendar.getInstance()
        try {
            val dEventDate =
                dateFormat.parse(eventDate)   //Date is formatted to standard format “MM/dd/yyyy”
            cal.setTime(dEventDate)
            //cal.add(Calendar.DATE, -1)   //It will return one day before calendar of eventDate


        } catch (e: Exception) {
            e.printStackTrace()
        }
        val reminderDate = dateFormat.format(cal.getTime())

        val reminderDayStart = reminderDate
        val reminderDayEnd = reminderDate
        var startTimeInMilliseconds: Long = 0
        var endTimeInMilliseconds: Long = 0
        try {
            val formatter = SimpleDateFormat(Const.formatAppoinmnt)
            val startDate = formatter.parse(reminderDayStart)
            val endDate = formatter.parse(reminderDayEnd)
            startTimeInMilliseconds = startDate.getTime()
            endTimeInMilliseconds = endDate.getTime()
            Log.e("startDate", reminderDayStart)
            Log.e("endDate", reminderDayEnd)
            val cr = context!!.getContentResolver()
            val values = ContentValues()
            values.put(CalendarContract.Events.CALENDAR_ID, getCalendarId())
            values.put(CalendarContract.Events.DTSTART, startTimeInMilliseconds)
            values.put(CalendarContract.Events.DTEND, endTimeInMilliseconds)
            values.put(CalendarContract.Events.TITLE, eventTitle)
            values.put(CalendarContract.Events.DESCRIPTION, eventDescription)
            values.put(CalendarContract.Events.EVENT_LOCATION, eventLocation)
            values.put(CalendarContract.Events.ALL_DAY, 0)

            val timeZone = TimeZone.getDefault()
            values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID())
            values.put(CalendarContract.Events.RRULE, "FREQ=HOURLY  COUNT=1")
            values.put(CalendarContract.Events.HAS_ALARM, 1)
            var eventUri: Uri
            if (Build.VERSION.SDK_INT >= 8) {
                eventUri = Uri.parse("content://com.android.calendar/events")
            } else {
                eventUri = Uri.parse("content://calendar/events")
            }
            // insert event to calendar
            val uri = cr.insert(eventUri, values)
            Log.e("EventTest", uri.toString())

//add reminder for event

            try {
                var reminderUri: Uri
                var id: Long = -1
                id = (uri!!.getLastPathSegment()!!.toLong())
                var reminders = ContentValues()
                reminders.put(CalendarContract.Reminders.EVENT_ID, id)
                reminders.put(
                    CalendarContract.Reminders.METHOD,
                    CalendarContract.Reminders.METHOD_ALERT
                )
                reminders.put(CalendarContract.Reminders.MINUTES, 30)
                if (Build.VERSION.SDK_INT >= 8) {
                    reminderUri = Uri.parse("content://com.android.calendar/reminders")
                } else {
                    reminderUri = Uri.parse("content://calendar/reminders")
                }
                var remindersUri = context!!.getContentResolver().insert(reminderUri, reminders)
                Log.e("RemindersTest", remindersUri.toString())
                if (dialogView != null) {
                    dialogView.btnOk.visibility = View.VISIBLE
                    dialogView.btnAddEvent.visibility = View.GONE
                    dialogView.img_close.visibility = View.GONE
                    dialogView.imgEventAdded.visibility = View.VISIBLE
                    dialogView.txtEventAdded.visibility = View.VISIBLE
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun getCalendarId(): Int {

        var cursor: Cursor?
        var contentResolver = context!!.getContentResolver()
        var calendars = CalendarContract.Calendars.CONTENT_URI

        var eventProjection = arrayOf(
            CalendarContract.Calendars._ID,                           // 0
            CalendarContract.Calendars.ACCOUNT_NAME,                // 1
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,       // 2
            CalendarContract.Calendars.OWNER_ACCOUNT,                // 3
            CalendarContract.Calendars.IS_PRIMARY
        )
        // 4
        var projectionIdIndex: Int = 0

        var projectnDisplayIdIndex: Int = 2

        var projectnVisible: Int = 4

        cursor = contentResolver.query(calendars, eventProjection, null, null, null)

        if (cursor!!.moveToFirst()) {
            var calName = ""
            var calId: Long = 0
            var visible: String = ""

            do {
                calName = cursor.getString(projectnDisplayIdIndex)
                calId = cursor.getLong(projectionIdIndex)
                visible = cursor.getString(projectnVisible)
                if (visible.equals("1")) {
                    return calId.toInt()
                }
                Log.e("Calendar Id : ", "" + calId + " : " + calName + " : " + visible)
            } while (cursor.moveToNext())

            return calId.toInt()
        }
        return 1
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, monthOfYear)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        if (tpd == null) run {
            tpd = TimePickerDialog.newInstance(
                this,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                false
            )
        } else {
            tpd!!.initialize(
                this,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND),
                false
            )
        }
        tpd!!.setOnCancelListener { _ ->
            tpd = null
        }
        tpd!!.setTimeInterval(1, 15)
        tpd!!.show(requireFragmentManager(), "Timepickerdialog")

        var minTime: Timepoint
        if (calendar.get(Calendar.MINUTE) >= 45) {
            minTime =
                Timepoint(calendar.get(Calendar.HOUR_OF_DAY) + 1, 0)

        } else {
            minTime =
                Timepoint(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))
        }

        if (calendar.get(Calendar.DAY_OF_MONTH) == timeCalender.get(Calendar.DAY_OF_MONTH))

            tpd!!.setMinTime(minTime)
        dpd = null

    }

    override fun onTimeSet(
        pickerview: TimePickerDialog?,
        hourOfDay: Int,
        minute: Int,
        second: Int
    ) {
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
        calendar.set(Calendar.MINUTE, minute)
        view.edtDateTime.setText(
            SimpleDateFormat(Const.formatAppoinmnt, Locale.US).format(
                calendar.timeInMillis
            )
        )
        tpd = null
    }

    private fun requestPermission() {

        requestPermissions(
            arrayOf(
                Manifest.permission.CALL_PHONE
            ),
            REQUEST_CODE
        )

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        val permission = permissions[0]
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    val showRationale =
                        ActivityCompat.shouldShowRequestPermissionRationale(
                            context as BottomNavigationActivity,
                            permission
                        )
                    if (!showRationale) {
                        val snackBar = Snackbar.make(
                            view,
                            getString(R.string.permission_call),
                            Snackbar.LENGTH_LONG
                        )
                        snackBar.setActionTextColor(
                            Color.WHITE
                        )
                        snackBar.setAction("SETTINGS") {
                            val intent =
                                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            val uri =
                                Uri.fromParts("package", context!!.packageName, null)
                            intent.data = uri
                            startActivityForResult(intent, 12)
                            snackBar.dismiss()
                        }
                        snackBar.show()
                    } else {
                        val snackBar = Snackbar.make(
                            view,
                            getString(R.string.permission_call),
                            Snackbar.LENGTH_LONG
                        )
                        snackBar.setActionTextColor(Color.WHITE)
                        snackBar.setAction("ALLOW") {
                            requestPermission()
                            snackBar.dismiss()
                        }
                        snackBar.show()

                    }

                }
            }
        }

    }


}