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
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.LicenceMasterModel
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
import kotlinx.android.synthetic.main.fragment_licence_update.*
import kotlinx.android.synthetic.main.fragment_licence_update.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class LicenceFragment : Fragment(), View.OnClickListener, DialogInterface.OnClickListener {

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
    private lateinit var eoDocViewModel: EODocViewModel
    private lateinit var factory: EODocViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        view = inflater.inflate(R.layout.fragment_licence_update, container, false)
        initViewModel()
        setSpinner()
        view.edtExpiryDte.setOnClickListener(this)
        view.btnSubmitLi.setOnClickListener(this)
        view.txtAddDoc.setOnClickListener(this)
        observeLicenceData()
        return view
    }

    private fun setSpinner() {
        spinnerAdapter =
            ArrayAdapter(context!!, R.layout.spinner_item, licenceTypeList)
        spinnerAdapter.setDropDownViewResource(R.layout.spinner_item)
        view.spnLicenceTyp.setAdapter(spinnerAdapter)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view.txtAddDoc.makeVisible()
        //Disha: For next release
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

    private fun initViewModel() {
        factory = EODocViewModelFactory(context!!)
        eoDocViewModel = ViewModelProvider(this, factory).get(EODocViewModel::class.java)
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
            R.id.edtExpiryDte -> {
                calendar = Calendar.getInstance()
                showDatePickerDialog()
            }
            R.id.txtAddDoc -> {
                if (CommonUtils.checkPermission(context!!)) {
                    CommonUtils.openDialog(context!!, this)
                } else {
                    requestPermission()
                }
            }
            R.id.btnSubmitLi -> {
                //Disha: For next release
                if (checkValidation() && licenceList.isNotEmpty())
                    submitData()
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

        }
    }

    private fun checkValidation(): Boolean {
        if (TextUtils.isEmpty(edtExpiryDte.text.toString())) {
            view.snack(resources.getString(R.string.select_expiry_date)) {}

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


    private fun observeLicenceData() {

        eoDocViewModel.uploadImageResponse.observeOnce(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                LogUtils.logD(TAG, "" + it)
                it.data?.let {}
            })
        eoDocViewModel.licenceMasterResponse.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, ignoreCase = true)) {
                    licenceTypeList.addAll(it.data.listLicence)
                    spinnerAdapter.notifyDataSetChanged()
                    getLicenceData()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context!!.toastShort(it.errorInfo.get(0).errorMessage)

                    var intent = Intent(context!!, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                }
            })
        eoDocViewModel.vendorProfileResponse.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                if (it.status.equals(APIStatus.ok, true)) {
                    licenceList.add(it.data)
                    if (licenceList.isNotEmpty())
                        setData()
                } else if (it.status.equals(APIStatus.error, true)) {
                    if (it.errorInfo.isNotEmpty() && it.errorInfo.get(0).errorCode.equals("licenceNoUpdate")) {
                        view.txtNoData.makeVisible()
                        view.linearData.makeGone()
                        view.btnSubmitLi.makeGone()
                        view.txtNoData.setText(it.errorInfo.get(0).errorMessage)
                    }
                }
            })
        eoDocViewModel.saveLicenceResponse.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it.status.equals(APIStatus.ok, true)) {

//on success
            } else if (it.status.equals(APIStatus.unauth, true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }

        })
    }

    private fun getLicenceMaster() {
        val postParams = HashMap<String, Any?>()
        postParams.put(
            "PhoneNumber",
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!
        )
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParams.put("DropDownType", "LICTYPE")
        postParams.put("Organizations", Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!)
        eoDocViewModel.getLicenceMaster(postParams)
    }

    private fun getLicenceData() {
        val postParams = HashMap<String, Any?>()
        postParams.put(
            "PhoneNumber",
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!
        )
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParams.put("ActionType", "PROFILELI")
        eoDocViewModel.getVendorProfileDetails(postParams)
    }

    private fun submitData() {

        val postParams = HashMap<String, Any?>()
        postParams.put(
            "PhoneNumber",
            Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!
        )
        postParams.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParams.put("MobileUserId", Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!)
        postParams.put("ActionType", "PROFILELI")
        postParams.put("VENDORID", licenceList.get(0).vENDORID)
        postParams.put("VENDORGROUPID", licenceList.get(0).vENDORGROUPID)
        postParams.put("DOCGROUP", licenceList.get(0).dOCGROUP)
        postParams.put("DOCID", licenceList.get(0).dOCID)
        postParams.put("DOCDESCRIPTION", licenceList.get(0).dOCDESCRIPTION)
        postParams.put("DOCIDABBR", licenceList.get(0).dOCIDABBR)
        postParams.put("VPCATEGORY", licenceList.get(0).vPCATEGORY)
        postParams.put("LICENSE", edtLicenceNo.text.toString())
        postParams.put(
            "LICENSETYPEID",
            spinnerAdapter.getItem(spnLicenceTyp.selectedItemPosition)!!.valueCode
        )
        postParams.put("EXPIRYDATE", edtExpiryDte.text.toString())

        eoDocViewModel.saveLicenceResponse(postParams)
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

        val image =
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

        eoDocViewModel.uploadImage(image, filename, postField)

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
        //Disha: For next release
        if (!fileUri.equals(""))
            uploadDoc(fileUri)
    }

    private fun displayThumbnail() {
        view.frameDoc.makeVisible()
        view.txtAddDoc.makeGone()

    }

    private fun setGalleryImage(data: Intent?) {
        if (data != null) {
            val contentURI = data.data!!
            try {

                displayThumbnail()
                fileUri = CommonUtils.getRealPathFromURI(context!!, contentURI)!!
                //Disha: For next release
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