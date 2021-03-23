package com.radian.myradianvaluations.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.Assets
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible

class AssetsAdapter(var listAssets: ArrayList<Assets>, var onItemClick: (Any) -> Unit) :
    RecyclerView.Adapter<AssetsAdapter.AssetViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AssetViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rv_asset_item, viewGroup, false)

        return AssetViewHolder(view)
    }

    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {

        holder.tvAssetName.text = listAssets[position].name
        if (listAssets[position].isSelected)
            holder.ivSelected.makeVisible()
        else
            holder.ivSelected.makeGone()

        holder.rlAsset.setOnClickListener {
            onItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return listAssets.size
    }

    class AssetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var rlAsset: RelativeLayout = view.findViewById(R.id.rlAsset)
        var tvAssetName: AppCompatTextView = view.findViewById(R.id.tvAssetName)
        var ivSelected: AppCompatImageView = view.findViewById(R.id.ivSelected)
    }
}