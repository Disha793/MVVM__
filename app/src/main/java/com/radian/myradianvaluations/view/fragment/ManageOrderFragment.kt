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
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.view.activity.StepsActivity
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.ManageOrderViewModel
import com.radian.vendorbridge.Response.ManageOrderResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_manage_order.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlin.collections.HashMap

class ManageOrderFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    private val REQUEST_CODE = 101
    private var itemId = 0
    private val classTag = this::class.java.canonicalName!!
    private var orderDetail = ManageOrderResponse.Data.OrderDetail()
    private var postParam = HashMap<String, Any?>()
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var manageOrderViewModel: ManageOrderViewModel
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
        manageOrderViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(ManageOrderViewModel::class.java)
        manageOrderViewModel.init(context as BottomNavigationActivity)
        setToolbar()

        return view
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

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.title_manage_order)
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE


    }

    private fun getManageOrder() {
        LoadingDialog.show(context as BottomNavigationActivity)
        manageOrderViewModel.getOrderDetail(itemId).let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status ==APIStatus.ok) {
                    orderDetail = it.data.orderDetail
                    setOrderDetail(orderDetail)
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
            if (it == null) {
                LogUtils.logD(classTag, "Error")
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->

                    },
                    getString(R.string.ok)
                )

            }
        }

    }

    private fun setOrderDetail(orderDetail: ManageOrderResponse.Data.OrderDetail) {
        view.txtAdd.text = orderDetail.displayAddressInfo
        if (!orderDetail.lockbox.isNullOrBlank()) {
            view.txtLockBox.visibility = View.VISIBLE
            view.txtLockBox.text = orderDetail.lockbox
        } else {
            view.txtLockBox.visibility = View.GONE
        }
        view.txtValContact.text = setValue(orderDetail.borrowerName)
        view.txtValCall.text = setValue(orderDetail.borrowerPhone?.let {
            CommonUtils.formatNumber(
                it
            )
        })
        view.txtValEmail.text = setValue(orderDetail.borrowerEmail)
        view.txtValAppt.text = setValue(orderDetail.appointmentStatus)
        if (orderDetail.newDocumentFlag) {
            view.imgDotDoc.visibility = View.VISIBLE
            view.txtnewdoc.visibility = View.VISIBLE
        } else {
            view.imgDotDoc.visibility = View.INVISIBLE
            view.txtnewdoc.visibility = View.INVISIBLE
        }
        if (orderDetail.newNoteCountFlag) {
            view.imgDotMsg.visibility = View.VISIBLE
            view.txtnewmsg.visibility = View.VISIBLE
        } else {
            view.imgDotMsg.visibility = View.INVISIBLE
            view.txtnewmsg.visibility = View.INVISIBLE
        }
        if (orderDetail.newRevisionFlag) {
            view.imgDotRevision.visibility = View.VISIBLE
            view.txtnewreq.visibility = View.VISIBLE
        } else {
            view.imgDotRevision.visibility = View.INVISIBLE
            view.txtnewreq.visibility = View.INVISIBLE
        }
//        if (orderDetail.isNotify!!) {
//            view.btnMark.visibility = View.VISIBLE
//            orderDetail.borrowerName?.let {
//                view.btnMark.text = "Let " + it + " know I'm on the way"
//            }
//        } else {
//            view.btnMark.visibility = View.GONE
//        }
//        if (orderDetail.isComplete!!) {
//            view.btnMark.visibility = View.VISIBLE
//            view.btnMark.text = "Mark this inspection complete"
//        }
        view.btnMark.visibility = View.VISIBLE
        view.btnMark.text = "Photo Upload"
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

    }

    private fun notifyBorrower() {

    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.linearAppt -> {

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
                    DocumentListFragment.newInstance(
                        orderDetail.itemId!!
                    ), true
                )
            }
            R.id.linearMessages -> {
                if (orderDetail.newNoteCountFlag) {
                    markAsReadNote()
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
                    markAsReadRevision()
                }
                (context as BottomNavigationActivity).pushFragment(
                        RevisedOrderDetailFragment.newInstance(orderDetail.itemId!!),
                    true
                )
            }
            R.id.btnMark -> {
//                if (orderDetail.isComplete!!) {
//                    completeInspection()
//                } else if (orderDetail.isNotify!!) {
//                    notifyBorrower()
//                }
                val intent = Intent(context, StepsActivity::class.java)
                startActivity(intent)
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

    private fun markAsReadRevision() {
        LoadingDialog.show(context as BottomNavigationActivity)
        manageOrderViewModel.markAsReadRevision(itemId, orderDetail.orderGenId!!).let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status ==APIStatus.ok) {
//on success
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
            if (it == null) {
                LoadingDialog.dismissDialog()
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->

                    },
                    getString(R.string.ok)
                )
            }
        }
    }

    private fun markAsReadNote() {
        markAsReadRevision()
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