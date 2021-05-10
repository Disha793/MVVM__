package com.radian.myradianvaluations.view.activity

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.Assets
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.Response.UploadedPhotos
import com.radian.myradianvaluations.adapter.AssetsAdapter
import com.radian.myradianvaluations.adapter.CompCategoriesAdapter
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.databinding.ActivityStepsBinding
import com.radian.myradianvaluations.extensions.makeGone
import com.radian.myradianvaluations.extensions.makeVisible
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.fragment.ImageViewerFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*

class StepsActivity : AppCompatActivity(), View.OnClickListener, SearchView.OnQueryTextListener,
    DialogInterface.OnClickListener {

    private var itemId: Int = 0
    private lateinit var binding: ActivityStepsBinding
    private lateinit var mContext: Context

    private var listAssets: ArrayList<Assets> = ArrayList()
    private var listCategories: ArrayList<PhotoUploadCategoryResponse.Data> = ArrayList()
    private var listUploadedPhotos: ArrayList<UploadedPhotos> = ArrayList()

    private lateinit var adapterCompCategories: CompCategoriesAdapter
    private lateinit var adapterAssets: AssetsAdapter

    private var currentCategoryPosition: Int = -1
    private var currentAssetPosition: Int = -1
    private lateinit var imageUri: Uri

    private var pickImage = 100
    val fm = supportFragmentManager

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_steps)
        mContext = this
        init()
        CommonUtils.hideKeybord(window.decorView.rootView, this)
        showtoolbarTitle(1)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun init() {
        val v: View = binding.svCategory.findViewById(androidx.appcompat.R.id.search_plate)
        itemId = intent.getIntExtra(Const.itemIdTag, 0)

        v.isFocusable = false
        v.clearFocus()

        v.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white))

        if (intent.extras != null) {
            if (intent.extras!!.containsKey(Const.INTENT_CAMERA_KEY)) {
                setSelectedStep(2)
            } else {
                setSelectedStep(1)
            }
        } else {
            setSelectedStep(1)
        }

        if (Pref.getValue(this, Const.IS_FIRST_TIME, "").toString().isNullOrEmpty()) {
            addListItems()
        } else {
            listCategories =
                Pref.getCategoriesArrayList(this, Const.CATEGORIES_SHARED_PREF_KEY, "")
            listAssets = Pref.getAssetsArrayList(this, Const.ASSET_SHARED_PREF_KEY, "")
            for (i in listAssets.indices) {
                if (listAssets[i].isSelected) {
                    currentAssetPosition = i
                }
            }
        }

        binding.rlStepOne.setOnClickListener(this)
        binding.rlStepTwo.setOnClickListener(this)
        binding.btnStart.setOnClickListener(this)
        binding.svCategory.setOnQueryTextListener(this)
        binding.includedToolbar.imgBack.setOnClickListener(this)
        binding.rvAssets.addItemDecoration(
            DividerItemDecoration(
                binding.rvAssets.getContext(),
                LinearLayoutManager.VERTICAL
            )
        )

        adapterAssets = AssetsAdapter(listAssets) {


            if (currentAssetPosition == -1) {
                currentAssetPosition = it as Int
                for (i in listAssets.indices) {
                    listAssets[i].isSelected = i == currentAssetPosition
                }
                Pref.setAssetsArrayList(this, Const.ASSET_SHARED_PREF_KEY, listAssets)
                adapterAssets.notifyDataSetChanged()
                setSelectedStep(2)
            } else {
                val asset = listAssets[currentAssetPosition].name
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.app_name))
                builder.setMessage("Data is already added for $asset. Would you like to select new Asset and proceed further? Already added data will be deleted.")

                builder.setPositiveButton("Yes") { _, _ ->

                    currentAssetPosition = it as Int
                    for (i in listAssets.indices) {
                        listAssets[i].isSelected = i == currentAssetPosition
                    }
                    Pref.setAssetsArrayList(this, Const.ASSET_SHARED_PREF_KEY, listAssets)
                    adapterAssets.notifyDataSetChanged()
                    setSelectedStep(2)
                }

                builder.setNegativeButton(android.R.string.no) { dialog, _ ->
                    dialog.dismiss()
                }
                builder.show()
            }
        }

        binding.rvAssets.layoutManager = LinearLayoutManager(this)
        binding.rvAssets.adapter = adapterAssets

        adapterCompCategories = CompCategoriesAdapter(this, listCategories, { list: Any, pos: Any ->
            currentCategoryPosition = pos as Int
            listCategories = list as ArrayList<PhotoUploadCategoryResponse.Data>
            openDialog()
        },
//            { list: Any, pos: Any ->
//            currentCategoryPosition = pos as Int
//            listCategories = list as ArrayList<PhotoUploadCategoryResponse.Data>
//            val intent = Intent(this, CameraActivity::class.java)
//            intent.putExtra(Const.INTENT_POSITION_KEY, currentCategoryPosition)
//            startActivity(intent)
//        },


            { list: Any, pos: Any ->
                currentCategoryPosition = pos as Int
                listCategories = list as ArrayList<PhotoUploadCategoryResponse.Data>

                pushFragment(
                    ImageViewerFragment(
                        listCategories, currentCategoryPosition, itemId
                    ), true
                )

            })

        binding.rvCategories.layoutManager = GridLayoutManager(this, 2)
        binding.rvCategories.adapter = adapterCompCategories
    }

    private fun openDialog() {
        CommonUtils.openDialog(this@StepsActivity, this)
    }

    override fun onClick(p0: DialogInterface?, position: Int) {
        when (position) {
            0 -> openCamera()
            1 -> openGallery()
            2 -> p0!!.dismiss()
        }
    }

    private fun openGallery() {
        val gallery =
            Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
            )
        startActivityForResult(gallery, pickImage)
    }

    private fun openCamera() {
        val intent = Intent(this, CameraActivity::class.java)
        intent.putExtra(Const.INTENT_POSITION_KEY, currentCategoryPosition)
        intent.putExtra(Const.itemIdTag, itemId)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data!!
            //PhotoUpload Disha
            listCategories[currentCategoryPosition].photoList[0].photoUrl = imageUri.toString()
            Pref.setCategoriesArrayList(this, Const.CATEGORIES_SHARED_PREF_KEY, listCategories)
            listCategories =
                Pref.getCategoriesArrayList(this, Const.CATEGORIES_SHARED_PREF_KEY, "")
            adapterCompCategories.notifyItemChanged(currentCategoryPosition)
        }
    }

    private fun showtoolbarTitle(index: Int) {
        when (index) {
            1 -> {
                binding.includedToolbar.txtTitle.text = getString(R.string.str_asset)

            }
            2 -> {
                binding.includedToolbar.txtTitle.text = getString(R.string.str_categories)

            }

        }

    }

    private fun addListItems() {
        listAssets.add(Assets("Asset 1", false))
        listAssets.add(Assets("Asset 2", false))
        listAssets.add(Assets("Asset 3", false))
        listAssets.add(Assets("Asset 4", false))

//        listCategories.add(Categories("Living Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Bed Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Bath Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Terrace Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Living Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Bed Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Bath Room", null, "", 0.0, 0.0))
//        listCategories.add(Categories("Terrace Room", null, "", 0.0, 0.0))

        Pref.setCategoriesArrayList(this, Const.CATEGORIES_SHARED_PREF_KEY, listCategories)
        Pref.setAssetsArrayList(this, Const.ASSET_SHARED_PREF_KEY, listAssets)
        Pref.setValue(this, Const.IS_FIRST_TIME, "FALSE")
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.rlStepOne -> {
                setSelectedStep(1)
            }
            R.id.rlStepTwo -> {
                if (currentAssetPosition != -1) {
                    setSelectedStep(2)
                } else {
                    this.findViewById<View>(android.R.id.content)
                        .snack(resources.getString(R.string.select_asset)) {}
                }
            }
            R.id.btnStart -> {

            }
            R.id.imgBack -> {
                finishAndRemoveTask()

            }
        }
    }

    private fun setSelectedStep(index: Int) {
        showtoolbarTitle(index)
        if (index == 1) {
            binding.rlStepOne.isSelected = true
            binding.rlStepTwo.isSelected = false
            binding.btnStart.text = "Next"
            binding.rvAssets.makeVisible()
            binding.llCategories.makeGone()
        } else if (index == 2) {
            binding.rlStepOne.isSelected = false
            binding.rlStepTwo.isSelected = true
            binding.btnStart.text = "Submit"

            binding.rvAssets.makeGone()
            binding.llCategories.makeVisible()
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapterCompCategories.filter.filter(newText)
        return false
    }

    fun pushFragment(fragment: Fragment, isBackStack: Boolean) {
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(mainLayout.id, fragment, fragment.javaClass.getSimpleName())
        if (isBackStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        }
        fragmentTransaction.commit()
    }

}