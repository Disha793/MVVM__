package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderDetailResponse
import com.radian.myradianvaluations.Response.OrderRevisionResponse
import com.radian.myradianvaluations.adapter.OrderRevisionRequestAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.*
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_order_revision_request.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.row_order_detail.view.*

class OrderRevisionRequestFragment : Fragment() {
    private var revisionList = ArrayList<OrderRevisionResponse.TileOrderRevision>()
    private var itemId = 0
    internal lateinit var view: View
    private val classTag = this.javaClass.name
    private var orderDetaiList = ArrayList<OrderDetailResponse.Orderdetail>()
    private lateinit var orderRevisionViewModel: OrderRevisionRequestViewModel
    private lateinit var factory: OrderRevisionRequestViewModelFactory

    companion object {
        fun newInstance(itemId: Int): OrderRevisionRequestFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment =
                OrderRevisionRequestFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_order_revision_request, container, false)
        setToolbar()
        initViewModel()
        observeRevisionData()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (arguments != null) {
            itemId = arguments?.getInt(Const.itemIdTag)!!
        }

        getOrderRevision()

    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).txtClear.makeGone()
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.revisionTitle)
        (context as BottomNavigationActivity).imgBack.makeVisible()
    }

    private fun initViewModel() {
        factory = OrderRevisionRequestViewModelFactory(context!!)
        orderRevisionViewModel =
            ViewModelProvider(this, factory).get(OrderRevisionRequestViewModel::class.java)

    }

    private fun getOrderRevision() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("Itemid", itemId)
        orderRevisionViewModel.getOrderRevisionList(postParam)
    }

    private fun observeRevisionData() {
        orderRevisionViewModel.orderRevisionResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                revisionList.addAll(it.data?.tileOrderRevision!!)
                if (it.data?.orderDetail != null)
                    orderDetaiList.add(it.data?.orderDetail!!)
                view.recyclerview.adapter =
                    OrderRevisionRequestAdapter(
                        context!!,
                        revisionList
                    )
                if (revisionList.isEmpty()) {
                    view.txtNoRevisionMsg.makeVisible()
                    view.txtNoRevisionMsg.text = getString(R.string.no_revision_found)
                } else {
                    view.txtNoRevisionMsg.makeGone()
                }
                view.recyclerview.adapter?.notifyDataSetChanged()

                setOrderDetailData()

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
    }

    private fun setOrderDetailData() {
        if (orderDetaiList != null && orderDetaiList.isNotEmpty()) {
            view.orderId.setText(orderDetaiList.get(0).orderGenId.toString())
            view.txtProductname.setText(orderDetaiList.get(0).product)
            view.txtname.setText(orderDetaiList.get(0).diplayBorrowerInfo)
            view.txtAdd.setText(orderDetaiList.get(0).displayAddressInfo)
            view.txtOrderCode.setText(orderDetaiList.get(0).displayLoanInfo)
        }
    }
}