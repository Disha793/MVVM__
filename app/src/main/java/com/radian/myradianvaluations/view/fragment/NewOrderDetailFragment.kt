package com.radian.myradianvaluations.view.fragment

import android.app.Dialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.Settings
import android.util.Log
import android.view.*
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.NewOrderDetailResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.*
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.CommonUtils.allPermissionsGranted
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.NewOrdrDetailViewModel
import com.radian.myradianvaluations.viewmodel.NewOrdrDetailViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.dialog_add_event.view.*
import kotlinx.android.synthetic.main.fragment_new_order_detail.view.*
import kotlinx.android.synthetic.main.fragment_order_loe.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.row_choose_time.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class NewOrderDetailFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    private var itemId = 0
    private var orderDetail = NewOrderDetailResponse.Data.OrderDetail()
    private val classTag = javaClass.canonicalName!!
    private var selectedTimeSlot = ""
    private val itemNoteId = ArrayList<Int>()
    lateinit var eventdialogView: View
    private val unassignedItemId = ArrayList<Int>()
    private val itemIdList = ArrayList<Int>()
    private val orgIds = ArrayList<Int>()
    private val selectedOrderList = ArrayList<NewOrderDetailResponse.Data.OrderDetail>()
    private val REQUIRED_PERMISSIONS =
        arrayOf("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR")
    private val REQUEST_CODE_PERMISSIONS = 101
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var newOrdrDetailViewModel: NewOrdrDetailViewModel
    private lateinit var factory: NewOrdrDetailViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_new_order_detail, container, false)
        view.linearAddress.setOnClickListener(this)
        view.linearProduct.setOnClickListener(this)
        view.btnAccept.setOnClickListener(this)
        view.btnDecline.setOnClickListener(this)
        setToolbar()
        initViewModel()
        observeOrderData()
        return view
    }

    private fun manageUI(orderDetail: NewOrderDetailResponse.Data.OrderDetail) {
        view.viewLoe.makeVisible()
        val url =
            BuildConfig.HOST + "mobile/Dashboard/GetDownloadOLEDocument?OrderGenID=" + orderDetail.orderGenId + "&ItemSrNo=" + orderDetail.itemSrNo + "&UserId=" + orderDetail.userId + "&ServiceRequestType=" +
                    orderDetail.serviceRequestType
        loadLoe(url)
        view.btnLOeAccept.setOnClickListener {
            view.viewLoe.makeGone()
        }
        view.btnReject.setOnClickListener {
            declineOrder()
        }
    }

    private fun loadLoe(url: String) {
        LogUtils.logD(classTag + ": Loe url", url)
        LoadingDialog.show(activity!!)
        view.webView.getSettings().setLoadWithOverviewMode(true)
        view.webView.getSettings().setUseWideViewPort(true)
        view.webView.getSettings().setJavaScriptEnabled(true)
        view.webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT)
