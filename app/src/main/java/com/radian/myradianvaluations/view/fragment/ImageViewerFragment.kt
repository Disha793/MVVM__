package com.radian.myradianvaluations.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.adapter.ImageViewerAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.ImageViewerViewModel
import com.radian.myradianvaluations.viewmodel.ImageViewerViewModelFactory
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.frg_imageviewer.view.*
import kotlinx.android.synthetic.main.layout_toolbar.*

class ImageViewerFragment(
    catData: ArrayList<PhotoUploadCategoryResponse.Data>,
    currentCategoryPosition: Int,
    itemIdTag: Int
) : Fragment() {
    private var currentViewPagerPos: Int = 0
    private var currentCatPos: Int
    private var itemId: Int
    private var categoryData: java.util.ArrayList<PhotoUploadCategoryResponse.Data>
    private lateinit var imageViewerAdapter: ImageViewerAdapter
    internal lateinit var view: View
    private lateinit var imageViewerViewModel: ImageViewerViewModel
    private lateinit var factory: ImageViewerViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.frg_imageviewer, container, false)
        setToolbar()
        initViewModel()
        init()
        listener()
        observePhotos()
        return view
    }

    init {
        categoryData = catData
        currentCatPos = currentCategoryPosition
        itemId = itemIdTag
    }

    private fun setToolbar() {
        (context as BottomNavigationActivity).layout_toolbar.makeVisible()
        (context as BottomNavigationActivity).txtTitle.makeVisible()
        (context as BottomNavigationActivity).txtTitle.setText(categoryData[currentCatPos].text)
        (context as BottomNavigationActivity).bottomNavigationView.makeGone()
        (context as BottomNavigationActivity).imgBack.makeVisible()
        (context as BottomNavigationActivity).txtClear.makeGone()
    }

    private fun observePhotos() {
        imageViewerViewModel.deletePhotosResponse.observe(viewLifecycleOwner, Observer {
            if (it.status == APIStatus.ok) {
                context!!.toastShort(it.message)
                categoryData[currentCatPos].newPhotosId.remove(categoryData[currentCatPos].photoList[currentViewPagerPos].photoUrl)
                categoryData.get(currentCatPos).photoList.remove(categoryData.get(currentCatPos).photoList[currentViewPagerPos])
                Pref.setCategoriesArrayList(
                    context!!,
                    Const.CATEGORIES_SHARED_PREF_KEY,
                    categoryData
                )
                init()
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    private fun initViewModel() {
        factory = ImageViewerViewModelFactory(context!!)
        imageViewerViewModel =
            ViewModelProvider(this, factory).get(ImageViewerViewModel::class.java)
    }

    private fun init() {
        if (categoryData.get(currentCatPos).photoList != null && categoryData.get(currentCatPos).photoList.size > 0) {
            imageViewerAdapter = ImageViewerAdapter(
                context!!,
                categoryData.get(currentCatPos).photoList
            )
            view.dialog_imageviewer_vp_main.setAdapter(imageViewerAdapter)

            view.dialog_imageviewer_tv_count.text =
                (view.dialog_imageviewer_vp_main.currentItem + 1).toString() + " out of" + categoryData.get(
                    currentCatPos
                ).photoList.size

        } else {
            (context as BottomNavigationActivity).onBackPressed()
        }
    }

    private fun listener() {
        view.dialog_imageviewer_iv_next.setOnClickListener {
            view.dialog_imageviewer_vp_main.setCurrentItem(
                view.dialog_imageviewer_vp_main.getCurrentItem() + 1
            )
        }

        view.dialog_imageviewer_iv_prev.setOnClickListener {
            view.dialog_imageviewer_vp_main.setCurrentItem(
                view.dialog_imageviewer_vp_main.getCurrentItem() - 1
            )
        }

        view.dialog_imageviewer_vp_main.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                currentViewPagerPos = position
                view.dialog_imageviewer_tv_count.setText(
                    (position + 1).toString() + " out of " + categoryData.get(
                        currentCatPos
                    ).photoList.size
                )
            }

            override fun onPageSelected(position: Int) {}
            override fun onPageScrollStateChanged(state: Int) {}
        })
        view.dialog_imageviewer_iv_delete.setOnClickListener {
            var category = categoryData.get(currentCatPos).text
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle(getString(R.string.app_name))
            builder.setMessage(
                resources.getString(R.string.sure_delete_text) + " $category " + resources.getString(
                    R.string.image_text
                )
            )
            builder.setPositiveButton(resources.getString(R.string.yes_text)) { _, _ ->
                //PhotoUpload Disha
                deletePhoto()
            }

            builder.setNegativeButton(android.R.string.no) { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }
    }

    private fun deletePhoto() {
        if (!categoryData[currentCatPos].photoList.isNullOrEmpty() && !categoryData[currentCatPos].photoList[currentViewPagerPos].isFromDevice) {
            val postParam = HashMap<String, Any?>()
            postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
            postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
            postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
            postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
            postParam.put("UserId", Pref.getValue(context!!, Pref.USER_ID, 0))
            postParam.put("itemid", itemId)
            postParam.put(
                "PhotoIds",
                categoryData[currentCatPos].photoList[currentViewPagerPos].docId
            )
            postParam.put("PhotoType", "BPO")
            imageViewerViewModel.deletePhotos(postParam)
        } else {
            categoryData[currentCatPos].newPhotosId.remove(categoryData[currentCatPos].photoList[currentViewPagerPos].photoUrl)
            categoryData.get(currentCatPos).photoList.remove(categoryData.get(currentCatPos).photoList[currentViewPagerPos])
            Pref.setCategoriesArrayList(
                context!!,
                Const.CATEGORIES_SHARED_PREF_KEY,
                categoryData
            )
            init()
        }
    }
}
