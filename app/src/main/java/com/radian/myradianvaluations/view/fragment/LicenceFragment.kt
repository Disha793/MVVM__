package com.radian.myradianvaluations.view.fragment


import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.radian.vendorbridge.Response.LicenceMasterModel
import kotlinx.android.synthetic.main.fragment_licence_update.view.*
import java.util.*
import kotlin.collections.ArrayList
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.EOViewModel
import com.radian.vendorbridge.Response.ProfileImageResponse
import com.radian.vendorbridge.Response.StatusResponse
import com.radian.vendorbridge.Response.VendorProfileResponse
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_licence_update.*
import kotlinx.android.synthetic.main.fragment_licence_update.view.frameDoc
import kotlinx.android.synthetic.main.fragment_licence_update.view.linearData
import kotlinx.android.synthetic.main.fragment_licence_update.view.txtAddDoc
import kotlinx.android.synthetic.main.fragment_licence_update.view.txtNoData
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.text.SimpleDateFormat


class LicenceFragment : Fragment(), View.OnClickListener, DialogInterface.OnClickListener {
    override fun onClick(dialog: DialogInterface?, position: Int) {
        when (position) {
            0 -> openCamera()
            1 -> openGallery()
            2 -> dialog!!.dismiss()
        }
    }

    internal lateinit var view: View
    internal lateinit var calendar: Calendar
    lateinit var dateListener: DatePickerDialog.OnDateSetListener
    lateinit var spinnerAdapter: ArrayAdapter<LicenceMasterModel.Data.Licence>
    private var licenceTypeList = ArrayList<LicenceMasterModel.Data.Licence>()
    private val REQUEST_FOR_CAMERA = 101
    private val REQUEST_FOR_GALLERY = 102
    private val REQUEST_PERMISSION_ACESS = 103
    private val licenceList = java.util.ArrayList<VendorProfileResponse.Data>()
    internal lateinit var photoURI: Uri
    lateinit var photoFile: File
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val TAG = this.javaClass.simpleName
    private var fileUri: String = ""
    private val firebaseParams = Bundle()
    private lateinit var eoViewModel: EOViewModel
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.edtExpiryDte -> {
                calendar = Calendar.getInstance()
                showDatePickerDialog()
            }
            R.id.txtAddDoc -> {
                if (CommonUtils.checkPermission(context!!)) {
                    openDialog()
                } else {
                    requestPermission()
                }
            }
            R.id.btnSubmitLi -> {
                if (checkValidation() && licenceList.isNotEmpty())
                    submitData()
            }
            R.id.imgDocDelete -> {
                CommonUtils.showDialog(
                    context!!,
                    context!!.resources.getString(R.string.delete_message),
                    DialogInterface.OnClickListener { _, _ ->
                        view.frameDoc.visibility = View.GONE
                        view.txtAddDoc.visibility = View.VISIBLE


                    },
                    DialogInterface.OnCancelListener { _ ->

                    }, "Delete", "Cancel"

                )
            }

        }
    }

    private fun checkValidation(): Boolean {
        if (TextUtils.isEmpty(edtExpiryDte.text.toString())) {
            CommonUtils.displayMessage(view, "Please select expiry date.")
            return false
        }
        return true
    }

    private fun requestPermission() {

        requestPermissions(

            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
            ),
            REQUEST_PERMISSION_ACESS
        )

    }

    private fun openDialog() {
        val builder = AlertDialog.Builder(context)

        var options = Array<CharSequence>(3, { "" })
        options[0] = "Camera"
        options[1] = "Gallery"
        options[2] = "Cancel"
        builder.setTitle("Select Options")
        builder.setItems(options, this)
        builder.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        view = inflater.inflate(R.layout.fragment_licence_update, container, false)
        spinnerAdapter =
            ArrayAdapter(context!!, R.layout.spinner_item, licenceTypeList)
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item)
        eoViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(EOViewModel::class.java)
        eoViewModel.init(context as BottomNavigationActivity)
        view.spnLicenceTyp.setAdapter(spinnerAdapter)
        view.edtExpiryDte.setOnClickListener(this)
        view.btnSubmitLi.setOnClickListener(this)
        view.txtAddDoc.setOnClickListener(this)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view.txtAddDoc.visibility = View.VISIBLE
        getLicenceMaster()

        dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            view.edtExpiryDte.setText(
                SimpleDateFormat(Const.formatMM, Locale.US).format(
                    calendar.timeInMillis
                )
            )
        }
    }

    private fun getLicenceMaster() {
        LoadingDialog.show(context as BottomNavigationActivity)
        eoViewModel.getLicenceMaster().let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, ignoreCase = true)) {
                    licenceTypeList.addAll(it.data.listLicence)
                    spinnerAdapter.notifyDataSetChanged()
                    getLicenceData()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    Toast.makeText(
                        context!!,
                        it.errorInfo.get(0).errorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
            if (it == null) {
                LoadingDialog.dismissDialog()
            }
        }

    }

    private fun getLicenceData() {
        eoViewModel.getVendorProfileDetails("PROFILELI").let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    licenceList.add(it.data)
                    if (licenceList.isNotEmpty())
                        setData()
                } else if (it.status.equals(APIStatus.error, true)) {
                    if (it.errorInfo.isNotEmpty() && it.errorInfo.get(0).errorCode.equals("licenceNoUpdate")) {
                        view.txtNoData.visibility = View.VISIBLE
                        view.linearData.visibility = View.GONE
                        view.btnSubmitLi.visibility = View.GONE
                        view.txtNoData.setText(it.errorInfo.get(0).errorMessage)
                    }
                }

            })
            if (it == null) {
                LoadingDialog.dismissDialog()
                CommonUtils.showOkDialog(
                    context!!,
                    getString(R.string.please_try_again),
                    DialogInterface.OnClickListener { _, _ ->


                    },
                    getString(R.string.ok)
                )
            }
        }

    }

    private fun submitData() {

        RetrofitBase.getClient().create(APIList::class.java)
            .saveLicenceDetails(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                "PROFILELI",
                licenceList.get(0).vENDORID,
                licenceList.get(0).vENDORGROUPID,
                licenceList.get(0).dOCGROUP,
                licenceList.get(0).dOCID,
                licenceList.get(0).dOCDESCRIPTION,
                licenceList.get(0).dOCIDABBR,
                licenceList.get(0).vPCATEGORY,
                edtLicenceNo.text.toString(),
                spinnerAdapter.getItem(spnLicenceTyp.selectedItemPosition)!!.valueCode,
                edtExpiryDte.text.toString()


            ).subscribeOn(Schedulers.io())

            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<StatusResponse> {
                override fun onComplete() {
                    LoadingDialog.dismissDialog()

                }

                override fun onSubscribe(d: Disposable) {
                    LoadingDialog.show(context!!)
                }

                override fun onNext(t: StatusResponse) {
                    if (t.status.equals(APIStatus.ok, true)) {

//on success
                    } else if (t.status.equals(APIStatus.unauth, true)) {
                        Toast.makeText(context, t.errorInfo.get(0).errorMessage, Toast.LENGTH_SHORT)
                            .show()
                        var intent = Intent(context, PasscodeActivity::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    }

                }

                override fun onError(e: Throwable) {
                    LogUtils.logE(TAG, e.message!!, e)
                    LoadingDialog.dismissDialog()
                    CommonUtils.showOkDialog(
                        context!!,
                        getString(R.string.please_try_again),
                        DialogInterface.OnClickListener { _, _ ->
                            submitData()

                        },
                        getString(R.string.ok)
                    )
                }

            })
    }

    private fun setData() {
        view.edtLicenceholder.setText(licenceList.get(0).dOCDESCRIPTION)
        view.edtLicenceNo.setText(licenceList.get(0).lICENSE)
        view.edtLiState.setText(licenceList.get(0).lICENSESTATE)
        view.spnLicenceTyp.setSelection(
            spinnerAdapter.getPosition(
                licenceTypeList.get(
                    getIndex(
                        licenceList.get(0).lICENSETYPEID
                    )
                )!!
            )
        )
        view.edtExpiryDte.setText(licenceList.get(0).eXPIRYDATE)
        view.txtLiStatus.setText(licenceList.get(0).lICSTATUS)
    }

    private fun getIndex(myString: String?): Int {
        for (i in 0..licenceTypeList.size) {
            if (licenceTypeList.get(i).valueCode.equals(myString))
                return i

        }

        return 0
    }

    private fun uploadDoc(fileUri: String) {
        val file = File(fileUri)
        val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)

        val profileImgBody =
            MultipartBody.Part.createFormData("file", file.name, requestBody)
        val filename = CommonUtils.requestBody(file.name)
        val postField = HashMap<String, RequestBody>()
        postField.put(
            "PhoneNumber",
            CommonUtils.requestBody(Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!)
        )
        postField.put("DeviceID", CommonUtils.requestBody(CommonUtils.getDeviceUUID(context!!)))
        postField.put("CATEGORY", CommonUtils.requestBody("LICENSE"))
        postField.put(
            "MobileUserId",
            CommonUtils.requestBody(Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString())
        )
        postField.put("DocumentType", CommonUtils.requestBody(licenceList.get(0).dOCIDABBR!!))
        postField.put("Description", CommonUtils.requestBody(licenceList.get(0).dOCDESCRIPTION!!))
        postField.put("DOCGROUP", CommonUtils.requestBody(licenceList.get(0).dOCGROUP!!))
        postField.put("FileName", CommonUtils.requestBody(file.name))
        RetrofitBase.getClient().create(APIList::class.java)
            .uploadImage(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                profileImgBody,
                filename,
                postField
            )
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ProfileImageResponse> {
                override fun onComplete() {
                    LoadingDialog.dismissDialog()
                }

                override fun onSubscribe(d: Disposable) {
                    LoadingDialog.show(context!!)
                }

                override fun onNext(t: ProfileImageResponse) {
                    LogUtils.logD("Getting On Rsposne", "" + t)
                    t.data?.let {


                    }

                }

                override fun onError(e: Throwable) {
                    LogUtils.logD("Getting On Error", "" + e.message)
                    LoadingDialog.dismissDialog()
                }
            })

    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = createImageFile()
        photoURI =
            FileProvider.getUriForFile(context!!, context!!.packageName + ".provider", photoFile)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        startActivityForResult(intent, REQUEST_FOR_CAMERA)
    }

    private fun openGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, REQUEST_FOR_GALLERY)
    }

    private fun createImageFile(): File {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val imageFileName = Const.imgnName + timeStamp + "_"
        val storageDir = context!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        // Save a file: path for use with ACTION_VIEW intents
        return File.createTempFile(
            imageFileName, // prefix
            ".jpg", // suffix
            storageDir      // directory
        )
    }

    private fun showDatePickerDialog() {

        var datePickerDialog = DatePickerDialog(
            context!!,
            dateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)

        )
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        datePickerDialog.show()
    }

    private fun setCameraImage() {
        displayThumbnail()
        fileUri = photoFile.path
        if (!fileUri.equals(""))
            uploadDoc(fileUri)
    }

    private fun displayThumbnail() {
        view.frameDoc.visibility = View.VISIBLE
        view.txtAddDoc.visibility = View.GONE

    }

    private fun setGalleryImage(data: Intent?) {
        if (data != null) {
            val contentURI = data.data!!
            try {

                displayThumbnail()
                fileUri = CommonUtils.getRealPathFromURI(context!!, contentURI)!!
                if (!fileUri.equals(""))
                    uploadDoc(fileUri)
            } catch (e: Exception) {
                LogUtils.logD(TAG, e.message!!)
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_ACESS) {
            var i = 0
            val len = permissions.size
            while (i < len) {
                val permission = permissions[i]
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                    //User rejected the permission
                    val showRationale =
                        ActivityCompat.shouldShowRequestPermissionRationale(
                            context as BottomNavigationActivity,
                            permission
                        )
                    if (!showRationale) {
                        val snackBar = Snackbar.make(
                            view,
                            getString(R.string.permission_profile),
                            Snackbar.LENGTH_LONG
                        )
                        snackBar.setActionTextColor(
                            ContextCompat.getColor(
                                context!!,
                                android.R.color.white
                            )
                        )
                        snackBar.setAction("SETTINGS") {
                            val intent =
                                Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            val uri =
                                Uri.fromParts("package", context!!.getPackageName(), null)
                            intent.data = uri
                            startActivityForResult(intent, 12)
                            snackBar.dismiss()
                        }
                        snackBar.show()
                    } else {
                        val snackBar = Snackbar.make(
                            view,
                            getString(R.string.permission_profile),
                            Snackbar.LENGTH_LONG
                        )
                        snackBar.setActionTextColor(Color.WHITE)
                        snackBar.setAction("ALLOW") {
                            requestPermission()
                            snackBar.dismiss()
                        }
                        snackBar.show()
                    }

                }
                i++
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_FOR_CAMERA -> {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "LiDocTapped")
                    CommonUtils.addParamstoFirebaseEvent(
                        firebaseAnalytics,
                        Const.methodInvoked,
                        firebaseParams
                    )
                    setCameraImage()
                }

                REQUEST_FOR_GALLERY ->
                    setGalleryImage(data)
            }
        }

    }

}