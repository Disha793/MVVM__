package com.radian.myradianvaluations.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.utils.LogUtils
import java.io.File

class CompCategoriesAdapter(
    var context: Context,
    var listCategories: ArrayList<PhotoUploadCategoryResponse.Data>,
    var onGalleryClick: (Any) -> Unit,
    var onCameraClick: (Any) -> Unit,
    var onDeleteClick: (Any) -> Unit
) :
    RecyclerView.Adapter<CompCategoriesAdapter.CategoriesViewHolder>(), Filterable {

    private var filterList: ArrayList<PhotoUploadCategoryResponse.Data> = listCategories

    init {
        filterList = listCategories
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rv_category_item, viewGroup, false)

        return CategoriesViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        holder.tvCategoryName.text = filterList[position].text
        if (!filterList[position].photoUrl.isNullOrEmpty()) {
            if (filterList[position].isFromDevice) {
                Glide
                    .with(context)
                    .load(File(filterList[position].photoUrl)).skipMemoryCache(true)
                    .centerCrop()
                    .placeholder(R.drawable.add)
                    .into(holder.ivImage)
            } else {
                Glide
                    .with(context)
                    .load(BuildConfig.HOST + Uri.parse(filterList[position].photoUrl))
                    .skipMemoryCache(true)
                    .centerCrop()
                    .placeholder(R.drawable.add)
                    .into(holder.ivImage)
            }

            holder.ivDelete.makeVisible()

        } else {
            holder.ivDelete.makeGone()
        }

        holder.ivGallery.setOnClickListener {
            onGalleryClick(position)
        }

        holder.ivCamera.setOnClickListener {
            onCameraClick(position)
        }
        holder.ivDelete.setOnClickListener {
            onDeleteClick(position)
        }
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterList = if (charSearch.isEmpty()) {
                    listCategories
                } else {
                    val resultList = ArrayList<PhotoUploadCategoryResponse.Data>()
                    for (row in listCategories) {
                        if (row.text.toLowerCase().contains(constraint.toString().toLowerCase())) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results?.values as ArrayList<PhotoUploadCategoryResponse.Data>
                notifyDataSetChanged()
            }
        }
    }

    class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvCategoryName: AppCompatTextView = view.findViewById(R.id.tvCategoryName)
        var ivImage: AppCompatImageView = view.findViewById(R.id.ivImage)
        var ivGallery: AppCompatImageView = view.findViewById(R.id.ivGallery)
        var ivCamera: AppCompatImageView = view.findViewById(R.id.ivCamera)
        var ivDelete: AppCompatImageView = view.findViewById(R.id.ivDelete)
    }

}