package com.radian.myradianvaluations.view.fragment

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.adapter.CompCategoriesAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.CameraActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.PhotoUploadViewModel
import com.radian.myradianvaluations.viewmodel.PhotoUploadViewModelFactory
import kotlinx.android.synthetic.main.fragment_all_sub_photos.view.*


class CompPhotosFrament() : Fragment() {
    private lateinit var catData: java.util.ArrayList<PhotoUploadCategoryResponse.Data>
    private var itemId: Int = 0
    private lateinit var photoUploadViewModel: PhotoUploadViewModel
    private lateinit var factory: PhotoUploadViewModelFactory
    internal lateinit var view: View
    private lateinit var adapterCompCategories: CompCategoriesAdapter
    private val newPhotosId = ArrayList<Int>()
    //    private var listCategories: ArrayList<Categories> = ArrayList()
    private var currentCategoryPosition: Int = -1
    private var pickImage = 100
    private lateinit var imageUri: Uri
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_all_sub_photos, container, false)
        arguments?.let {
            itemId = it.getInt(Const.itemIdTag)
        }
        initViewModel()
        getCategoryList()
        searchCat()
        observeUploadPhoto()
        clickEvent()
        return view
    }

    companion object {
        fun newInstance(itemId: Int): CompPhotosFrament {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment = CompPhotosFrament()
            fragment.arguments = args
            return fragment
        }
    }

    private fun initViewModel() {
        factory = PhotoUploadViewModelFactory(context!!)
        photoUploadViewModel =
            ViewModelProvider(this, factory).get(PhotoUploadViewModel::class.java)
    }

    private fun observeUploadPhoto() {
        photoUploadViewModel.categoryResponse.observeOnce(viewLifecycleOwner, Observer {
            if (it.status == APIStatus.ok) {
                setRecyclerView(it.data)
                catData = it.data
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
    }

    private fun searchCat() {
        // listening to search query text change
        view.svCategory.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // filter recycler view when query submitted
                adapterCompCategories.getFilter().filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                // filter recycler view when text is changed
                adapterCompCategories.getFilter().filter(query)
                return false
            }
        })
    }

    private fun setRecyclerView(catData: ArrayList<PhotoUploadCategoryResponse.Data>) {
        adapterCompCategories = CompCategoriesAdapter(context!!, catData, {
            currentCategoryPosition = it as Int
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }, {
            currentCategoryPosition = it as Int
            val intent = Intent(context, CameraActivity::class.java)
            intent.putExtra(Const.INTENT_POSITION_KEY, currentCategoryPosition)
            startActivity(intent)
        }, {
            currentCategoryPosition = it as Int
            var category = catData.get(currentCategoryPosition).text
            val builder = AlertDialog.Builder(context!!)
            builder.setTitle(getString(R.string.app_name))
            builder.setMessage(
                resources.getString(R.string.sure_delete_text) + " $category " + resources.getString(
                    R.string.image_text
                )
            )
            builder.setPositiveButton(resources.getString(R.string.yes_text)) { _, _ ->
                //PhotoUpload Disha
                catData[currentCategoryPosition].photoUrl = ""
                newPhotosId.remove(catData[currentCategoryPosition].PhotoTypeId)
                Pref.setCategoriesArrayList(
                    context!!,
                    Const.CATEGORIES_SHARED_PREF_KEY,
                    catData
                )
                adapterCompCategories.notifyItemChanged(currentCategoryPosition)
            }

            builder.setNegativeButton(android.R.string.no) { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        })

        view.rvCategories.layoutManager = GridLayoutManager(context, 2)
        view.rvCategories.adapter = adapterCompCategories
    }

    private fun getCategoryList() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParam.put("UserId", Pref.getValue(context!!, Pref.USER_ID, 0))
        postParam.put("itemid", itemId)
        postParam.put("actiontype", "C")
        photoUploadViewModel.getCategoryList(postParam)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data!!
            newPhotosId.add(currentCategoryPosition, catData[currentCategoryPosition].PhotoTypeId)
            //PhotoUpload Disha
            catData[currentCategoryPosition].photoUrl =CommonUtils.getRealPathFromURI(context!!, imageUri).toString()
            catData[currentCategoryPosition].isFromDevice = true;
            Pref.setCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, catData)
            catData =
                Pref.getCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, "")
            adapterCompCategories.notifyItemChanged(currentCategoryPosition)
        }
    }
    private fun clickEvent() {
        view.btnSubmit.setOnClickListener {
            if (newPhotosId.size == 0) {
                CommonUtils.showOkDialog(
                    context!!, resources.getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ -> },
                    resources.getString(R.string.ok)
                )
            }
        }
    }
}