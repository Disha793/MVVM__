package com.radian.myradianvaluations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.view.BottomNavigationActivity
import com.radian.myradianvaluations.view.NewOrderDetailFragment
import com.radian.vendorbridge.Response.NewOrderResponse
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.row_new_orders.view.*


class NewOrdersAdapter(
    private val context: Context,
    private val newOrderList: ArrayList<NewOrderResponse.Data.OrderResponse>
) :
    RecyclerView.Adapter<NewOrdersAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardNewOrdr = view.cardNewOrdr
        val lblnworderAdd = view.lblnworderAdd
        val lblnworderProduct = view.lblnworderProduct
        val lblnworderTime = view.lblnworderTime

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_new_orders, parent, false)
        return ViewHolder((view))
    }

    override fun getItemCount(): Int {
        return newOrderList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lblnworderAdd.text = newOrderList.get(position).displayAddressInfor
        holder.lblnworderProduct.text = newOrderList.get(position).productName
        if (newOrderList.get(position).isAssigned == 1) {
            holder.lblnworderTime.text = newOrderList.get(position).message
        } else {
            holder.lblnworderTime.text =
                newOrderList.get(position).appointmentDate + " | Between " + newOrderList.get(
                    position
                ).startTimeSlot + " and " + newOrderList.get(position).endTimeSlot
        }

        holder.cardNewOrdr.setOnClickListener {
            (context as BottomNavigationActivity).bottomNavigationView.visibility = View.GONE
            (context as BottomNavigationActivity).pushFragment(
                NewOrderDetailFragment.newInstance(
                    newOrderList.get(position).itemId
                ), true
            )
        }
    }

}