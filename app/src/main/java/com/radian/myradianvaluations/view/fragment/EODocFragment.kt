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
import android.widget.DatePicker
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
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
import kotlinx.android.synthetic.main.fragment_eo_doc.*
import kotlinx.android.synthetic.main.fragment_eo_doc.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

class EODocFragment : Fragment(), View.OnClickListener, DialogInterface.OnClickListener {
    override fun onClick(dialog: DialogInterface?, position: Int) {
        when (position) {
            0 -> openCamera()
            1 -> openGallery()
            2 -> dialog!!.dismiss()
        }
    }

    private val REQUEST_FOR_CAMERA = 101
    private val REQUEST_FOR_GALLERY = 102
    private val REQUEST_PERMISSION_ACESS = 103
    internal lateinit var view: View
    internal lateinit var photoURI: Uri
    lateinit var photoFile: File
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val TAG = this.javaClass.simpleName
    private val firebaseParams = Bundle()
    private var fileUri: String = ""
    private val eoList = ArrayList<VendorProfileResponse.Data>()
    lateinit var dateListener: DatePickerDialog.OnDateSetListener
    internal lateinit var calendar: Calendar
    internal var postParam = HashMap<String, Any?>()
    private lateinit var eoViewModel: EOViewModel
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.txtAddDoc -> {
                if (CommonUtils.checkPermission(context!!)) {
                    openDialog()
                } else {
                    requestPermission()
                }
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
            R.id.btnSubmitEo -> {
                if (checkValidation() && eoList.isNotEmpty()) {
                    //Disha: For next release
//                    submitData()
                }
            }
            R.id.edtExpiryDate -> {
                calendar = Calendar.getInstance()
                showDatePickerDialog()
            }

        }
    }

    private fun checkValidation(): Boolean {
        if (TextUtils.isEmpty(edtCoverageAmnt.text.toString())) {
            CommonUtils.displayMessage(view, getString(R.string.enter_coverage_amount))
            return false
        } else if (TextUtils.isEmpty(edtPolicyNo.text.toString())) {
            CommonUtils.displayMessage(view, getString(R.string.enter_policy_number))
            return false
        } else if (TextUtils.isEmpty(edtProvider.text.toString())) {
            CommonUtils.displayMessage(view, getString(R.string.enter_provider_name))
            return false
        } else if (TextUtils.isEmpty(edtExpiryDate.text.toString())) {
            CommonUtils.displayMessage(view, getString(R.string.enter_expiry_date))
            return false
        }
        return true

    }

    private fun submitData() {

        RetrofitBase.getClient().create(APIList::class.java).saveEoDetails(
            Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
            CommonUtils.getDeviceUUID(context!!),
            Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
            eoList.get(0).vENDORID,
            eoList.get(0).vENDORGROUPID,
            eoList.get(0).dOCGROUP,
            eoList.get(0).dOCID,
            view.edtProvider.text.toString(),
            eoList.get(0).dOCIDABBR,
            eoList.get(0).vPCATEGORY,
            view.edtCoverageAmnt.text.toString(),
            view.edtPolicyNo.text.toString(),
            view.edtExpiryDate.text.toString()

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
                    } else if (t.status.equals(APIStatus.error, true)) {
//on error
                    } else if (t.status.equals(APIStatus.unauth, true)) {
                        Toast.makeText(context, t.errorInfo.get(0).errorMessage, Toast.LENGTH_SHORT)
                            .show()
                        var intent = Intent(context, PasscodeActivity::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(intent)
                    }

                }

                override fun onError(e: Throwable) {
                    LoadingDialog.dismissDialog()
                    CommonUtils.showOkDialog(
                        context!!,
                        getString(R.string.please_try_again),
                        DialogInterface.OnClickListener { _, _ ->


                        },
                        getString(R.string.ok)
                    )

                }
            })
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

    private fun openGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, REQUEST_FOR_GALLERY)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = createImageFile()
        photoURI =
            FileProvider.getUriForFile(context!!, context!!.packageName + ".provider", photoFile)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
        startActivityForResult(intent, REQUEST_FOR_CAMERA)
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        view = inflater.inflate(R.layout.fragment_eo_doc, container, false)
        view.txtAddDoc.setOnClickListener(this)
        view.imgDocDelete.setOnClickListener(this)
        view.btnSubmitEo.setOnClickListener(this)
        view.edtExpiryDate.setOnClickListener(this)
        eoViewModel =
            ViewModelProvider(context as BottomNavigationActivity).get(EOViewModel::class.java)
        eoViewModel.init(context as BottomNavigationActivity)
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_FOR_CAMERA -> {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "E&ODocTapped")
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dateListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, month)
                calendar.set(Calendar.DAY_OF_MONTH, day)
                view.edtExpiryDate.setText(
                    SimpleDateFormat(Const.formatMM, Locale.US).format(
                        calendar.timeInMillis
                    )
                )

            }
        }
        //Disha: For next release
