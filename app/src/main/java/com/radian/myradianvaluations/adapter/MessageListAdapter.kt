package com.radian.myradianvaluations.adapter

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.SearchFilterResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.fragment.ManageOrderFragment
import com.radian.myradianvaluations.view.fragment.MessageChatFragment
import com.radian.myradianvaluations.view.fragment.MessageListFragment
import com.radian.myradianvaluations.viewmodel.MessageListViewModel
import kotlinx.android.synthetic.main.fragment_message_list.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.row_message_list.view.*


class MessageListAdapter(
    context: Context,
    messageList: ArrayList<SearchFilterResponse.Data.OrderList.Order>,
    messageListFragment: View,
    val messageListFragment1: MessageListFragment,
    val messageListViewModel: MessageListViewModel,
    val viewLifecycleOwner: LifecycleOwner

) : RecyclerView.Adapter<MessageListAdapter.ViewHolder>() {
    val context = context
    val messageList = messageList
    val messageListFragment = messageListFragment
    val selectedMessage = ArrayList<Int>()
    var positionList = ArrayList<Int>()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        messageListViewModel.deleteMessageResponse.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                for (i in 0..positionList.size - 1) {
                    messageList.removeAt(0)
                    positionList.removeAt(0)
                    notifyDataSetChanged()
                }
                messageListFragment1.getMessageList()
                showEmptyList()
            })

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_message_list, p0, false)
        )
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int) = position

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.orderId.setText(messageList.get(p1).orderGenId.toString())
        p0.txtMsgTitle.setText(messageList.get(p1).product)
        p0.txtName.setText(messageList.get(p1).displayBorrowerInfo)
        p0.txtAdd.setText(messageList.get(p1).message)
        when (messageList.get(p0.adapterPosition).tag) {
            "0" -> {
                p0.checkBox.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.img_unselect
                    )
                )
            }
            "1" -> {
                p0.checkBox.setImageDrawable(
                    ContextCompat.getDrawable(
                        context,
                        R.drawable.img_select
                    )
                )
            }
        }

        p0.cardView.setOnClickListener(View.OnClickListener {
            (context as BottomNavigationActivity).pushFragment(
                ManageOrderFragment.newInstance(
                    messageList.get(p1).itemId!!
                ), true
            )
        })

        p0.imgMsgReply.setOnClickListener(View.OnClickListener {
            (context as BottomNavigationActivity).pushFragment(
                MessageChatFragment.newInstance(
                    messageList.get(p1).orderGenId!!,
                    messageList.get(p1).itemId
                ), true
            )

        })

        p0.checkBox.setOnClickListener {
            when (messageList.get(p0.adapterPosition).tag) {
                "0" -> {
                    messageList.get(p0.adapterPosition).tag = "1"
                    p0.checkBox.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.img_select
                        )
                    )
                    p0.checkBox.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            R.color.colorPrimary
                        )
                    )
                    positionList.add(p1)
                    selectedMessage.add(messageList.get(p0.adapterPosition).itemNoteId!!)
                    (context as BottomNavigationActivity).txtClear.text = "Clear"
                }
                "1" -> {
                    messageList.get(p0.adapterPosition).tag = "0"
                    p0.checkBox.setImageDrawable(
                        ContextCompat.getDrawable(
                            context,
                            R.drawable.img_unselect
                        )
                    )
                    p0.checkBox.setColorFilter(
                        ContextCompat.getColor(
                            context,
                            R.color.colorPrimary
                        )
                    )
                    positionList.remove(p1)
                    selectedMessage.remove(messageList.get(p0.adapterPosition).itemNoteId!!)
                }
            }

        }

        p0.linearClear.setOnClickListener(View.OnClickListener {
            selectedMessage.add(messageList.get(p0.adapterPosition).itemNoteId!!)
            messageList.removeAt(p1)
            notifyDataSetChanged()
            deleteMessage()
        })

        (context as BottomNavigationActivity).txtClear.setOnClickListener(View.OnClickListener {
            if (!positionList.isEmpty()) {
                if (positionList.size > 1) {
                    CommonUtils.showDialog(
                        context,
                        context.resources.getString(R.string.clear_message),
                        DialogInterface.OnClickListener { _, _ ->
                            deleteMessage()
                        },
                        DialogInterface.OnCancelListener { _ ->

                        }, "Clear", "Cancel"

                    )

                } else {
                    messageList.removeAt(positionList.get(0))
                    positionList.remove(0)
                    notifyDataSetChanged()
                    deleteMessage()

                }

            } else {
                CommonUtils.showOkDialog(
                    context,
                    "Please select any message from list.",
                    DialogInterface.OnClickListener { _, _ ->


                    },
                    "OK"
                )
            }

        })
    }


    fun showEmptyList() {
        if (messageList.isEmpty()) {
            messageListFragment.txtNoMsg.makeVisible()
            messageListFragment.txtOrderCount.makeGone()
            (context as BottomNavigationActivity).txtClear.makeGone()

        }
    }

    fun deleteMessage() {
        var postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context, Pref.PHONE_NUMBER, ""))
        postParam.put("MobileUserId", Pref.getValue(context, Pref.MOBILE_USER_ID, 0).toString())
        if (selectedMessage.size > 1) {
            postParam.put("ItemNoteIds", selectedMessage)
        } else {
            postParam.put("ItemNoteIds", selectedMessage.get(0))
        }
        if (selectedMessage.isEmpty()) {
            postParam.put("ClearAll", "Y")
        } else {
            postParam.put("ClearAll", "N")
        }
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context))
        postParam.put("OrganizationIds", Pref.getValue(context, Pref.ORGANIZATN_ID, 0).toString())
        messageListViewModel.deleteMessage(postParam)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMsgDetail = view.imgMsgDetail
        val imgMsgReply = view.imgMsgReply
        val checkBox = view.imgCheckbox
        val orderId = view.orderId
        val txtMsgTitle = view.txtMsgTitle
        val txtName = view.txtName
        val txtAdd = view.txtAdd
        val cardView = view.cardView
        val linearClear = view.linearClear
    }

}

