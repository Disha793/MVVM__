package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.MessageChatResponse
import com.radian.myradianvaluations.adapter.MessageChatAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.snackAction
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.MessageChatViewModel
import com.radian.myradianvaluations.viewmodel.MessageChatViewModelFactory
import kotlinx.android.synthetic.main.fragment_message_chat.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class MessageChatFragment() : Fragment(), View.OnClickListener {

    var orderId = "0"
    internal lateinit var view: View
    var itemId = 0
    val classTag = this.javaClass.name
    var chatList = ArrayList<MessageChatResponse.TileOrderNote>()
    lateinit var firebaseAnalytics: FirebaseAnalytics
    val firebaseParams = Bundle()
    private lateinit var messageChatViewModel: MessageChatViewModel
    private lateinit var factory: MessageChatViewModelFactory
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_message_chat, container, false)
        initViewModel()
        observeChatData()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        manageUI()
        if (arguments != null) {
            orderId = arguments?.getString(tagOrderId)!!
            itemId = arguments?.getInt(Const.itemIdTag)!!
        }
        setToolbar()
        view.imgSend.setOnClickListener(this)
        getMessageChat()
    }

    private fun observeChatData() {

        messageChatViewModel.messageChatResponse.observe(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                chatList.clear()
                chatList.addAll(it.data?.tileOrderNotes!!)
                view.msgRecycle.adapter?.notifyDataSetChanged()
                view.msgRecycle.scrollToPosition(chatList.size - 1)
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
        messageChatViewModel.sendMessageResponse.observe(viewLifecycleOwner, Observer {
            if (it.status.equals(APIStatus.ok, true)) {
                view.snackAction(view,
                        it.data.message,
                        "ok",
                        View.OnClickListener {
                            view.editChat.setText("")
                            getMessageChat()

                        })
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    private fun initViewModel() {
        factory = MessageChatViewModelFactory(context!!)
        messageChatViewModel = ViewModelProvider(this, factory).get(MessageChatViewModel::class.java)
    }

    private fun manageUI() {
        view.msgRecycle.adapter =
                MessageChatAdapter(context!!, chatList)

        var linearLayoutManager = LinearLayoutManager(activity)

        view.msgRecycle.layoutManager = linearLayoutManager
    }

    companion object {
        var tagOrderId = "orderid"
        fun newInstance(orderId: String, itemId: Int?): MessageChatFragment {
            val args = Bundle()
            args.putString(tagOrderId, orderId)
            args.putInt(Const.itemIdTag, itemId!!)
            val fragment = MessageChatFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.imgSend -> {
                if (!TextUtils.isEmpty(view.editChat.text.toString())) {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "sendMessageTapped")
                    CommonUtils.addParamstoFirebaseEvent(
                            firebaseAnalytics,
                            Const.methodInvoked,
                            firebaseParams
                    )
                    sendMessageChat()
                }
            }
        }
    }

    private fun setToolbar() {

        (context as BottomNavigationActivity).txtTitle.text =
                resources.getString(R.string.messagesTitle) + ":" + orderId
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
    }

    fun getMessageChat() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put(
                "MobileUserId",
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
        )
        postParam.put("ItemId", itemId.toString())
        postParam.put(
                "OrganizationIds",
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString()
        )
        messageChatViewModel.getMessageChat(postParam)

    }

    fun sendMessageChat() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put(
                "MobileUserId",
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
        )
        postParam.put("ItemId", itemId.toString())
        postParam.put(
                "OrganizationIds",
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString()
        )
        postParam.put("Notes", view.editChat.text.toString())
        messageChatViewModel.sendMessage(postParam)
    }
}

