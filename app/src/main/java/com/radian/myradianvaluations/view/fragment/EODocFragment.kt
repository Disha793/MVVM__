package com.radian.myradianvaluations.view.fragment

import android.Manifest
import android.app.Activity
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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.VendorProfileResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.*
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.EODocViewModel
import com.radian.myradianvaluations.viewmodel.EODocViewModelFactory
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
    private lateinit var eoDocViewModel: EODocViewModel
    private lateinit var factory: EODocViewModelFactory


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
        initViewModel()
        observeEoDocData()
        return view
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
        getEOData()
    }

    private fun initViewModel() {
        factory = EODocViewModelFactory(context!!)
        eoDocViewModel = ViewModelProvider(this, factory).get(EODocViewModel::class.java)
    }

    private fun observeEoDocData() {
        eoDocViewModel.uploadImageResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                LogUtils.logD(TAG, "" + it)
                it.data?.let {
                }
            })
        eoDocViewModel.vendorProfileResponse.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, true)) {
                    eoList.add(it.data)
                    if (eoList.isNotEmpty())
                        setData()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context!!.toastShort(it.errorInfo.get(0).errorMessage)

                    var intent = Intent(context, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                } else if (it.status.equals(APIStatus.error, true)) {
                    if (it.errorInfo.isNotEmpty() && it.errorInfo.get(0).errorCode.equals("EONoUpdate")) {
                        view.txtNoData.makeVisible()
                        view.linearData.makeGone()
                        view.btnSubmitEo.makeGone()
                        view.txtNoData.setText(it.errorInfo.get(0).errorMessage)
                    }
                }
            })
        eoDocViewModel.saveEoDocResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it.status.equals(APIStatus.ok, true)) {
//on success
            } else if (it.status.equals(APIStatus.error, true)) {
//on error
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }

        })
    }

    private fun setCameraImage() {
        displayThumbnail()
        fileUri = photoFile.path
        if (!fileUri.equals("")) {
            //Disha: For next release
            uploadDoc(fileUri)
        }
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

    override fun onClick(dialog: DialogInterface?, position: Int) {
        when (position) {
            0 -> openCamera()
            1 -> openGallery()
            2 -> dialog!!.dismiss()
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.txtAddDoc -> {
                if (CommonUtils.checkPermission(context!!)) {
                    CommonUtils.openDialog(context!!, this)
                } else {
                    requestPermission()
                }
            }
            R.id.imgDocDelete -> {
                CommonUtils.showDialog(
                    context!!,
                    context!!.resources.getString(R.string.delete_message),
                    DialogInterface.OnClickListener { _, _ ->
                        view.frameDoc.makeGone()
                        view.txtAddDoc.makeVisible()


                    },
                    DialogInterface.OnCancelListener { _ ->

                    }, "Delete", "Cancel"

                )
            }
            R.id.btnSubmitEo -> {
                if (checkValidation() && eoList.isNotEmpty()) {
                    //Disha: For next release
                    submitData()
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
            view.snack(getString(R.string.enter_coverage_amount)) {}

            return false
        } else if (TextUtils.isEmpty(edtPolicyNo.text.toString())) {
            view.snack(getString(R.string.enter_policy_number)) {}

            return false
        } else if (TextUtils.isEmpty(edtProvider.text.toString())) {
            view.snack(getString(R.string.enter_provider_name)) {}

            return false
        } else if (TextUtils.isEmpty(edtExpiryDate.text.toString())) {
            view.snack(getString(R.string.enter_expiry_date)) {}

            return false
        }
        return true

    }

    private fun submitData() {
        val postParams = HashMap<String, Any?>()
        postParams.put(
            "PhoneNumber",
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!
        )
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParams.put("VENDORID", eoList.get(0).vENDORID)
        postParams.put("VENDORGROUPID", eoList.get(0).vENDORGROUPID)
        postParams.put("DOCGROUP", eoList.get(0).dOCGROUP)
        postParams.put("DOCID", eoList.get(0).dOCID)
        postParams.put("EOCARRIER", view.edtProvider.text.toString())
        postParams.put("DOCIDABBR", eoList.get(0).dOCIDABBR)
        postParams.put("VPCATEGORY", eoList.get(0).vPCATEGORY)
        postParams.put("EOAMOUNT", view.edtCoverageAmnt.text.toString())
        postParams.put("EOPOLICYNO", view.edtPolicyNo.text.toString())
        postParams.put("EXPIRYDATE", view.edtExpiryDate.text.toString())
        eoDocViewModel.saveEoDateResponse(postParams)
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

    private fun getEOData() {
        val postParams = HashMap<String, Any?>()
        postParams.put(
            "PhoneNumber",
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!
        )
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParams.put("ActionType", "PROFILEEO")
        eoDocViewModel.getVendorProfileDetails(postParams)
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
                    uploadDoc(fileUri)
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

        eoDocViewModel.uploadImage(profileImgBody, filename, postField)

    }

    private fun displayThumbnail() {
        view.frameDoc.makeVisible()
        view.txtAddDoc.makeGone()

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