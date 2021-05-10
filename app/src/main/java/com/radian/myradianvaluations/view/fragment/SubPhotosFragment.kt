package com.radian.myradianvaluations.view.fragment

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.adapter.CompCategoriesAdapter
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.constants.Const.IS_REFRESH_SUB
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.CameraActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.PhotoUploadViewModel
import com.radian.myradianvaluations.viewmodel.PhotoUploadViewModelFactory
import kotlinx.android.synthetic.main.fragment_all_sub_photos.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class SubPhotosFragment : Fragment(), LocationListener, DialogInterface.OnClickListener {
    private var currentLongitude: Double = 0.0
    private var currentLatitude: Double = 0.0
    private lateinit var catData: java.util.ArrayList<PhotoUploadCategoryResponse.Data>
    private var itemId: Int = 0
    private lateinit var photoUploadViewModel: PhotoUploadViewModel
    private lateinit var factory: PhotoUploadViewModelFactory
    internal lateinit var view: View
    private lateinit var adapterCompCategories: CompCategoriesAdapter
    private var currentCategoryPosition: Int = 0
    private var pickImage = 100
    private lateinit var imageUri: Uri
    private lateinit var locationManager: LocationManager
    private val locationPermissionCode = 2

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
        getLocation()
        if(IS_REFRESH_SUB) {
            getCategoryList()
        }
        searchCat()
        observeUploadPhoto()
        clickEvent()
        return view
    }

    companion object {
        fun newInstance(itemId: Int): SubPhotosFragment {
            val args = Bundle()
            args.putInt(Const.itemIdTag, itemId)
            val fragment = SubPhotosFragment()
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
                catData = it.data
                setRecyclerView(it.data)
            } else if (it.status.equals(APIStatus.unauth, true)) {
                if (it.status == APIStatus.ok) {
                    (context as BottomNavigationActivity).onBackPressed()
                } else {
                    context!!.toastShort(it.errorInfo.get(0).errorMessage)
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            }
        })
        photoUploadViewModel.uploadPhotosResponse.observe(viewLifecycleOwner, Observer {
            if (it.status == APIStatus.unauth) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context!!, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            } else {
                (context as BottomNavigationActivity).onBackPressed()
            }
        })
    }

    private fun searchCat() {
        view.svCategory.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapterCompCategories.getFilter().filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapterCompCategories.getFilter().filter(query)
                return false
            }
        })
    }

    private fun setRecyclerView(catData: ArrayList<PhotoUploadCategoryResponse.Data>) {
        adapterCompCategories =
            CompCategoriesAdapter(context!!, catData, { filterList: Any, pos: Any ->
                currentCategoryPosition = pos as Int
                this.catData = filterList as ArrayList<PhotoUploadCategoryResponse.Data>
                openDialog()
            },
//                { filterList: Any, pos: Any ->
//                currentCategoryPosition = pos as Int
//                this.catData = filterList as ArrayList<PhotoUploadCategoryResponse.Data>
//                val intent = Intent(context, CameraActivity::class.java)
//                intent.putExtra(Const.INTENT_POSITION_KEY, currentCategoryPosition)
//                intent.putExtra(Const.itemIdTag, itemId)
//                startActivity(intent)
//            },
                { filterList: Any, pos: Any ->
                    currentCategoryPosition = pos as Int
                    this.catData = filterList as ArrayList<PhotoUploadCategoryResponse.Data>
                    (context as BottomNavigationActivity).pushFragment(
                        ImageViewerFragment(
                            this.catData, currentCategoryPosition, itemId
                        ), true
                    )

//                    val dialog = ImageViewerFragment(catData, currentCategoryPosition, itemId)
//                    dialog.setTargetFragment(this, 500)
//                    dialog.show(childFragmentManager, "ImageViewer")

                })

        view.rvCategories.layoutManager = GridLayoutManager(context, 2)
        view.rvCategories.adapter = adapterCompCategories
    }

    private fun openDialog() {
        CommonUtils.openDialog(context!!, this)
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
        val intent = Intent(context, CameraActivity::class.java)
        intent.putExtra(Const.INTENT_POSITION_KEY, currentCategoryPosition)
        intent.putExtra(Const.itemIdTag, itemId)
        startActivity(intent)
    }

    private fun getCategoryList() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0))
        postParam.put("OrganizationIds", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0))
        postParam.put("UserId", Pref.getValue(context!!, Pref.USER_ID, 0))
        postParam.put("itemid", itemId)
        postParam.put("actiontype", "S")
        photoUploadViewModel.getCategoryList(postParam)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == AppCompatActivity.RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data!!
            val calendar: Calendar = Calendar.getInstance()
            val timeInMillis: Long = calendar.getTimeInMillis()
            IS_REFRESH_SUB=false
            catData[currentCategoryPosition].newPhotosId.add(CommonUtils.getRealPathFromURI(context!!, imageUri).toString())

            val photoListItm = PhotoUploadCategoryResponse.PhotoList()
            photoListItm.photoUrl = CommonUtils.getRealPathFromURI(context!!, imageUri).toString()
            photoListItm.timeStamp = timeInMillis
            photoListItm.lat = currentLatitude
            photoListItm.long = currentLongitude
            photoListItm.isFromDevice = true

            val extsitngList = catData[currentCategoryPosition].photoList
            extsitngList.add(photoListItm)
            catData[currentCategoryPosition].photoList = extsitngList

            Pref.setCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, catData)
            catData =
                Pref.getCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, "")
            adapterCompCategories.notifyItemChanged(currentCategoryPosition)
        }
        if (resultCode == 500) {
            catData =
                Pref.getCategoriesArrayList(context!!, Const.CATEGORIES_SHARED_PREF_KEY, "")
            adapterCompCategories.notifyItemChanged(currentCategoryPosition)
        }
    }

    private fun clickEvent() {
        view.btnSubmit.setOnClickListener {
            if (catData[currentCategoryPosition].newPhotosId == null || catData[currentCategoryPosition].newPhotosId.size == 0) {
                CommonUtils.showOkDialog(
                    context!!, resources.getString(R.string.select_photo_text),
                    DialogInterface.OnClickListener { _, _ -> },
                    resources.getString(R.string.ok)
                )
            } else {
                val postField = java.util.HashMap<String, RequestBody>()
                val parts: ArrayList<MultipartBody.Part> = ArrayList()
                var count: Int = 0
                for (i in 0 until catData.size) {
                    var file: MultipartBody.Part? = null
                    for (j in 0 until catData[i].photoList.size) {
                        if (catData[i].photoList[j].isFromDevice) {

                            val fileUri = File(catData[i].photoList[j].photoUrl)
                            val requestBody =
                                RequestBody.create(MediaType.parse("multipart/form-data"), fileUri)
                            file =
                                MultipartBody.Part.createFormData(
                                    "file" + count,
                                    fileUri.name,
                                    requestBody
                                )
                            postField.put(
                                "Description" + count,
                                CommonUtils.requestBody(catData[i].text)
                            )
                            postField.put(
                                "DateTimeOriginal" + count,
                                CommonUtils.requestBody(catData[i].photoList[j].timeStamp.toString())
                            )
                            postField.put("FileName" + count, CommonUtils.requestBody(fileUri.name))
                            postField.put(
                                "GPSLatitude" + count,
                                CommonUtils.requestBody(catData[i].photoList[j].lat.toString())
                            )
                            postField.put(
                                "GPSLongitude" + count,
                                CommonUtils.requestBody(catData[i].photoList[j].long.toString())
                            )
                            postField.put(
                                "PhotoTypeId" + count,
                                CommonUtils.requestBody(catData[i].PhotoTypeId.toString())
                            )
                            count++
                            parts.add(file!!)
                        }


                    }
                }
                postField.put(
                    "Count",
                    CommonUtils.requestBody(parts.size.toString())
                )
                postField.put(
                    "PhoneNumber",
                    CommonUtils.requestBody(Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
                )
                postField.put(
                    "DeviceID",
                    CommonUtils.requestBody(CommonUtils.getDeviceUUID(context!!))
                )
                postField.put(
                    "MobileUserId",
                    CommonUtils.requestBody(
                        Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
                    )
                )
                postField.put(
                    "UserId", CommonUtils.requestBody(
                        Pref.getValue(context!!, Pref.USER_ID, 0)
                            .toString()
                    )
                )
                postField.put("itemid", CommonUtils.requestBody(itemId.toString()))
                photoUploadViewModel.uploadPhoto(parts, postField)
            }
        }
    }

    private fun getLocation() {
        locationManager = context!!.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                (context as Activity?)!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                (context as Activity?)!!,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)
    }

    override fun onLocationChanged(loc: Location) {
        currentLatitude = loc.latitude
        currentLongitude = loc.longitude
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}

}