//        if (!CommonUtils.isNetworkAvailable(activity!!)) { // loading offline
//            view.webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK)
//        }
        view.webView.loadUrl(url)
        view.webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                LoadingDialog.dismissDialog()
            }

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.let {
                    if (request != null && request.url != null)
                        it.loadUrl(request.url.toString())
                }

                return true
            }

            override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
                view.webView.loadUrl(url)
                return true
            }

            override fun onReceivedError(
                view: WebView,
                request: WebResourceRequest,
                error: WebResourceError
            ) {
                context!!.toastShort("Got Error! $error")
            }
        }
    }

    private fun initViewModel() {
        factory = NewOrdrDetailViewModelFactory(context!!)
        newOrdrDetailViewModel =
            ViewModelProvider(this, factory).get(NewOrdrDetailViewModel::class.java)
    }

    private fun observeOrderData() {

        newOrdrDetailViewModel.newOrderDetailResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status == APIStatus.ok) {
                    it.data?.orderDetail?.let {
                        orderDetail = it
                    }
                    manageUI(orderDetail)
                    setOrderDetail(orderDetail)
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context?.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
        newOrdrDetailViewModel.confirmOrderResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {

                if (it != null) {
                    if (it.status.equals(APIStatus.ok, true)) {
                        //To add reminder in google cal
//                if (orderDetail.isAssigned == 0) {
////                    showAddToCalenderDialog()
//                } else {

                        (context as BottomNavigationActivity).onBackPressed()
//                }
                    } else if (it.status.equals(APIStatus.unauth, true)) {
                        context?.toastShort(it.errorInfo.get(0).errorMessage)

                        var intent = Intent(context!!, PasscodeActivity::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    }

                }
                //  newOrdrDetailViewModel.confirmOrderResponse.postValue(null)

            })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "NewOrderDetail_Launched")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        arguments?.let {
            itemId = it.getInt(Const.itemIdTag)
        }
        itemIdList.clear()
        unassignedItemId.clear()
        getOrderDetail()
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).txtTitle.text =
            getString(R.string.title_new_order_detail)
        (context as BottomNavigationActivity).imgBack.makeVisible()
        (context as BottomNavigationActivity).txtClear.makeGone()
    }

    private fun getOrderDetail() {

        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("Itemid", itemId)

        newOrdrDetailViewModel.getOrderDetail(postParam)
    }

    private fun setOrderDetail(orderDetail: NewOrderDetailResponse.Data.OrderDetail) {
        view.txtNwOrdrAdd.text = setValue(orderDetail.displayAddressInfo)
        if (orderDetail.isAssigned == 1) {
            view.nwOrdrappraiser.makeGone()
            view.lblChooseTimng.makeGone()
            view.viewAppraiser.makeGone()
            view.viewChooseTimng.makeGone()
            view.lblApptTime.makeGone()
            view.txtNwOrdrDteTime.makeGone()
            view.viewApptTime.makeGone()
        } else {
            view.nwOrdrappraiser.makeVisible()
            view.lblChooseTimng.makeGone()
            view.viewAppraiser.makeVisible()
            view.viewChooseTimng.makeGone()
            view.nwOrdrappraiser.text = setValue(orderDetail.message)
            orderDetail.appointmentTimedetails?.let {
                addChooseTime(it)
            }
            view.lblApptTime.makeGone()
            view.txtNwOrdrDteTime.makeGone()
            view.viewApptTime.makeGone()
        }
        view.txtNwOrdrProduct.text = setValue(orderDetail.productName)
        view.txtNwOrdrFee.text = "$" + setValue(orderDetail.paymentAmount)
        view.txtNwOrdrDteTime.text =
            orderDetail.appointmentDate + orderDetail.startTimeSlot?.let { " | " + "Start between " + it + " - " + orderDetail.endTimeSlot }
        view.txtNwOrdrDue.text = setValue(orderDetail.productDueDate)
    }

    private fun setValue(value: String?): String {
        if (value.isNullOrBlank())
            return "NA"
        else
            return value
    }

    private fun addChooseTime(appointmentTimedetails: ArrayList<String>) {
        view.gridTiming.adapter = Timeadapter(context!!, appointmentTimedetails)
    }

    companion object {
        fun newInstance(itemId: Int): NewOrderDetailFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment = NewOrderDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private fun confirmOrder() {
        var postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("ItemNotes", itemNoteId)
        postParam.put("ActionType", "A")
        if (orderDetail.isAssigned == 0) {
            postParam.put("UnassignedItemIds", itemId)
        } else {
            postParam.put("ItemIds", itemId)
        }
        //For unAssigned order appointmentdate
//        if (orderDetail.isAssigned == 0) {
//            postParam.put(
//                    "AppointmentDate",
//                    orderDetail.appointmentDate + " " + selectedTimeSlot
//            )
//        }
        postParam.put("TimeZone", TimeZone.getDefault().id)
        newOrdrDetailViewModel.confirmOrder(postParam)
    }

    private fun showAddToCalenderDialog() {
        try {
            eventdialogView =
                LayoutInflater.from(context!!).inflate(R.layout.dialog_add_event, null, false)

            val dialog = Dialog(context!!, R.style.FullScreenDialogTheme)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(eventdialogView)
            val lp = dialog.getWindow()!!.getAttributes()
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            dialog.getWindow()!!.setAttributes(lp)
            dialog.show()

            eventdialogView.txt_date.text = orderDetail.appointmentDate + " " + selectedTimeSlot
            eventdialogView.txt_product.setText(orderDetail.productName)
            eventdialogView.txt_address.setText(orderDetail.displayAddressInfo)
            eventdialogView.img_close.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    dialog.dismiss()
                    (context as BottomNavigationActivity).onBackPressed()
                }
            })
            eventdialogView.btnAddEvent.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    if (allPermissionsGranted(context!!)) {
                        setReminder(
                            getString(R.string.inspection_scheduled),
                            "",
                            orderDetail.appointmentDate,
                            orderDetail.displayAddressInfo
                        )
                    } else {
                        requestPermissions(

                            REQUIRED_PERMISSIONS,
                            REQUEST_CODE_PERMISSIONS
                        )
                    }
                }
            })
            eventdialogView.btnOk.setOnClickListener {
                dialog.dismiss()
                (context as BottomNavigationActivity).onBackPressed()
            }
        } catch (e: java.lang.Exception) {
            LogUtils.logE("Catch!!!!", e)
        }
    }

    private fun setReminder(title: String, description: String, date: String, address: String) {
        var eventTitle = title //This is event title
        var eventDescription = description//This is event description
        var eventDate = date//This is the event date
        var eventLocation = address //This is the address ffor your event location
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat(Const.formatAppoinmnt)
        try {
            val dEventDate =
                dateFormat.parse(eventDate) //Date is formatted to standard format “MM/dd/yyyy”
            cal.setTime(dEventDate)

        } catch (e: Exception) {
            LogUtils.logE(classTag, e)
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
            startTimeInMilliseconds = startDate.time
            endTimeInMilliseconds = endDate.time
            LogUtils.logD("startDate", reminderDayStart)
            LogUtils.logD("endDate", reminderDayEnd)
            val cr = context!!.contentResolver
            val values = ContentValues()
            values.put(CalendarContract.Events.CALENDAR_ID, 3)
            values.put(CalendarContract.Events.DTSTART, startTimeInMilliseconds)
            values.put(CalendarContract.Events.DTEND, endTimeInMilliseconds)
            values.put(CalendarContract.Events.TITLE, eventTitle)
            values.put(CalendarContract.Events.DESCRIPTION, eventDescription)
            values.put(CalendarContract.Events.EVENT_LOCATION, eventLocation)
            values.put(CalendarContract.Events.ALL_DAY, 0)

            val timeZone = TimeZone.getDefault()
            values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.id)
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
//This reminder will be show before 30 minutes
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
                var remindersUri = context!!.contentResolver.insert(reminderUri, reminders)
                Log.e("RemindersTest", remindersUri.toString())
                if (eventdialogView != null) {
                    eventdialogView.btnOk.makeVisible()
                    eventdialogView.btnAddEvent.makeGone()
                    eventdialogView.img_close.makeGone()
                    eventdialogView.imgEventAdded.makeVisible()
                    eventdialogView.txtEventAdded.makeVisible()
                }
            } catch (e: Exception) {
                LogUtils.logE(classTag, e)
            }
        } catch (e: java.lang.Exception) {
            LogUtils.logE(classTag, e)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            val showRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(
                    context as BottomNavigationActivity,
                    permissions[0]
                )
            if (!showRationale) {
                val snackBar = Snackbar.make(
                    view,
                    getString(R.string.permission_calendar),
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
                    requestPermissions(
                        REQUIRED_PERMISSIONS,
                        REQUEST_CODE_PERMISSIONS
                    )
                    snackBar.dismiss()
                }
                snackBar.show()
            }

        } else if (requestCode == REQUEST_CODE_PERMISSIONS && allPermissionsGranted(context!!)) {

            setReminder(
                getString(R.string.inspection_scheduled),
                "",
                orderDetail.appointmentDate + "" + selectedTimeSlot,
                orderDetail.displayAddressInfo
            )
        }


    }

    inner class Timeadapter(val context: Context, val timingList: ArrayList<String>) :
        RecyclerView.Adapter<Timeadapter.ViewHolder>() {
        var lastClickedPosition = -1

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val txtTiming = view.txtTiming
            val linearLayoutCompat = view.linearLayoutCompat
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val gridView =
                LayoutInflater.from(context).inflate(R.layout.row_choose_time, parent, false)
            return ViewHolder(gridView)
        }

        override fun getItemCount(): Int {
            return timingList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txtTiming.text = timingList.get(position)
            holder.linearLayoutCompat.setOnClickListener {
                lastClickedPosition = position
                // holder.linearLayoutCompat.setBackgroundResource(R.drawable.back_button_new)
                notifyDataSetChanged()
                selectedTimeSlot = timingList.get(position)
            }
            if (position != lastClickedPosition) {
                holder.linearLayoutCompat.setBackgroundResource(R.drawable.back_btn_home)
                holder.txtTiming.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.colorPrimary
                    )
                )
            } else {
                holder.linearLayoutCompat.setBackgroundResource(R.drawable.back_button_new)
                holder.txtTiming.setTextColor(
                    Color.WHITE
                )
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.linearAddress -> {
                orderDetail?.let {
                    val mapIntent = CommonUtils.getMapIntent(it.lat, it.lng)
                    if (mapIntent.resolveActivity(context!!.packageManager) != null) {
                        context!!.startActivity(mapIntent)
                    }
                }

            }
            R.id.linearProduct -> {
                orderDetail?.let {
                    val url =
                        BuildConfig.HOST + "mobile/Dashboard/GetDownloadOLEDocument?OrderGenID=" + it.orderGenId + "&ItemSrNo=" + it.itemSrNo + "&UserId=" + it.userId + "&ServiceRequestType=" +
                                it.serviceRequestType
                    val browserIntent = Intent(Intent.ACTION_VIEW)
                    browserIntent.setDataAndType(Uri.parse(url), "application/pdf")
                    context!!.startActivity(browserIntent)

                }


            }
            R.id.btnAccept -> {
                if (orderDetail.isAssigned == 1) {

                    itemIdList.add(itemId)
                    confirmOrder()
                } else if (orderDetail.isAssigned == 0 && isValid()) {
                    unassignedItemId.add(itemId)
                    confirmOrder()
                }
            }
            R.id.btnDecline -> {
                declineOrder()

            }
        }
    }

    private fun declineOrder() {
        if (orderDetail.isAssigned == 1) {
            itemIdList.add(itemId)
            selectedOrderList.add(orderDetail)
            orgIds.add(orderDetail.orgId)
            /*  (context as BottomNavigationActivity).pushFragment(
                      ConditnlAcceptOrderFragment.newInstance(
                              getString(R.string.rejectOrders),
                              selectedOrderList,
                              itemIdList,
                              orgIds
                      ), true
              )*/
            (context as BottomNavigationActivity).pushFragment(
                NewOrderRejectFragment.newInstance(selectedOrderList.get(0)), true
            )
        } else {
            view.snack(getString(R.string.decline_restrictn_msg)) {}
        }
    }

    private fun isValid(): Boolean {
        //For Unassigned order we need to select appointment time slots.
//        if (selectedTimeSlot.equals("")) {
//            CommonUtils.showOkDialog(
//                    context!!,
//                    getString(R.string.error_choose_time),
//                    DialogInterface.OnClickListener { _, _ ->
//                    },
//                    "ok"
//            )
//            return false
//        }
        return true
    }
}
