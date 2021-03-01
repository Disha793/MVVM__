package com.radian.myradianvaluations.view

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.viewmodel.MessageChatViewModel
import com.radian.vendorbridge.Response.MessageChatResponse
import kotlinx.android.synthetic.main.fragment_message_chat.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.row_message.view.*


class MessageChatFragment() : Fragment(), View.OnClickListener {
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
                    addMessageChat()
                }
            }
        }
    }

    var orderId = "0"
    internal lateinit var view: View
    var itemId = 0
    val classTag = this.javaClass.name
    var chatList = ArrayList<MessageChatResponse.TileOrderNote>()
    lateinit var firebaseAnalytics: FirebaseAnalytics
    val firebaseParams = Bundle()
    private lateinit var messageViewModel: MessageChatViewModel

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)

        view.msgRecycle.adapter =
            MessageAdapter(
                context!!,
                chatList
            )

        var linearLayoutManager = LinearLayoutManager(activity)

        view.msgRecycle.layoutManager = linearLayoutManager


        if (arguments != null) {
            orderId = arguments?.getString(tagOrderId)!!
            itemId = arguments?.getInt(Const.itemIdTag)!!
        }
        setToolbar()
        view.imgSend.setOnClickListener(this)
        getMessageChat()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_message_chat, container, false)
        messageViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(MessageChatViewModel::class.java)
        messageViewModel.init(context as BottomNavigationActivity)
        return view
    }


    private fun setToolbar() {

        (context as BottomNavigationActivity).txtTitle.text =
            resources.getString(R.string.messagesTitle) + ":" + orderId
        (context as BottomNavigationActivity).txtClear.visibility = View.GONE
    }

    fun getMessageChat() {
        LoadingDialog.show(context as BottomNavigationActivity)
        messageViewModel.getMessageChat(itemId).let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(Const.statusOk, true)) {
                    chatList.clear()
                    chatList.addAll(it.data?.tileOrderNotes!!)
                    view.msgRecycle.adapter?.notifyDataSetChanged()
                    view.msgRecycle.scrollToPosition(chatList.size - 1)
                } else if (it.status.equals(Const.statusUnauth, true)) {
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
                        getMessageChat()

                    },
                    getString(R.string.ok)
                )
            }
        }

    }

    fun addMessageChat() {
        messageViewModel.addMessage(view.editChat.text.toString()).let {
            LoadingDialog.show(context as BottomNavigationActivity)
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    CommonUtils.displayMessageAction(
                        view,
                        it.data.message,
                        "ok",
                        View.OnClickListener {
                            view.editChat.setText("")
                            getMessageChat()

                        })
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
            }
        }
    }

}

    class MessageAdapter(
        context: Context,
        chatList: ArrayList<MessageChatResponse.TileOrderNote>
    ) : RecyclerView.Adapter<MessageAdapter.ViewHolder>() {
        val context = context
        val chatList = chatList

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(R.layout.row_message, p0, false)
            )
        }

        override fun getItemCount(): Int {
            return chatList.size
        }

        override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
            //bind your data
            bindData(p0, p1)
        }

        private fun bindData(holder: ViewHolder, position: Int) {
            holder.txtName.setText(chatList.get(holder.adapterPosition).createdUserName)
            holder.txtMsg.setText(chatList.get(holder.adapterPosition).note)
            holder.txtDate.visibility = View.VISIBLE
            holder.txtDate.setText(chatList.get(position).createdDate)
            if (chatList.get(holder.adapterPosition).userId == Pref.getValue(
                    context,
                    Pref.USER_ID,
                    0
                )
            ) {

                val params = holder.layout.layoutParams as RecyclerView.LayoutParams
                params.setMargins(200, 0, 0, 0)
                holder.layout.setLayoutParams(params)
                holder.receiveBubble.visibility = View.VISIBLE
                holder.sendBubble.visibility = View.GONE
            } else {
                val params = holder.layout.layoutParams as RecyclerView.LayoutParams
                params.setMargins(0, 0, 200, 0)
                holder.layout.setLayoutParams(params)
                holder.sendBubble.visibility = View.VISIBLE
                holder.receiveBubble.visibility = View.GONE


            }
        }

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val txtName = view.txtName as TextView
            val txtMsg = view.txtMsg as TextView
            val txtDate = view.txtDate as TextView
            val layout = view.linearUpcoming as RelativeLayout
            val sendBubble = view.imgSendBubble as ImageView
            val receiveBubble = view.imgReceveBubble as ImageView
        }
    }
