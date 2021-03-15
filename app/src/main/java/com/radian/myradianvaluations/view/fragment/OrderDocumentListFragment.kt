package com.radian.myradianvaluations.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.DocumentListViewModel
import com.radian.vendorbridge.Response.OrderDetailResponse
import com.radian.vendorbridge.Response.OrderDocResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_document_list.view.*
import kotlinx.android.synthetic.main.fragment_document_list.view.txtdoc
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.row_document_list.view.*

class OrderDocumentListFragment : Fragment(), View.OnClickListener {
    internal lateinit var view: View
    private var postParam = HashMap<String, Any?>()
    private val classTag = this.javaClass.name
    private var itemId = 0
    private var docList = ArrayList<OrderDocResponse.TileOrder>()
    lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private var orderDetail = OrderDetailResponse.Orderdetail()
    private lateinit var documentListViewModel: DocumentListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_document_list, container, false)
        view.recyclerViewDocument.adapter = DocAdapter(docList)
        documentListViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(DocumentListViewModel::class.java)
        documentListViewModel.init(context as BottomNavigationActivity)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        setToolbar()
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
        //Disha: For next release
//        getDocuments()
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.lbl_documents)
    }

    private fun getDocuments() {
        LoadingDialog.show(context as BottomNavigationActivity)
        documentListViewModel.getDocuments(itemId).let { it1 ->
            it1?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    it.data?.tileorderdetails?.let {
                        docList.addAll(it)
                        view.recyclerViewDocument.adapter?.notifyDataSetChanged()
                    }
                    it.data?.orderDetail?.let {
                        orderDetail = it
                    }


                } else if (it.status.equals(APIStatus.unauth, true)) {
                    Toast.makeText(
                        context!!,
                        it.errorInfo.get(0).errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.flags =
                        Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            })
            if (it1 == null) {
                LoadingDialog.dismissDialog()
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->
                        //Disha: For next release
//                        getDocuments()

                    },
                    getString(R.string.ok)
                )
            }
        }

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

    inner class DocAdapter(private val docList: ArrayList<OrderDocResponse.TileOrder>) :
        RecyclerView.Adapter<DocAdapter.ViewHolder>() {
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val txtDoc = view.txtdoc
            val imgNavigation = view.imgNavigation
            val imgDot = view.imgDot
            val txtNewDoc = view.txtnewdoc
            val linearDocument = view.linearDocument

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.row_document_list, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return docList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.txtDoc.text = docList.get(position).documentName
            if (docList[position].isNewDocument == 1) {
                holder.imgDot.visibility = View.VISIBLE
                holder.txtNewDoc.visibility = View.VISIBLE
            } else {
                holder.imgDot.visibility = View.INVISIBLE
                holder.txtNewDoc.visibility = View.INVISIBLE
            }
            holder.linearDocument.setOnClickListener {
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
        }

        private fun markAsRead(
            docList: ArrayList<OrderDocResponse.TileOrder>,
            position: Int
        ) {
            postParam.clear()
            postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
            postParam.put(
                "MobileUserId",
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
            )
            postParam.put("DocumentIds", docList.get(position).documentId)
            postParam.put("UserIds", docList.get(position).userId)
            postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
            postParam.put(
                "OrganizationIds",
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString()
            )
            LoadingDialog.show(context as BottomNavigationActivity)
            documentListViewModel.markAsRead(postParam).let {
                it?.observe(viewLifecycleOwner, Observer {
                    LoadingDialog.dismissDialog()
                    if (it.status.equals(APIStatus.unauth, true)) {
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
                        context!!.getString(R.string.please_try_again),
                        DialogInterface.OnClickListener { _, _ ->


                        },
                        context!!.getString(R.string.ok)
                    )
                }
            }

        }
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