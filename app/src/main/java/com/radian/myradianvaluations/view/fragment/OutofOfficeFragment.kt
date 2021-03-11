package com.radian.myradianvaluations.view.fragment

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.OfficeViewModel
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_out_of_office.*
import kotlinx.android.synthetic.main.fragment_out_of_office.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.text.SimpleDateFormat
import java.util.*

class OutofOfficeFragment : Fragment(), View.OnClickListener {
    private var cal = Calendar.getInstance()
    private val tagStrt = 100
    private val tagEnd = 101
    private var tag = 0
    internal lateinit var view: View
    private val TAG = OutofOfficeFragment::class.java.canonicalName
    private lateinit var dateListener: DatePickerDialog.OnDateSetListener
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var officeViewModel: OfficeViewModel
    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.txtCancel -> {

                (context as BottomNavigationActivity).onBackPressed()
            }
            R.id.txtConfirm -> {
                if (isValid()) {
                    saveVendorVacationInfo()

                }

            }
            R.id.edtStrtDate -> {
                tag = tagStrt
                showDatePickerDialog(0)
            }
            R.id.edtEndDate -> {
                tag = tagEnd
                if (!TextUtils.isEmpty(edtStrtDate.text.toString())) {
                    var time = CommonUtils.convertStringtoDate(
                        edtStrtDate.text.toString(), SimpleDateFormat(
                            Const.formatMMM,
                            Locale.US
                        )
                    ).time
                    showDatePickerDialog(time)
                } else {
                    CommonUtils.displayMessage(
                        relativeMain,
                        context!!.resources.getString(R.string.error_enter_strt_dte)
                    )
                }
            }

        }


    }

    private fun saveVendorVacationInfo() {
        var startDate = CommonUtils.convertStringtoDate(
            edtStrtDate.text.toString(),
            SimpleDateFormat(Const.formatMMM)
        )
        var endDate =
            CommonUtils.convertStringtoDate(
                edtEndDate.text.toString(),
                SimpleDateFormat(Const.formatMMM)
            )
        LoadingDialog.show(context as BottomNavigationActivity)
        officeViewModel.saveOutOfOffice(
            CommonUtils.convertDatetoString(startDate, SimpleDateFormat(Const.formatMM)),
            CommonUtils.convertDatetoString(endDate, SimpleDateFormat(Const.formatMM)),
            edtNote.text.toString()
        ).let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, true)) {

                    CommonUtils.displayMessageAction(
                        view,
                        it.data.message,
                        "ok",
                        View.OnClickListener {
                            (context as BottomNavigationActivity).onBackPressed()
                        })

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
                LoadingDialog.dismissDialog()
            })
            if (it == null) {
                LoadingDialog.dismissDialog()
                CommonUtils.displayMessage(
                    view,
                    getString(R.string.please_try_again)
                )
            }

        }
    }

    private fun isValid(): Boolean {
        if (TextUtils.isEmpty(edtStrtDate.text.toString())) {
            CommonUtils.displayMessage(
                view,
                context!!.resources.getString(R.string.error_enter_strt_dte)
            )
            return false
        } else if (TextUtils.isEmpty(edtEndDate.text.toString())) {
            CommonUtils.displayMessage(
                view,
                context!!.resources.getString(R.string.error_enter_end_dte)
            )
            return false
        } else if (TextUtils.isEmpty(edtNote.text.toString())) {
            CommonUtils.hideKeybord(
                (context as BottomNavigationActivity).window.decorView.rootView,
                context!!
            )
            CommonUtils.displayMessage(
                view,
                context!!.resources.getString(R.string.error_enter_note)
            )
            return false
        }
        return true
    }

    private fun showDatePickerDialog(minDate: Long) {

        var datePickerDialog = DatePickerDialog(
            context!!,
            dateListener,
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)

        )

        datePickerDialog.datePicker.minDate = minDate
        datePickerDialog.show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbar()
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "OutOfOffice")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        view.txtCancel.setOnClickListener(this)
        view.txtConfirm.setOnClickListener(this)
        view.edtStrtDate.setOnClickListener(this)
        view.edtEndDate.setOnClickListener(this)
        dateListener = DatePickerDialog.OnDateSetListener { p0, year, month, day ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.DAY_OF_MONTH, day)

            if (tag == tagStrt) {
                edtStrtDate.setText(
                    SimpleDateFormat(
                        Const.formatMMM,
                        Locale.US
                    ).format(cal.time)
                )

            } else if (tag == tagEnd) {
                edtEndDate.setText(
                    SimpleDateFormat(
                        Const.formatMMM,
                        Locale.US
                    ).format(cal.time)
                )
            }
        }
        CommonUtils.hideKeybord(
            (context as BottomNavigationActivity).window.decorView.rootView,
            context!!
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_out_of_office, container, false)
        officeViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(OfficeViewModel::class.java)
        officeViewModel.init(context as BottomNavigationActivity)
        return view
    }

    fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.outOfOfiice)
    }
}