package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.SearchFilterResponse
import com.radian.myradianvaluations.adapter.MessageListAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.DashboardAbbr
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.MessageListViewModel
import com.radian.myradianvaluations.viewmodel.MessageListViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.fragment_message_list.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MessageListFragment : Fragment(), View.OnClickListener {
    private var postParam = HashMap<String, Any?>()
    private var countMessageTitle = ""
    lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    private lateinit var messageListViewModel: MessageListViewModel
    private lateinit var factory: MessageListViewModelFactory
    internal lateinit var view: View
    private val classTag = this.javaClass.name
    private val messageList = ArrayList<SearchFilterResponse.Data.OrderList.Order>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_message_list, container, false)
        (context as BottomNavigationActivity).txtClear.setOnClickListener(this)
        setToolbar()
        initViewModel()
        observeMessageListData()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "Message")
        CommonUtils.addParamstoFirebaseEvent(
            firebaseAnalytics,
            Const.screenLaunched,
            firebaseParams
        )
        manageUI()

        //Disha: For next release
        if (messageList.isEmpty())
            getMessageList()
    }

    private fun initViewModel() {
        factory = MessageListViewModelFactory(context!!)
        messageListViewModel = ViewModelProvider(this, factory).get(MessageListViewModel::class.java)
    }

    private fun observeMessageListData() {
        messageListViewModel.messageListResponse.observe(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                messageList.clear()
                messageList.addAll(it.data.orderList.messageList)
                view.recyclerview.adapter?.notifyDataSetChanged()
                setMessageCount(messageList.size.toString())
                showNoMsg()
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })


    }

    private fun manageUI() {
        messageList.clear()
        view.recyclerview.adapter =
            MessageListAdapter(
                context!!,
                messageList,
                view,
                this@MessageListFragment, messageListViewModel, viewLifecycleOwner
            )
        CommonUtils.hideKeybord(
            (context as BottomNavigationActivity).window.decorView.rootView,
            context!!
        )
    }

    private fun setMessageCount(count: String) {

        if (count.equals("1")) {
            countMessageTitle = "<b>" + count + "</b>" + " Message"
        } else {
            countMessageTitle = "<b>" + count + "</b>" + " Messages"
        }

        view.txtOrderCount.setText(
            HtmlCompat.fromHtml(
                countMessageTitle,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
        )
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).txtTitle.text = getString(R.string.messages)
        (context as BottomNavigationActivity).txtClear.makeVisible()
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).imgBack.makeVisible()

    }

    fun getMessageList() {
        val postParam = HashMap<String, Any?>()

        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParam.put("Tiles", DashboardAbbr.N_MESSAGE)
        messageListViewModel.getMessageList(postParam)
    }

    private fun showNoMsg() {
        if (messageList.isEmpty()) {
            view.txtNoMsg.makeVisible()
            (context as BottomNavigationActivity).txtClear.makeGone()
            view.txtOrderCount.makeGone()
        } else {
            view.txtNoMsg.makeGone()
            (context as BottomNavigationActivity).txtClear.makeVisible()
            view.txtOrderCount.makeVisible()

        }
    }

    override fun onResume() {
        super.onResume()
        CommonUtils.hideKeybord(
            (context as BottomNavigationActivity).window.decorView.rootView,
            context!!
        )

    }

    override fun onClick(p0: View?) {
        //onClick event
    }


}