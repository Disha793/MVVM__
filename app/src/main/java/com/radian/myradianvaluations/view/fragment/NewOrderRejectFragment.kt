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
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.RejectOrderViewModel
import com.radian.myradianvaluations.viewmodel.RejectViewModelFactory
import com.radian.vendorbridge.Response.NewOrderDetailResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_new_order_reject.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class NewOrderRejectFragment : Fragment(), View.OnClickListener {
    private var iteamID: Int = 0
    internal lateinit var view: View
    private lateinit var rejectOrderViewModel: RejectOrderViewModel
    private lateinit var factory: RejectViewModelFactory
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_new_order_reject, container, false)
        setToolbar()
        initViewModel()
        getData()
        observeData()
        return view
    }

    private fun initViewModel() {
        factory = RejectViewModelFactory(context!!)
        rejectOrderViewModel = ViewModelProvider(this, factory).get(RejectOrderViewModel::class.java)
    }

    private fun observeData() {

        rejectOrderViewModel.rejectOrderResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                (context as BottomNavigationActivity).onBackPressed()
                (context as BottomNavigationActivity).onBackPressed()
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text =
                resources.getString(R.string.rejectOrders)
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.text = "Confirm"
        (context as BottomNavigationActivity).txtClear.setOnClickListener(this)
    }

    private fun getData() {

        arguments?.let {
            it.getParcelable<NewOrderDetailResponse.Data.OrderDetail>(
                    Const.detailData
            )?.let {
                setData(it)


            }
        }
    }

    companion object {
        fun newInstance(detailData: NewOrderDetailResponse.Data.OrderDetail): NewOrderRejectFragment {
            val args = Bundle()
            args.putParcelable(Const.detailData, detailData)
            val fragment = NewOrderRejectFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private fun setData(orderDetail: NewOrderDetailResponse.Data.OrderDetail) {
        iteamID = orderDetail.itemId
        view.orderId.text = orderDetail.orderGenId
        view.txtProductname.text = orderDetail.productName
        view.txtname.text = orderDetail.borrowerName
        view.txtAdd.text = orderDetail.displayAddressInfo
    }

    override fun onClick(p0: View?) {
        val postParams = HashMap<String, Any?>()
        postParams.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParams.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("ItemIds", iteamID)

//        postParams.put("ItemNotes", noteList)
        postParams.put("ActionType", "R")
        rejectOrderViewModel.rejectOrder(postParams)
    }
}



