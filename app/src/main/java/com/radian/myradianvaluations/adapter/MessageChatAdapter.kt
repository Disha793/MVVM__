package com.radian.myradianvaluations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.MessageChatResponse
import com.radian.myradianvaluations.utils.Pref
import kotlinx.android.synthetic.main.row_message.view.*

class MessageChatAdapter(
        context: Context,
        chatList: ArrayList<MessageChatResponse.TileOrderNote>
) : RecyclerView.Adapter<MessageChatAdapter.ViewHolder>() {
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
        if (chatList.get(holder.adapterPosition).userId == Pref.getValue(context, Pref.USER_ID, 0)) {
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