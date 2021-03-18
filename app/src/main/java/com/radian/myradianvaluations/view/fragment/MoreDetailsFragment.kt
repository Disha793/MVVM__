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
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.ManageOrderResponse
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_more_details.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MoreDetailsFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    private val REQUEST_CODE = 101
    private var orderDetail = ManageOrderResponse.Data.OrderDetail()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_more_details, container, false)
        view.linearCall.setOnClickListener(this)
        view.linearEmail.setOnClickListener(this)
        setToolbar()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            orderDetail =
                    it.getParcelable<ManageOrderResponse.Data.OrderDetail>(Const.itemIdTag) as ManageOrderResponse.Data.OrderDetail
        }
        setMoreData()
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.moreDetailsTitle)
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
    }

    private fun setMoreData() {
        view.txtMoreProduct.text = showLabel(orderDetail.productName)
        view.txtMoreOrderId.text = showLabel(orderDetail.orderGenId)
        view.txtMoreLoanId.text = showLabel(orderDetail.displayLoanInfo)
        view.txtMoreClient.text = showLabel(orderDetail.clientName)
        view.txtMorePhn.text = showLabel(orderDetail.borrowerPhone?.let {
            CommonUtils.formatNumber(it)
        })
        view.txtMoreEmail.text = showLabel(orderDetail.borrowerEmail)
        view.txtMoreBorrwr.text = showLabel(orderDetail.borrowerName)
    }

    private fun showLabel(value: String?): String {
        if (value.isNullOrEmpty())
            return "NA"
        else
            return value
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
                                    context as BottomNavigationActivity, permission)
                    if (!showRationale) {
                        val snackBar = Snackbar.make(
                                view, getString(R.string.permission_call), Snackbar.LENGTH_LONG)
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

    override fun onClick(v: View?) {
        when (v?.id) {
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
                if (!orderDetail.borrowerEmail.isNullOrEmpty()) {
                    val emailIntent = Intent(
                            Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto", "" + orderDetail.borrowerEmail, null)
                    )
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
                    startActivity(Intent.createChooser(emailIntent, "Send email..."))
                }

            }
        }
    }

    private fun requestPermission() {
        requestPermissions(
                arrayOf(
                        Manifest.permission.CALL_PHONE
                ),
                REQUEST_CODE
        )

    }

    companion object {
        fun newInstance(orderDetail: ManageOrderResponse.Data.OrderDetail): MoreDetailsFragment {
            val args = Bundle()
            args.putParcelable(Const.itemIdTag, orderDetail)
            val fragment = MoreDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}