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
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.Categories
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible

class CategoriesAdapter(
    var context: Context,
    var listCategories: ArrayList<Categories>,
    var onGalleryClick: (Any) -> Unit,
    var onCameraClick: (Any) -> Unit,
    var onDeleteClick: (Any) -> Unit
) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>(), Filterable {

    private var filterList: ArrayList<Categories> = listCategories

    init {
        filterList = listCategories
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rv_category_item, viewGroup, false)

        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {

        holder.tvCategoryName.text = filterList[position].name
        if (filterList[position].imageUri != null) {
            Glide
                .with(context)
                .load(Uri.parse(filterList[position].imageUri))
                .centerCrop()
                .placeholder(R.drawable.add)
                .into(holder.ivImage)
        }
        if (filterList[position].imageUri.isNullOrEmpty()) {
            holder.ivDelete.makeGone()
        } else {
            holder.ivDelete.makeVisible()
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

    /*override fun getFilter(): Filter? {
        return exampleFilter
    }

    private val exampleFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filteredList: MutableList<Categories> = ArrayList()
            if (constraint == null || constraint.length == 0) {
                filteredList.addAll(listCategories)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }
                for (item in listCategories) {
                    if (item.name.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            filterList.clear()
            filterList.addAll(results.values as ArrayList<Categories>)
            notifyDataSetChanged()
        }
    }*/

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                filterList = if (charSearch.isEmpty()) {
                    listCategories
                } else {
                    val resultList = ArrayList<Categories>()
                    for (row in listCategories) {
                        if (row.name.toLowerCase().contains(constraint.toString().toLowerCase())) {
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
                filterList = results?.values as ArrayList<Categories>
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