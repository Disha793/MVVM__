package com.radian.myradianvaluations.view.fragment

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.NewOrdrDetailViewModel
import com.radian.vendorbridge.Response.NewOrderDetailResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_open_order.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.row_conditional_accept_order.view.*
import java.util.*
import kotlin.collections.ArrayList

class ConditnlAcceptOrderFragment : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.txtClear -> {
                CommonUtils.hideKeybord(view, context!!)
                if (isValid()) {

                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "rejectOrdersConfirmTapped")
                    CommonUtils.addParamstoFirebaseEvent(
                        firebaseAnalytics,
                        Const.methodInvoked,
                        firebaseParams
                    )
                    saveRejectOrder()
                }


            }
        }
    }

    internal lateinit var view: View
    private var orderList = ArrayList<NewOrderDetailResponse.Data.OrderDetail>()
    private var title = ""
    private lateinit var dateList: Array<String?>
    private lateinit var priceList: Array<String?>
    private lateinit var noteList: Array<String?>
    private lateinit var rejectnoteList: Array<String?>
    private var organizationIds = ArrayList<Int>()
    private val firebaseParams = Bundle()
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val itemId = ArrayList<Int>()
    private var postParam = HashMap<String, Any?>()
    private val classTag = this.javaClass.canonicalName
    private lateinit var newOrdrViewModel: NewOrdrDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_open_order, container, false)
        newOrdrViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(NewOrdrDetailViewModel::class.java)
