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
import com.radian.myradianvaluations.Response.NewOrderResponse
import com.radian.myradianvaluations.adapter.NewOrdersAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.NewOrderViewModel
import com.radian.myradianvaluations.viewmodel.NewOrdrViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_new_orders.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewOrderFragment : Fragment() {
    internal lateinit var view: View
    private val newOrderList = ArrayList<NewOrderResponse.Data.OrderResponse>()
    private val classTag = NewOrderFragment::class.java.canonicalName!!
    private lateinit var newOrderViewModel: NewOrderViewModel
    private lateinit var factory: NewOrdrViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_new_orders, container, false)
        view.recyclerView.adapter = NewOrdersAdapter(context!!, newOrderList)
//        newOrderViewModel =
//                ViewModelProvider(context as BottomNavigationActivity).get(NewOrderViewModel::class.java)
//        newOrderViewModel.init(context as BottomNavigationActivity)
        showToolbarIcons(getString(R.string.new_orders))
        initViewModel()
        getOrderList()
        observeNewOrder()

        return view
    }

    private fun initViewModel() {
        factory = NewOrdrViewModelFactory(context!!)
        newOrderViewModel = ViewModelProvider(this, factory).get(NewOrderViewModel::class.java)
    }

    private fun observeNewOrder() {
        newOrderViewModel.newOrderResponse.observeOnce(viewLifecycleOwner, Observer {
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
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    private fun showToolbarIcons(title: String) {
        (context as BottomNavigationActivity).layout_toolbar.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).imgBack.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = title
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.VISIBLE

    }

    private fun getOrderList() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        newOrderViewModel.getNewOrderList(postParam)

    }
}