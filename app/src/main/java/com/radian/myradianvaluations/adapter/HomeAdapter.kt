package com.radian.myradianvaluations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.interfaces.HomeItemClickListener
import com.radian.myradianvaluations.utils.DashboardAbbr
import com.radian.vendorbridge.Response.DashboardResponseNew
import kotlinx.android.synthetic.main.row_dashboard_new.view.*

class HomeAdapter(
    private val context: Context,
    private val dashboardList: ArrayList<DashboardResponseNew.Data.DashboardTileList>,
    private val onClickListener: HomeItemClickListener
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.row_dashboard_new, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return dashboardList.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (dashboardList.get(position).abbr) {

            DashboardAbbr.newOrder -> {
                setNewOrder(holder, position)
            }
            DashboardAbbr.inspection -> {
                setInspection(holder, position)
            }
            DashboardAbbr.document -> {
                setDocument(holder, position)
            }
            DashboardAbbr.revision -> {
                setRevision(holder, position)
            }
        }
        holder.btnView.setOnClickListener {
            onClickListener.homeItemClicked(
                position,
                dashboardList.get(position).abbr!!,
                Const.actionView
            )
        }
        holder.btnRead.setOnClickListener {
            onClickListener.homeItemClicked(
                position,
                dashboardList.get(position).abbr!!,
                Const.actionRead
            )
        }

    }


    private fun setNewOrder(
        holder: ViewHolder,
        position: Int
    ) {
        disableOtherViews(holder, DashboardAbbr.newOrder)
        holder.nwordrDteTime.visibility = View.VISIBLE
        holder.cardTitle.text = context.getString(R.string.lbl_dash_nwordr)
        holder.txtAdd.text = dashboardList.get(position).displayAddressInfo
        if (!dashboardList[position].appointmentDate.isNullOrBlank() && !dashboardList[position].startTimeSlot.isNullOrEmpty()) {
            holder.nwordrDteTime.text =
                dashboardList[position].appointmentDate + " | " + "Between " + dashboardList[
                        position].startTimeSlot + " and " + dashboardList[position].endTimeSlot
        } else {
            holder.nwordrDteTime.text = dashboardList[position].message
        }

        holder.product.text = dashboardList[position].product
        holder.linearBtn.visibility = View.VISIBLE
        holder.product.visibility = View.VISIBLE
        holder.btnView.text = context.getString(R.string.lbl_btn_view)
        holder.btnRead.text = context.getString(R.string.lbl_btn_decline)
    }

    private fun setDocument(
        holder: ViewHolder,
        position: Int
    ) {
        disableOtherViews(holder, DashboardAbbr.document)
        holder.document.visibility = View.VISIBLE
        holder.cardTitle.text = context.getString(R.string.lbl_dash_document)
        holder.txtAdd.text = dashboardList.get(position).displayAddressInfo
        holder.document.text =
            dashboardList.get(position).documentname!!
        holder.linearBtn.visibility = View.VISIBLE
        holder.btnView.text = context.getString(R.string.lbl_btn_view)
        holder.btnRead.text = context.getString(R.string.lbl_btn_read)
    }

    private fun setInspection(
        holder: ViewHolder,
        position: Int
    ) {
        disableOtherViews(holder, DashboardAbbr.inspection)
        holder.inspectnTime.visibility = View.VISIBLE
        holder.cardTitle.text = context.getString(R.string.lbl_dash_inspectn)
        holder.txtAdd.text = dashboardList.get(position).displayAddressInfo
        holder.inspectnTime.text =
            "Scheduled for " + dashboardList.get(position).appointmentDate
        holder.linearBtn.visibility = View.VISIBLE
        holder.btnView.text = context.getString(R.string.lbl_btn_complete)
        holder.btnRead.text = context.getString(R.string.lbl_btn_update)
    }

    private fun setRevision(
        holder: ViewHolder,
        position: Int
    ) {
        disableOtherViews(holder, DashboardAbbr.revision)
        holder.revision.visibility = View.VISIBLE
        holder.cardTitle.text = context.getString(R.string.lbl_dash_revision)
        holder.txtAdd.text = dashboardList[position].displayAddressInfo
        holder.revision.text =
            dashboardList.get(position).revisionRequest?.let { it }
        holder.linearBtn.visibility = View.VISIBLE
        holder.btnView.text = context.getString(R.string.lbl_btn_view)
        holder.btnRead.text = context.getString(R.string.lbl_btn_read)
    }

    private fun disableOtherViews(holder: ViewHolder, abbr: String) {
        when (abbr) {

            DashboardAbbr.newOrder -> {
                holder.document.visibility = View.GONE
                holder.revision.visibility = View.GONE

            }
            DashboardAbbr.document -> {
                holder.revision.visibility = View.GONE
                holder.nwordrDteTime.visibility = View.GONE
                holder.product.visibility = View.GONE
                holder.inspectnTime.visibility = View.GONE
            }
            DashboardAbbr.revision -> {
                holder.nwordrDteTime.visibility = View.GONE
                holder.product.visibility = View.GONE
                holder.inspectnTime.visibility = View.GONE
                holder.document.visibility = View.GONE
            }
            DashboardAbbr.inspection -> {
                holder.revision.visibility = View.GONE
                holder.nwordrDteTime.visibility = View.GONE
                holder.product.visibility = View.GONE
                holder.document.visibility = View.GONE
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtAdd = view.txtAdd
        val cardTitle = view.cardTitle
        val nwordrDteTime = view.nwordrDteTime
        val product = view.product
        val revision = view.revision
        val inspectnTime = view.inspectnTime
        val document = view.document
        val linearBtn = view.linearBtn
        val btnView = view.btnView
        val btnRead = view.btnRead
        val cardHome = view.cardHome
    }

}