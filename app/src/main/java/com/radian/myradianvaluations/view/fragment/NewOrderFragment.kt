package com.radian.myradianvaluations.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.adapter.NewOrdersAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.NewOrderViewModel
import com.radian.vendorbridge.Response.NewOrderResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_new_orders.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewOrderFragment : Fragment() {
    internal lateinit var view: View
    private val newOrderList = ArrayList<NewOrderResponse.Data.OrderResponse>()
    private val classTag = NewOrderFragment::class.java.canonicalName!!
    private lateinit var newOrderViewModel: NewOrderViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_new_orders, container, false)
        view.recyclerView.adapter = NewOrdersAdapter(context!!, newOrderList)
        newOrderViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(NewOrderViewModel::class.java)
        newOrderViewModel.init(context as BottomNavigationActivity)
        showToolbarIcons(getString(R.string.new_orders))
        getOrderList()
        return view
    }

    private fun showToolbarIcons(title: String) {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = title
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.VISIBLE

    }

    private fun getOrderList() {
        newOrderViewModel.getOrderList().let {
            LoadingDialog.show(context as BottomNavigationActivity)
            it?.observe(context as BottomNavigationActivity, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status == APIStatus.ok) {
                    newOrderList.clear()
                    newOrderList.addAll(it.mdata?.orderList!!)
                    view.recyclerView.adapter?.notifyDataSetChanged()
                    if (newOrderList.isEmpty()) {
                        view.txtNoNewOrdr.visibility = View.VISIBLE
                        view.txtNoNewOrdrDetail.visibility = View.VISIBLE
                        (context as BottomNavigationActivity).bottomview?.let {
                            (context as BottomNavigationActivity).removeBadge(
                                it,
                                R.id.action_new
                            )
                        }
                    } else {
                        view.txtNoNewOrdr.visibility = View.GONE
                        view.txtNoNewOrdrDetail.visibility = View.GONE
                    }
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
}