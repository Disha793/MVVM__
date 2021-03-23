package com.radian.myradianvaluations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderDocResponse
import com.radian.myradianvaluations.extensions.makeInVisible
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.interfaces.ListItemClickListener
import kotlinx.android.synthetic.main.row_document_list.view.*

class OrderDocListAdapter(private val itemClick: ListItemClickListener, private val docList: ArrayList<OrderDocResponse.TileOrder>, private val context: Context) :
        RecyclerView.Adapter<OrderDocListAdapter.ViewHolder>() {
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
            holder.imgDot.makeVisible()
            holder.txtNewDoc.makeVisible()
        } else {
            holder.imgDot.makeInVisible()
            holder.txtNewDoc.makeInVisible()
        }

        holder.linearDocument.setOnClickListener{
            itemClick.onItemClick(position)
        }
    }
}