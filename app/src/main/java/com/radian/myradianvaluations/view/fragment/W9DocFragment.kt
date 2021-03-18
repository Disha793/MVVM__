package com.radian.myradianvaluations.view.fragment

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
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
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.Response.VendorProfileResponse
import com.radian.myradianvaluations.constants.APIStatus
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.EODocViewModel
import com.radian.myradianvaluations.viewmodel.EODocViewModelFactory

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_w9_doc.*
import kotlinx.android.synthetic.main.fragment_w9_doc.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class W9DocFragment : Fragment(), View.OnClickListener, DialogInterface.OnClickListener {
    internal var postParam = HashMap<String, Any?>()
    private lateinit var eoDocViewModel: EODocViewModel
    private lateinit var factory: EODocViewModelFactory
    internal lateinit var view: View
    private val REQUEST_FOR_CAMERA = 101
    private val REQUEST_FOR_GALLERY = 102
    private val REQUEST_PERMISSION_ACESS = 103
    private val w9List = java.util.ArrayList<VendorProfileResponse.Data>()
    internal lateinit var photoURI: Uri
    lateinit var photoFile: File
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val TAG = this.javaClass.simpleName
    private val firebaseParams = Bundle()
    private var fileUri: String = ""
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        view = inflater.inflate(R.layout.fragment_w9_doc, container, false)
        view.btnSubmitW9.setOnClickListener(this)
        view.txtAddDoc.setOnClickListener(this)
        initViewModel()
        observeW9DocData()
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //Disha: For next release
        getw9Data()
    }

    private fun initViewModel() {
        factory = EODocViewModelFactory(context!!)
        eoDocViewModel = ViewModelProvider(this, factory).get(EODocViewModel::class.java)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.txtAddDoc -> {
                if (CommonUtils.checkPermission(context!!)) {
                    openDialog()
                } else {
                    requestPermission()
                }
            }
            R.id.btnSubmitW9 -> {
                //Disha: For next release
                if (w9List.isNotEmpty() && checkValidation())
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

                        }, getString(R.string.delete), getString(R.string.cancel)

                )
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

    private fun observeW9DocData() {
        eoDocViewModel.uploadImageResponse.observeOnce(viewLifecycleOwner, androidx.lifecycle.Observer {
            LogUtils.logD(TAG, "" + it)
            it.data?.let {}
        })
    }

    private fun getw9Data() {
        LoadingDialog.show(context as BottomNavigationActivity)
        eoDocViewModel.getVendorProfileDetails("PROFILEW9").let {
            it?.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
                LoadingDialog.dismissDialog()
                if (it.status.equals(APIStatus.ok, true)) {
                    w9List.add(it.data)
                    if (w9List.isNotEmpty())
                        setData()
                } else if (it.status.equals(APIStatus.unauth, true)) {
                    context!!.toastShort(it.errorInfo.get(0).errorMessage)

                    var intent = Intent(context, PasscodeActivity::class.java)
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                } else if (it.status.equals(APIStatus.error, true)) {
                    if (it.errorInfo.isNotEmpty() && it.errorInfo.get(0).errorCode.equals(
                                    "W9NoUpdate",
                                    true
                            )
                    ) {
                        view.txtNoData.visibility = View.VISIBLE
                        view.linearData.visibility = View.GONE
                        view.btnSubmitW9.visibility = View.GONE
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

    private fun checkValidation(): Boolean {
        if (TextUtils.isEmpty(edtAddLine1.text.toString())) {
            view.snack(getString(R.string.enter_addressline_1)) {}
            return false
        }
        if (TextUtils.isEmpty(edtCity.text.toString())) {
            view.snack(getString(R.string.enter_city)) {}

            return false
        } else if (TextUtils.isEmpty(edtZip.text.toString())) {
            view.snack(getString(R.string.enter_zip)) {}

            return false
        } else if (TextUtils.isEmpty(edtstate.text.toString())) {
            view.snack(getString(R.string.enter_state)) {}
            return false
        }

        return true
    }

    private fun submitData() {
        postParam.put("AddressLine1", edtAddLine1.text.toString())
        postParam.put("AddressLine2", edtAddLine2.text.toString())
        postParam.put("City", edtCity.text.toString())
        postParam.put("State", edtstate.text.toString())
        postParam.put("Zip", edtZip.text.toString())
        RetrofitBase.getClient().create(APIList::class.java).saveW9Details(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                w9List.get(0).vENDORIDW9,
                postParam

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
                        if (t.status.equals("ok", true)) {
//on success
                        } else if (t.status.equals("error", true)) {
//on error
                        } else if (t.status.equals("UNAUTHORIZED", true)) {
                            context!!.toastShort(t.errorInfo.get(0).errorMessage)

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

    private fun setData() {


        view.edtAddLine1.setText(w9List.get(0).aDDRESSLINE1)
        view.edtAddLine2.setText(w9List.get(0).aDDRESSLINE2)
        view.edtZip.setText(w9List.get(0).zIP)
        view.edtCity.setText(w9List.get(0).cITY)
        view.edtstate.setText(w9List.get(0).sTATE)

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
        postField.put("CATEGORY", CommonUtils.requestBody("W9"))
        postField.put(
                "MobileUserId",
                CommonUtils.requestBody(Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString())
        )
        postField.put("DocumentType", CommonUtils.requestBody(w9List.get(0).dOCIDABBR!!))
        postField.put("Description", CommonUtils.requestBody(w9List.get(0).dOCDESCRIPTION!!))
        postField.put("DOCGROUP", CommonUtils.requestBody(w9List.get(0).dOCGROUP!!))
        postField.put("FileName ", CommonUtils.requestBody(file.name))

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

    private fun setCameraImage() {
        displayThumbnail()
        fileUri = photoFile.path
        //Disha: For next release
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
                //Disha: For next release
                if (!fileUri.equals(""))
                    uploadDoc(fileUri)
            } catch (e: Exception) {
                LogUtils.logD(TAG, e.message!!)
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_FOR_CAMERA -> {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "W9DocTapped")
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