package com.radian.myradianvaluations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderRevisionResponse
import kotlinx.android.synthetic.main.row_revision_list.view.*

class OrderRevisionRequestAdapter(
    val context: Context,
    val revisionList: ArrayList<OrderRevisionResponse.TileOrderRevision>
) : RecyclerView.Adapter<(OrderRevisionRequestAdapter.Viewolder)>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Viewolder {
        return Viewolder(
            LayoutInflater.from(context).inflate(
                R.layout.row_revision_list,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return revisionList.size
    }

    override fun onBindViewHolder(p0: Viewolder, p1: Int) {
        //bind your data here
        bindData(p0, p1)
    }

    class Viewolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtRejectnReason = view.txtRejectnReason
        val txtRejectnNote = view.txtRejectnNote
    }

    private fun bindData(holder: Viewolder, position: Int) {
        holder.txtRejectnReason.text = revisionList.get(position).rejectReason
        holder.txtRejectnNote.text = revisionList.get(position).rejectNote
    }
}