package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderDetailResponse
import com.radian.myradianvaluations.Response.OrderDocResponse
import com.radian.myradianvaluations.adapter.OrderDocListAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.interfaces.ListItemClickListener
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.OrderDocumentListViewModel
import com.radian.myradianvaluations.viewmodel.OrderDocumentListViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_document_list.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class OrderDocumentListFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    private val classTag = this.javaClass.name
    private var itemId = 0
    private var docList = ArrayList<OrderDocResponse.TileOrder>()
    lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private var orderDetail = OrderDetailResponse.Orderdetail()
    private lateinit var orderDocumentListViewModel: OrderDocumentListViewModel
    private lateinit var factory: OrderDocumentListViewModelFactory
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_document_list, container, false)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        initViewModel()
        setToolbar()
        observeData()
        listItemClick()
        view.linearLoe.setOnClickListener(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.let {
            it.getInt(Const.itemIdTag)?.let {
                itemId = it
            }
        }
        getDocuments()
    }

    private fun initViewModel() {
        factory = OrderDocumentListViewModelFactory(context!!)
        orderDocumentListViewModel = ViewModelProvider(this, factory).get(OrderDocumentListViewModel::class.java)
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.lbl_documents)
    }

    private fun listItemClick() {
        view.recyclerViewDocument.adapter = OrderDocListAdapter(object : ListItemClickListener {
            override fun onItemClick(position: Int) {
                markAsRead(docList, position)
                firebaseParams.clear()
                firebaseParams.putString(Const.screenLaunched, "DocumentViewer_Launched")
                CommonUtils.addParamstoFirebaseEvent(
                        firebaseAnalytics,
                        Const.screenLaunched,
                        firebaseParams
                )
                val url =
                        BuildConfig.HOST + "mobile/Dashboard/GetDownloadDocument?DocId=" + docList[position].documentId + "&Name=" + docList[position].documentName + "&UserId=" + docList[position].userId
                val browserIntent = Intent(Intent.ACTION_VIEW)
                browserIntent.setDataAndType(Uri.parse(url), "application/pdf")
                context!!.startActivity(browserIntent)
            }
        }, docList, context!!)
    }

    private fun observeData() {
        orderDocumentListViewModel.orderDocListResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                it.data?.tileorderdetails?.let {
                    docList.addAll(it)
                    view.recyclerViewDocument.adapter?.notifyDataSetChanged()
                }
                it.data?.orderDetail?.let {
                    orderDetail = it
                }
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        })
        orderDocumentListViewModel.docMarkReadResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }

        })
    }

    private fun getDocuments() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        postParam.put("Itemid", itemId)
        orderDocumentListViewModel.getOrderDocuments(postParam)
    }

    companion object {
        fun newInstance(
                itemId: Int
        ): OrderDocumentListFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment = OrderDocumentListFragment()
            fragment.arguments = args
            return fragment
        }
    }


    private fun markAsRead(
            docList: ArrayList<OrderDocResponse.TileOrder>,
            position: Int
    ) {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString())
        postParam.put("DocumentIds", docList.get(position).documentId)
        postParam.put("UserIds", docList.get(position).userId)
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString())
        orderDocumentListViewModel.markAsRead(postParam)
    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.linearLoe -> {
                val url =
                        BuildConfig.HOST + "mobile/Dashboard/GetDownloadOLEDocument?OrderGenID=" + orderDetail.orderGenId + "&ItemSrNo=" + orderDetail.itemSrNo + "&UserId=" +
                                orderDetail.userId + "&ServiceRequestType=" + orderDetail.serviceRequestType
                val browserIntent = Intent(Intent.ACTION_VIEW)
                browserIntent.setDataAndType(Uri.parse(url), "application/pdf")
                context!!.startActivity(browserIntent)
            }
        }
    }
}