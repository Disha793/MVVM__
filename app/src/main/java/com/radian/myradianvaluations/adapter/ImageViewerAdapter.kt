package com.radian.myradianvaluations.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import kotlinx.android.synthetic.main.item_imageviewer.view.*
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class ImageViewerAdapter(
    con: Context,
    images: ArrayList<PhotoUploadCategoryResponse.PhotoList>

) : PagerAdapter() {

    private var context: Context
    private var mLayoutInflater: LayoutInflater
    var image: ArrayList<PhotoUploadCategoryResponse.PhotoList>

    init {
        context=con
        image = images
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayoutCompat
    }

    override fun getCount(): Int {

        //return the number of images
        return image.size
    }
    fun updateList(list: ArrayList<PhotoUploadCategoryResponse.PhotoList>) {
        this.image = list
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //inflating the item.xml
        val itemView: View = mLayoutInflater.inflate(R.layout.item_imageviewer, container, false)
        if(image.get(position).isFromDevice){
            Glide
                .with(context)
                .load(File(image.get(position).photoUrl)).skipMemoryCache(true)
                .centerCrop()
                .placeholder(R.drawable.add)
                .into(itemView.item_imageviewer_iv)
        }else{
            Glide
                .with(context)
                .load(BuildConfig.HOST + Uri.parse(image.get(position).photoUrl)).skipMemoryCache(true)
                .centerCrop()
                .placeholder(R.drawable.add)
                .into(itemView.item_imageviewer_iv)
        }

        //Adding the View
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayoutCompat?)
    }

}