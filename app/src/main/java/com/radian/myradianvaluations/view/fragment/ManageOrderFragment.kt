package com.radian.myradianvaluations.view.fragment

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.PhotoUploadFragment
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.ManageOrderResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.*
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.view.activity.StepsActivity
import com.radian.myradianvaluations.viewmodel.ManageOrderModelFactory
import com.radian.myradianvaluations.viewmodel.ManageOrderViewModel
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_manage_order.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import java.util.*
import kotlin.collections.HashMap

class ManageOrderFragment : Fragment(), View.OnClickListener {
    private lateinit var actionType: String
    internal lateinit var view: View
    private val REQUEST_CODE = 101
    private var itemId = 0
    private val classTag = this::class.java.canonicalName!!
    private var orderDetail = ManageOrderResponse.Data.OrderDetail()
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var manageOrderViewModel: ManageOrderViewModel
    private lateinit var factory: ManageOrderModelFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_manage_order, container, false)
        view.linearAppt.setOnClickListener(this)
        view.linearMore.setOnClickListener(this)
        view.linearAddress.setOnClickListener(this)
        view.linearCall.setOnClickListener(this)
        view.linearEmail.setOnClickListener(this)
        view.linearDocument.setOnClickListener(this)
        view.linearMessages.setOnClickListener(this)
        view.linearRevisions.setOnClickListener(this)
        view.linearLOE.setOnClickListener(this)
        view.btnMark.setOnClickListener(this)
        initViewModel()
        setToolbar()
        observeData()
        return view
    }

    private fun observeData() {
        manageOrderViewModel.manageOrderResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status == APIStatus.ok) {
                orderDetail = it.data.orderDetail
                setOrderDetail(orderDetail)
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
//For Mark as read Revision Request
        manageOrderViewModel.markOrderResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status == APIStatus.ok) {
                //on success
                if (actionType == "R") {
                    LogUtils.logD(classTag, resources.getString(R.string.success))

                } else if (actionType == "N") {
                    LogUtils.logD(classTag, resources.getString(R.string.success))
                }

            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "ManageOrder_Launched")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        arguments?.let {
            itemId = it.getInt(Const.itemIdTag)
        }
        getManageOrder()
    }

    private fun initViewModel() {
        factory = ManageOrderModelFactory(context!!)
        manageOrderViewModel =
            ViewModelProvider(this, factory).get(ManageOrderViewModel::class.java)
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).imgBack.makeVisible()
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.title_manage_order)
        (context as BottomNavigationActivity).txtClear.makeGone()
    }

    private fun getManageOrder() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("Itemid", itemId)

        manageOrderViewModel.getOrderDetail(postParam)
    }

    private fun setOrderDetail(orderDetail: ManageOrderResponse.Data.OrderDetail) {
        view.txtAdd.text = orderDetail.displayAddressInfo
        if (!orderDetail.lockbox.isNullOrBlank()) {
            view.txtLockBox.makeGone()
            view.txtLockBox.text = orderDetail.lockbox
        } else {
            view.txtLockBox.makeGone()
        }
        orderDetail.pointOfContactName.let {
            view.txtValContact.text = setValue(orderDetail.pointOfContactName)
        }
        view.txtValCall.text = setValue(orderDetail.pointOfContanctPhone?.let {
            CommonUtils.formatNumber(it)
        })
        orderDetail.pointOfContactEmail.let {
            view.txtValEmail.text = setValue(orderDetail.pointOfContactEmail)
        }
        view.txtValAppt.text = setValue(orderDetail.appointmentStatus)
        if (orderDetail.newDocumentFlag) {
            view.imgDotDoc.makeVisible()
            view.txtnewdoc.makeVisible()
        } else {
            view.imgDotDoc.makeInvisible()
            view.txtnewdoc.makeInvisible()
        }
        if (orderDetail.newNoteCountFlag) {
            view.imgDotMsg.makeVisible()
            view.txtnewmsg.makeVisible()
        } else {
            view.imgDotMsg.makeInvisible()
            view.txtnewmsg.makeInvisible()
        }
        if (orderDetail.newRevisionFlag) {
            view.imgDotRevision.makeVisible()
            view.txtnewreq.makeVisible()
        } else {
            view.imgDotRevision.makeInvisible()
            view.txtnewreq.makeInvisible()
        }
//        if (orderDetail.isNotify!!) {
//            view.btnMark.makeVisible()
//            orderDetail.borrowerName?.let {
//                view.btnMark.text = "Let " + it + " know I'm on the way"
//            }
//        } else {
//            view.btnMark.makeGone()
//        }
//        if (orderDetail.isComplete!!) {
//            view.btnMark.makeVisible()
//            view.btnMark.text = "Mark this inspection complete"
//        }
        view.btnMark.makeVisible()
        view.btnMark.text = resources.getString(R.string.photo_upload)
    }

    private fun setValue(value: String?): String {
        if (value.isNullOrBlank())
            return "NA"
        else
            return value
    }

    companion object {
        fun newInstance(itemId: Int): ManageOrderFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment = ManageOrderFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private fun completeInspection() {
        //Api name:  "mobile/Dashboard/AddEditInspection"   Response Type: StatusResponse
//        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
//        postParam.put("DeviceID", Utils.getDeviceUUID(context!!))
//        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
//        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
//        postParam.put(
//            "AppointmentDate",
//            orderDetail.appointmentDate + " " + orderDetail.appointmentTime
//        )
//        postParam.put("Notes", "")
//        postParam.put("ItemId", itemId.toString())
//        postParam.put("ActionType", "C")
//        postParam.put("TimeZone", TimeZone.getDefault().id)

//on Sucess       if (it.status.equals(APIStaus.ok, true)) {
//            view.btnMark.makeGone()
//        } else if (t.status.equals(APIStatus.unauth, true)) {
//            Toast.makeText(
//                context!!,
//                t.errorInfo.get(0).errorMessage,
//                Toast.LENGTH_SHORT
//            ).show()
//            var intent = Intent(context!!, AccesscodeActivity::class.java)
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            startActivity(intent)
//        }
        //  }

    }

    private fun notifyBorrower() {
        //
//Api name:  "Mobile/Dashboard/NotifyBorrower"   Response Type: NotiStatusResponse
//  Params:      postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
//        postParam.put("DeviceID", Utils.getDeviceUUID(context!!))
//        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
//        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
//        postParam.put("ItemId", itemId.toString())
//  on Sucess:       if (it.status.equals(APIStatus.ok, true)) {
//
//            Utils.showOkDialog(
//                context!!,
//                t.message.toString(),
//                DialogInterface.OnClickListener { _, _ ->
//                    getManageOrder()
//                },
//                "Ok"
//            )
//
//        } else if (t.status.equals(APIStatus.unauth, true)) {
//            Toast.makeText(
//                context!!,
//                t.errorInfo.get(0).errorMessage,
//                Toast.LENGTH_SHORT
//            ).show()
//            var intent = Intent(context!!, AccesscodeActivity::class.java)
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//            startActivity(intent)
//        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.linearAppt -> {
//Appointment Click
//                (context as BottomNavigationActivity).pushFragment(
//                    OrderAppointmentFragment.newInstance(
//                        orderDetail
//                    ), true
//                )
            }
            R.id.linearMore -> {
                (context as BottomNavigationActivity).pushFragment(
                    MoreDetailsFragment.newInstance(
                        orderDetail
                    ), true
                )
            }
            R.id.linearAddress -> {
                if (orderDetail.lat != null && orderDetail.lng != null) {
                    val mapIntent = CommonUtils.getMapIntent(orderDetail.lat!!, orderDetail.lng!!)
                    if (mapIntent.resolveActivity(context!!.getPackageManager()) != null) {
                        context!!.startActivity(mapIntent)
                    }
                }
            }
            R.id.linearLOE -> {
                val url =
                    BuildConfig.HOST + "mobile/Dashboard/GetDownloadOLEDocument?OrderGenID=" + orderDetail.orderGenId + "&ItemSrNo=" + orderDetail.itemSrNo + "&UserId=" +
                            orderDetail.userId + "&ServiceRequestType=" + orderDetail.serviceRequestType
                val browserIntent = Intent(Intent.ACTION_VIEW)
                browserIntent.setDataAndType(Uri.parse(url), "application/pdf")
                context!!.startActivity(browserIntent)
            }
            R.id.linearCall -> {
                if (!orderDetail.borrowerPhone.isNullOrBlank()) {
                    if (CommonUtils.checkCallPermission(context!!)) {
                        CommonUtils.showDialog(
                            context!!,
                            getString(R.string.call_dialog_title),
                            DialogInterface.OnClickListener { _, _ ->
                                makePhoneCall()
                            },
                            DialogInterface.OnCancelListener { _ -> },
                            "Yes",
                            "No"
                        )
                    } else {
                        requestPermission()
                    }
                }

            }
            R.id.linearEmail -> {
                if (!orderDetail.borrowerEmail.isNullOrEmpty()) {
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
            R.id.linearDocument -> {
                (context as BottomNavigationActivity).pushFragment(
                    OrderDocumentListFragment.newInstance(
                        orderDetail.itemId!!
                    ), true
                )
            }
            R.id.linearMessages -> {
                if (orderDetail.newNoteCountFlag) {
                    actionType = "N"
                    markAsReadRequest()
                }
                (context as BottomNavigationActivity).pushFragment(
                    MessageChatFragment.newInstance(
                        orderDetail.orderGenId!!,
                        orderDetail.itemId
                    ), true
                )
            }
            R.id.linearRevisions -> {
                if (orderDetail.newRevisionFlag) {
                    actionType = "R"
                    markAsReadRequest()
                }
//                (context as BottomNavigationActivity).pushFragment(
//                    OrderRevisionRequestFragment.newInstance(orderDetail.itemId!!),
//                    true
//                )
            }
            R.id.btnMark -> {
                //Appointment Related things
//                if (orderDetail.isComplete!!) {
//                    completeInspection()
//                } else if (orderDetail.isNotify!!) {
//                    notifyBorrower()
//                }
                //Currently btnMArk renamed to photo upload below is photo upload activity
                (context as BottomNavigationActivity).pushFragment(PhotoUploadFragment(), true)
            }
        }
    }

    private fun makePhoneCall() {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data =
            Uri.parse("tel:" + orderDetail.borrowerPhone)
        startActivity(intent)
    }

    private fun requestPermission() {

        requestPermissions(
            arrayOf(
                Manifest.permission.CALL_PHONE
            ),
            REQUEST_CODE
        )
    }

    private fun markAsReadRequest() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("ActionType", actionType)
        postParam.put("Itemid", itemId)
        postParam.put("Orderid", orderDetail.orderGenId)
        manageOrderViewModel.markAsReadRevision(postParam)
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
                (context as BottomNavigationActivity).pushFragment(
                    MessageChatFragment.newInstance(
                        orderDetail.orderGenId!!,
                        orderDetail.itemId
                    ), true
                )
            }
        }

    }
}