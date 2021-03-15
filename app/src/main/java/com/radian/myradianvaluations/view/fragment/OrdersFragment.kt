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
import com.radian.myradianvaluations.adapter.OrdersAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.interfaces.OpenOrderClickListener
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.OrdersViewModel
import com.radian.vendorbridge.Response.OrderListResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_orders.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrdersFragment : Fragment() {
    internal lateinit var view: View
    private val classTag = this::class.java.canonicalName!!
    private val orderList = ArrayList<OrderListResponse.Data.OrderDetail>()
    private lateinit var orderViewModel: OrdersViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_orders, container, false)
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.VISIBLE
        orderViewModel =
                ViewModelProvider(context as BottomNavigationActivity).get(OrdersViewModel::class.java)
        orderViewModel.init(context as BottomNavigationActivity)
        view.recyclerView.adapter = OrdersAdapter(context!!, object : OpenOrderClickListener {
            override fun onOpenOrderClick(position: Int) {
                (context as BottomNavigationActivity).pushFragment(
                        ManageOrderFragment.newInstance(
                                orderList.get(position).itemId!!
                        ), true
                )
            }

        }, orderList)
        showToolbarIcons(getString(R.string.open_orders))
        //Disha: For next release
//        getOrderList()
        return view
    }

    private fun showToolbarIcons(title: String) {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = title
    }

    private fun getOrderList() {
        orderViewModel.getOrderList().let {
            LoadingDialog.show(context!!)
            it?.observe(context as BottomNavigationActivity, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status == APIStatus.ok) {
                    orderList.clear()
                    orderList.addAll(it.data.orderDetails)
                    view.recyclerView.adapter?.notifyDataSetChanged()
                    if (orderList.isEmpty()) {
                        view.txtNoOpenOrdr.visibility = View.VISIBLE
                    } else {
                        view.txtNoOpenOrdr.visibility = View.GONE
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