//        getEOData()
    }

    private fun setCameraImage() {
        displayThumbnail()
        fileUri = photoFile.path
        if (!fileUri.equals("")) {
            //Disha: For next release
//            uploadDoc(fileUri)
        }
    }

    private fun getEOData() {
        LoadingDialog.show(context as BottomNavigationActivity)
        eoViewModel.getVendorProfileDetails("PROFILEEO").let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    eoList.add(it.data)
                    if (eoList.isNotEmpty())
                        setData()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    Toast.makeText(context, it.errorInfo.get(0).errorMessage, Toast.LENGTH_SHORT)
                        .show()
                    var intent = Intent(context, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                } else if (it.status.equals(APIStatus.error, true)) {
                    if (it.errorInfo.isNotEmpty() && it.errorInfo.get(0).errorCode.equals("EONoUpdate")) {
                        view.txtNoData.visibility = View.VISIBLE
                        view.linearData.visibility = View.GONE
                        view.btnSubmitEo.visibility = View.GONE
                        view.txtNoData.setText(it.errorInfo.get(0).errorMessage)
                    }
                }

            })
            if (it == null) {
                LoadingDialog.dismissDialog()
            }
        }

    }

    private fun setData() {
        view.edtCoverageAmnt.setText(eoList.get(0).eOAMOUNT)
        view.edtExpiryDate.setText(eoList.get(0).eXPIRYDATE)
        view.edtPolicyNo.setText(eoList.get(0).eOPOLICYNO)
        view.edtProvider.setText(eoList.get(0).eOCARRIER)
    }

    private fun setGalleryImage(data: Intent?) {
        if (data != null) {
            val contentURI = data.data!!
            try {

                displayThumbnail()
                fileUri = CommonUtils.getRealPathFromURI(context!!, contentURI)!!
                if (!fileUri.equals("")) {
                    //Disha: For next release
//                    uploadDoc(fileUri)
                }

            } catch (e: Exception) {
                LogUtils.logD(TAG, e.message!!)
            }

        }
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
        postField.put("DocumentType", CommonUtils.requestBody(eoList.get(0).dOCIDABBR!!))
        postField.put("Description", CommonUtils.requestBody(eoList.get(0).dOCDESCRIPTION!!))
        postField.put("DOCGROUP", CommonUtils.requestBody(eoList.get(0).dOCGROUP!!))
        postField.put("FileName ", CommonUtils.requestBody(file.name))
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
                    CommonUtils.showOkDialog(
                        context!!,
                        getString(R.string.please_try_again),
                        DialogInterface.OnClickListener { _, _ ->


                        },
                        getString(R.string.ok)
                    )
                }
            })


    }

    private fun displayThumbnail() {
        view.frameDoc.visibility = View.VISIBLE
        view.txtAddDoc.visibility = View.GONE

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


}