//        newOrdrViewModel.init(context as BottomNavigationActivity)
        return view
    }

    companion object {
        fun newInstance(
            title: String,
            orderList: ArrayList<NewOrderDetailResponse.Data.OrderDetail>,
            itemId: ArrayList<Int>,
            orgIds: ArrayList<Int>
        ): ConditnlAcceptOrderFragment {
            val args = Bundle()
            args.putString("title", title)
            args.putParcelableArrayList("orderList", orderList)
            args.putIntegerArrayList("itemIds", itemId)
            args.putIntegerArrayList("orgIds", orgIds)
            val fragment = ConditnlAcceptOrderFragment()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "ConditionalAccept_Launched")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        arguments?.let {
            it.getParcelableArrayList<NewOrderDetailResponse.Data.OrderDetail>(
                "orderList"
            )?.let {
                organizationIds.clear()
                orderList.clear()
                orderList.addAll(
                    it
                )


            }
            it.getIntegerArrayList("itemIds")?.let {
                itemId.clear()
                itemId.addAll(it)
            }
            it.getIntegerArrayList("orgIds")?.let {
                organizationIds.clear()
                organizationIds.addAll(it)

            }


            it.getString("title")?.let {
                title = it
            }

        }


        dateList = arrayOfNulls<String>(orderList.size)
        priceList = arrayOfNulls<String>(orderList.size)
        noteList = arrayOfNulls<String>(orderList.size)
        rejectnoteList = arrayOfNulls<String>(orderList.size)

        view.recycleView.adapter = ConditionalAdapter(context!!, orderList, title)
        setToolbar()
        (context as BottomNavigationActivity).txtClear.setOnClickListener(this)
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
        (context as BottomNavigationActivity).txtTitle.text =
            title
        (context as BottomNavigationActivity).imgBack.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.visibility = View.VISIBLE
        (context as BottomNavigationActivity).txtClear.text = "Confirm"


    }

    private fun isValid(): Boolean {

        for (i in 0..orderList.size - 1) {

            if (TextUtils.isEmpty(rejectnoteList[i])) {
               view.snack(getString(R.string.error_enter_note)) {}
                return false
            }
        }
        return true
    }


    private fun saveRejectOrder() {
        LoadingDialog.show(context as BottomNavigationActivity)
        CommonUtils.hideKeybord(view, context!!)
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
//        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))

//        postParam.put("ItemNotes", noteList)
        postParam.put("ActionType", "R")
//        newOrdrViewModel.rejectOrder(postParam, itemId, rejectnoteList, organizationIds).let {
//            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
//                LoadingDialog.dismissDialog()
//                if (it.status.equals(APIStatus.ok, true)) {
//                    (context as BottomNavigationActivity).onBackPressed()
//                    (context as BottomNavigationActivity).onBackPressed()
//                } else if (it.status.equals(APIStatus.unauth, true)) {
//                    Toast.makeText(
//                        context!!,
//                        it.errorInfo.get(0).errorMessage,
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    var intent = Intent(context!!, PasscodeActivity::class.java)
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                    startActivity(intent)
//                }
//            })
//            if (it == null) {
//                LoadingDialog.dismissDialog()
//                LoadingDialog.dismissDialog()
//                CommonUtils.showOkDialog(
//                    context!!,
//                    getString(R.string.please_try_again),
//                    DialogInterface.OnClickListener { _, _ ->
//
//                    },
//                    getString(R.string.ok)
//                )
//            }
//        }
    }

    inner class ConditionalAdapter(
        context: Context,

        orderList: ArrayList<NewOrderDetailResponse.Data.OrderDetail>,
        title: String
    ) : RecyclerView.Adapter<Viewholder>() {
        val context = context
        val orderList: ArrayList<NewOrderDetailResponse.Data.OrderDetail> = orderList

        val title = title
        var currentPosition = 0

        lateinit var dateListener: DatePickerDialog.OnDateSetListener
        var cal = Calendar.getInstance()
        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Viewholder {

            return Viewholder(
                    LayoutInflater.from(context).inflate(
                            R.layout.row_conditional_accept_order,
                            p0,
                            false
                    )
            )

        }

        override fun getItemCount(): Int {
            return orderList.size
        }

        override fun onBindViewHolder(holder: Viewholder, position: Int) {

            if (title.equals(context.getString(R.string.conditnlAccept))) {
                holder.linearConditional.visibility = View.VISIBLE
                holder.linearReject.visibility = View.GONE
            } else {
                holder.linearReject.visibility = View.VISIBLE
                holder.linearConditional.visibility = View.GONE
            }

            bindData(holder, position)
            holder.edtDate.setOnClickListener(View.OnClickListener {
                currentPosition = position
                showDatePickerDialog(Date().time)
            })
            holder.edtPrice.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {

                    //event after text chanfe
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //event before text change
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    priceList[holder.adapterPosition] = holder.edtPrice.text.toString()
                }
            })
            holder.edtConditnlNote.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    //event after text change
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //event before text change
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    if (!holder.edtConditnlNote.text.toString().equals("")) {

                        noteList[holder.adapterPosition] = holder.edtConditnlNote.text.toString()
                    }

                }

            })
            holder.edtRejectNote.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    //event after text change
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //event before text change
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    rejectnoteList[holder.adapterPosition] = holder.edtRejectNote.text.toString()
                }
            })

            dateListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
                    cal.set(Calendar.YEAR, year)
                    cal.set(Calendar.MONTH, month)
                    cal.set(Calendar.DAY_OF_MONTH, day)
                    notifyItemChanged(currentPosition)


                }
            }

        }

        internal fun bindData(holder: Viewholder, position: Int) {
            holder.orderId.text = orderList.get(position).orderGenId
            holder.txtProductname.text = orderList.get(position).productName
            holder.txtname.text = orderList.get(position).borrowerName
            holder.txtAdd.text = orderList.get(position).displayAddressInfo
        }

        internal fun showDatePickerDialog(minDate: Long) {
            var datePickerDialog = DatePickerDialog(
                context,
                dateListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.datePicker.minDate = minDate
            datePickerDialog.show()
        }
    }

    class Viewholder(view: View) : RecyclerView.ViewHolder(view) {
        internal val orderId = view.orderId as TextView
        internal val txtOrderCode = view.txtOrderCode as TextView
        internal val txtProductname = view.txtProductname as TextView
        internal val txtname = view.txtname as TextView
        internal val txtAdd = view.txtAdd as TextView
        internal val edtDate = view.edtDate as EditText
        internal val edtPrice = view.edtPrice as EditText
        internal val linearReject = view.linearReject as LinearLayoutCompat
        internal val linearConditional = view.linearConditional as LinearLayoutCompat
        internal val edtConditnlNote = view.edtConditnlNote as EditText
        internal val edtRejectNote = view.edtRejectNote as EditText


    }
}