package com.radian.myradianvaluations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderListResponse
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.interfaces.ListItemClickListener
import kotlinx.android.synthetic.main.row_open_orders.view.*


class OrdersAdapter(
    private val context: Context,
    private val onClickListener: ListItemClickListener,
    private val orderList: ArrayList<OrderListResponse.Data.OrderDetail>
) :
    RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_open_orders, parent, false)
        return ViewHolder((view))
    }

    override fun getItemCount(): Int {
        return orderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (orderList.get(position).notificationCount!! > 1)
            holder.linearAtten.makeVisible()
        else
            holder.linearAtten.makeGone()
        holder.lblOrderAdd.text = orderList.get(position).displayAddInfo
        holder.lblorderProduct.text = orderList.get(position).product
        holder.lblorderTime.makeGone()
        //This is to show appointment date and time
//        if (!orderList.get(position).appointmentDate.isNullOrEmpty()) {
//            holder.lblorderTime.text =
//                orderList.get(position).appointmentDate + " at " + orderList.get(position).appointmentTime
//
//        } else {
//             orderList.get(position).message?.let{
//                 holder.lblorderTime.text =it
//             }
//        }

        holder.cardOpenOrder.setOnClickListener {
            onClickListener.onItemClick(position)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val linearAtten = view.linearAtten
        val cardOpenOrder = view.cardOpenOrder
        val lblOrderAdd = view.lblorderAdd
        val lblorderProduct = view.lblorderProduct
        val lblorderTime = view.lblorderTime
    }
}