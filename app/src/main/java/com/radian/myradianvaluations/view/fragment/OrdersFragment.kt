package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderListResponse
import com.radian.myradianvaluations.adapter.OrdersAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.interfaces.ListItemClickListener
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.OrdersViewModel
import com.radian.myradianvaluations.viewmodel.OrdersViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_orders.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrdersFragment : Fragment() {
    internal lateinit var view: View
    private val classTag = this::class.java.canonicalName!!
    private val orderList = ArrayList<OrderListResponse.Data.OrderDetail>()
    private lateinit var orderViewModel: OrdersViewModel
    private lateinit var factory: OrdersViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_orders, container, false)
        (context as BottomNavigationActivity).bottomNavigationView.makeVisible()
        initViewModel()
        showToolbarIcons(getString(R.string.open_orders))
        getOrderList()
        observeOrderList()
        listItemClick()
        return view
    }

    private fun observeOrderList() {

        orderViewModel.orderResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status == APIStatus.ok) {
                orderList.clear()
                orderList.addAll(it.data.orderDetails)
                view.recyclerView.adapter?.notifyDataSetChanged()
                if (orderList.isEmpty()) {
                    view.txtNoOpenOrdr.makeVisible()
                } else {
                    view.txtNoOpenOrdr.makeGone()
                }
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    private fun listItemClick() {
        view.recyclerView.adapter = OrdersAdapter(context!!, object : ListItemClickListener {
            override fun onItemClick(position: Int) {
                (context as BottomNavigationActivity).pushFragment(
                        ManageOrderFragment.newInstance(
                                orderList.get(position).itemId!!
                        ), true
                )
            }

        }, orderList)
    }

    private fun initViewModel() {
        factory = OrdersViewModelFactory(context!!)
        orderViewModel = ViewModelProvider(this, factory).get(OrdersViewModel::class.java)
    }

    private fun showToolbarIcons(title: String) {
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).txtClear.makeGone()
        (context as BottomNavigationActivity).imgBack.makeGone()
        (context as BottomNavigationActivity).txtTitle.text = title
    }

    private fun getOrderList() {

        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)

        orderViewModel.getOrderList(postParam)
    }
}