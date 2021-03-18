package com.radian.myradianvaluations.view.fragment

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.provider.Settings
import android.text.TextUtils
import android.view.*
import android.widget.ImageView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.face.FirebaseVisionFaceContour
import com.google.firebase.ml.vision.face.FirebaseVisionFaceDetectorOptions
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.extensions.observeOnce
import com.radian.myradianvaluations.extensions.snack
import com.radian.myradianvaluations.extensions.toastShort
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.myradianvaluations.view.activity.BottomNavigationActivity
import com.radian.myradianvaluations.view.activity.FaceDetectionActivity
import com.radian.myradianvaluations.view.activity.PasscodeActivity
import com.radian.myradianvaluations.viewmodel.ProfileViewModel
import com.radian.myradianvaluations.viewmodel.ProfileViewModelFactory
import com.radian.vendorbridge.Response.ProfileResponse
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.dialog_add_event.view.*
import kotlinx.android.synthetic.main.dialog_profile_pic.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.layout_toolbar.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.ByteArrayOutputStream
import java.io.File
import java.util.*

class ProfileFragment() : Fragment(), DialogInterface.OnClickListener, View.OnClickListener {

    private var TAG = javaClass.name
    internal lateinit var view: View
    internal lateinit var photoURI: Uri
    lateinit var photoFile: File
    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private val firebaseParams = Bundle()
    lateinit internal var dialogView: View
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var factory: ProfileViewModelFactory
    private var fileUriToUpload: String? = null
    internal lateinit var context: Context
    private val REQUEST_FOR_CAMERA = 101
    private val REQUEST_FOR_GALLERY = 102
    private val REQUEST_PERMISSION_ACESS = 103
    private val REQ_FACE_DETECTION = 104
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_profile, container, false)
        this.context = getContext()!!
        initViewModel()
        view.img_camera.setOnClickListener(this)
        view.imgBack.setOnClickListener(this)
        //Disha: For next release
//        getMyProfile()
        observeProfileData()
        CommonUtils.hideKeybord((context as BottomNavigationActivity).window.decorView.rootView, context)
        return view
    }

    private fun initViewModel() {
        factory = ProfileViewModelFactory(context!!)
        profileViewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
    }

    private fun observeProfileData() {
        profileViewModel.saveProfileResponse.observeOnce(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it.status.equals("ok", true)) {
                getMyProfile()

            } else if (it.status.equals("UNAUTHORIZED", true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)
                var intent = Intent(context, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })

        profileViewModel.getProfileResponse.observeOnce(viewLifecycleOwner, androidx.lifecycle.Observer {
            if (it.status.equals("ok", true)) {
                setProfile(it.data.get(0))
            } else if (it.status.equals("UNAUTHORIZED", true)) {
                context!!.toastShort(it.errorInfo.get(0).errorMessage)

                var intent = Intent(context, PasscodeActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })
        profileViewModel.uploadImageResponse.observeOnce(viewLifecycleOwner, androidx.lifecycle.Observer {
            LogUtils.logD(TAG, "" + it)
            it.data?.let {
                loadProfileImage(it)
            }
        })
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnSave -> {
                //Disha: For next release
//                saveMyProfile()
            }
            R.id.imgBack -> {
                (context as BottomNavigationActivity).supportFragmentManager.popBackStack()
            }
            R.id.img_camera -> {
                if (CommonUtils.checkPermission(context)) {
                    showProfileInfoDialog()
                } else {
                    requestPermission()
                }
            }
        }
    }

    override fun onClick(p0: DialogInterface?, position: Int) {
        when (position) {
            0 -> openCamera()
            1 -> openGallery()
            2 -> p0!!.dismiss()
        }
    }

    private fun showProfileInfoDialog() {
        val infodialogView = LayoutInflater.from(context!!).inflate(R.layout.dialog_add_event, null)
        val builder =
                AlertDialog.Builder(context!!, R.style.FullScreenDialogTheme)

        builder.setView(infodialogView)
        val dialog = Dialog(context!!, R.style.FullScreenDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(infodialogView)
        val lp = dialog.getWindow()!!.getAttributes()
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        dialog.getWindow()!!.setAttributes(lp)
        dialog.show()
        infodialogView.txt_date.visibility = View.GONE

        infodialogView.txt_address.visibility = View.GONE
        infodialogView.btnAddEvent.setText(getString(R.string.lbl_next_step))
        infodialogView.txtDialogSubTitle.visibility = View.VISIBLE
        infodialogView.txtDialogSubTitle.setText(getString(R.string.lbl_dilg_header))
        infodialogView.txtDialogTitle.setText(getString(R.string.lbl_add_photo))
        infodialogView.txtDialogTitle.setTypeface(null, Typeface.BOLD)
        infodialogView.txt_product.setText(getString(R.string.lbl_photo_info))
        val params = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 30, 0, 0)
        infodialogView.txtDialogSubTitle.setLayoutParams(params)
        infodialogView.img_close.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog.dismiss()

            }

        })
        infodialogView.btnAddEvent.setOnClickListener {
            dialog.dismiss()
            openDialog()
        }
    }

    private fun loadProfileImage(url: String?) {
        Handler(Looper.getMainLooper()).post(Runnable {
            url?.let {
                Pref.setValue(context, Pref.PROFILE_URI, it)
            }
            if (!TextUtils.isEmpty(Pref.getValue(context, Pref.PROFILE_URI, ""))) {

                Picasso.with(context)
                        .load(BuildConfig.HOST + Pref.getValue(context, Pref.PROFILE_URI, ""))
                        .placeholder(R.drawable.profile_placeholder)
                        .into(view.imgProfile)
            }
        })
    }

    private fun detectFace(
            myBitmap: Bitmap,
            imgProfile: ImageView,
            faceDetectionCameraImageView: ImageView,
            dialogView: View
    ) {
        val stream = ByteArrayOutputStream()
        val firebaseVisionImage = FirebaseVisionImage.fromBitmap(myBitmap)
        val options = FirebaseVisionFaceDetectorOptions.Builder()
                .setContourMode(FirebaseVisionFaceDetectorOptions.ALL_CONTOURS)
                .build()
        val faceDetector = FirebaseVision.getInstance().getVisionFaceDetector(options)

        faceDetector.detectInImage(firebaseVisionImage)
                .addOnSuccessListener {
                    faceDetectionCameraImageView.setImageBitmap(null)
                    val bitmap = (imgProfile.drawable as BitmapDrawable).bitmap.copy(
                            Bitmap.Config.ARGB_8888, true
                    )
                    LogUtils.logD("MYBitmapWidth!!!!!", "" + myBitmap.width)
                    LogUtils.logD("MYBitmapHeight!!!!!", "" + myBitmap.height)
                    val canvas = Canvas(bitmap)
                    LogUtils.logD("BitmapWidth!!!!!", "" + bitmap.width)
                    LogUtils.logD("BitmapHeight!!!!!", "" + bitmap.height)
                    val dotPaint = Paint()
                    //In small image dots are so large so this function used to calculate
                    val dotStroke = (myBitmap.height * 4F) / 860.toFloat()

                    LogUtils.logD("DotStroke!!!", "" + dotStroke)
                    dotPaint.color = Color.RED
                    dotPaint.style = Paint.Style.FILL
                    //dotPaint.strokeWidth = 4F
                    dotPaint.strokeWidth = dotStroke
                    dotPaint.strokeCap = Paint.Cap.ROUND
                    val linePaint = Paint()
                    linePaint.color = Color.GREEN
                    linePaint.style = Paint.Style.STROKE
                    linePaint.strokeWidth = dotStroke / 2

                    for (face in it) {

                        val faceContours = face.getContour(FirebaseVisionFaceContour.FACE).points
                        for ((i, contour) in faceContours.withIndex()) {
                            if (i != faceContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        faceContours[i + 1].x,
                                        faceContours[i + 1].y,
                                        linePaint
                                )
                            else
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        faceContours[0].x,
                                        faceContours[0].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val leftEyebrowTopContours =
                                face.getContour(FirebaseVisionFaceContour.LEFT_EYEBROW_TOP).points
                        for ((i, contour) in leftEyebrowTopContours.withIndex()) {
                            if (i != leftEyebrowTopContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        leftEyebrowTopContours[i + 1].x,
                                        leftEyebrowTopContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val leftEyebrowBottomContours =
                                face.getContour(FirebaseVisionFaceContour.LEFT_EYEBROW_BOTTOM).points
                        for ((i, contour) in leftEyebrowBottomContours.withIndex()) {
                            if (i != leftEyebrowBottomContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        leftEyebrowBottomContours[i + 1].x,
                                        leftEyebrowBottomContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val rightEyebrowTopContours =
                                face.getContour(FirebaseVisionFaceContour.RIGHT_EYEBROW_TOP).points
                        for ((i, contour) in rightEyebrowTopContours.withIndex()) {
                            if (i != rightEyebrowTopContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        rightEyebrowTopContours[i + 1].x,
                                        rightEyebrowTopContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val rightEyebrowBottomContours =
                                face.getContour(FirebaseVisionFaceContour.RIGHT_EYEBROW_BOTTOM).points
                        for ((i, contour) in rightEyebrowBottomContours.withIndex()) {
                            if (i != rightEyebrowBottomContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        rightEyebrowBottomContours[i + 1].x,
                                        rightEyebrowBottomContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)

                        }

                        val leftEyeContours = face.getContour(FirebaseVisionFaceContour.LEFT_EYE).points
                        for ((i, contour) in leftEyeContours.withIndex()) {
                            if (i != leftEyeContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        leftEyeContours[i + 1].x,
                                        leftEyeContours[i + 1].y,
                                        linePaint
                                )
                            else
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        leftEyeContours[0].x,
                                        leftEyeContours[0].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val rightEyeContours =
                                face.getContour(FirebaseVisionFaceContour.RIGHT_EYE).points
                        for ((i, contour) in rightEyeContours.withIndex()) {
                            if (i != rightEyeContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        rightEyeContours[i + 1].x,
                                        rightEyeContours[i + 1].y,
                                        linePaint
                                )
                            else
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        rightEyeContours[0].x,
                                        rightEyeContours[0].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val upperLipTopContours =
                                face.getContour(FirebaseVisionFaceContour.UPPER_LIP_TOP).points
                        for ((i, contour) in upperLipTopContours.withIndex()) {
                            if (i != upperLipTopContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        upperLipTopContours[i + 1].x,
                                        upperLipTopContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val upperLipBottomContours =
                                face.getContour(FirebaseVisionFaceContour.UPPER_LIP_BOTTOM).points
                        for ((i, contour) in upperLipBottomContours.withIndex()) {
                            if (i != upperLipBottomContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        upperLipBottomContours[i + 1].x,
                                        upperLipBottomContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val lowerLipTopContours =
                                face.getContour(FirebaseVisionFaceContour.LOWER_LIP_TOP).points
                        for ((i, contour) in lowerLipTopContours.withIndex()) {
                            if (i != lowerLipTopContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        lowerLipTopContours[i + 1].x,
                                        lowerLipTopContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val lowerLipBottomContours =
                                face.getContour(FirebaseVisionFaceContour.LOWER_LIP_BOTTOM).points
                        for ((i, contour) in lowerLipBottomContours.withIndex()) {
                            if (i != lowerLipBottomContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        lowerLipBottomContours[i + 1].x,
                                        lowerLipBottomContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val noseBridgeContours =
                                face.getContour(FirebaseVisionFaceContour.NOSE_BRIDGE).points
                        for ((i, contour) in noseBridgeContours.withIndex()) {
                            if (i != noseBridgeContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        noseBridgeContours[i + 1].x,
                                        noseBridgeContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }

                        val noseBottomContours =
                                face.getContour(FirebaseVisionFaceContour.NOSE_BOTTOM).points
                        for ((i, contour) in noseBottomContours.withIndex()) {
                            if (i != noseBottomContours.lastIndex)
                                canvas.drawLine(
                                        contour.x,
                                        contour.y,
                                        noseBottomContours[i + 1].x,
                                        noseBottomContours[i + 1].y,
                                        linePaint
                                )
                            canvas.drawCircle(contour.x, contour.y, dotStroke, dotPaint)
                        }


                        imgProfile.setImageBitmap(bitmap)
                        dialogView.btnProceed.isEnabled = true
                        dialogView.btnProceed.setBackgroundColor(
                                ContextCompat.getColor(
                                        context!!,
                                        R.color.colorPrimary
                                )
                        )
                    }
                    if (it.isEmpty()) {
                        view.snack(resources.getString(R.string.face_not_detect)) {}
                    }
                }
                .addOnFailureListener {

                    faceDetectionCameraImageView.setImageBitmap(null)
                }
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
        //To change body of created functions use File | Settings | File Templates.
        val builder = AlertDialog.Builder(context)

        var options = Array<CharSequence>(3, { "" })
        options[0] = resources.getString(R.string.camera)
        options[1] = resources.getString(R.string.gallery)
        options[2] = resources.getString(R.string.cancel)
        builder.setTitle(resources.getString(R.string.select_option))
        builder.setItems(options, this)
        builder.show()
    }

    private fun openCamera() {
        val intent = Intent(context, FaceDetectionActivity::class.java)
        startActivityForResult(intent, REQ_FACE_DETECTION)
    }

    private fun openGallery() {
        val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, REQUEST_FOR_GALLERY)
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
                                        context,
                                        android.R.color.white
                                )
                        )
                        snackBar.setAction("SETTINGS") {
                            val intent =
                                    Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            val uri =
                                    Uri.fromParts("package", context.getPackageName(), null)
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

                } else {
                    showProfileInfoDialog()
                    break
                }
                i++
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        firebaseAnalytics = FirebaseAnalytics.getInstance(context!!)
        firebaseParams.clear()
        firebaseParams.putString(Const.screenLaunched, "Profile")
        CommonUtils.addParamstoFirebaseEvent(
                firebaseAnalytics,
                Const.screenLaunched,
                firebaseParams
        )
        view.btnSave.setOnClickListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_FOR_CAMERA -> {
                    firebaseParams.clear()
                    firebaseParams.putString(Const.methodInvoked, "cameraIconTapped")
                    CommonUtils.addParamstoFirebaseEvent(
                            firebaseAnalytics,
                            Const.methodInvoked,
                            firebaseParams
                    )
                    setCameraImage()
                }

                REQUEST_FOR_GALLERY ->
                    setGalleryImage(data)
                REQ_FACE_DETECTION -> {
                    data?.getStringExtra("FilePath")?.let {
                        fileUriToUpload = it
                        //Disha: For next release
//                        uploadProfileImage(it)
                    }
                }
            }

        }

    }

    private fun setCameraImage() {
        fileUriToUpload = photoFile.path
        uploadProfileImage(photoFile.path)

    }

    private fun setGalleryImage(data: Intent?) {
        if (data != null) {
            val contentURI = data.data!!
            try {
                fileUriToUpload = getRealPathFromURI(context, contentURI)

                val bitmap =
                        MediaStore.Images.Media.getBitmap(context.getContentResolver(), contentURI)
                showImageIndialog(bitmap)
            } catch (e: Exception) {

                LogUtils.logD(TAG, e.message!!)
            }

        }
    }

    private fun showImageIndialog(bitmap: Bitmap) {
        dialogView = LayoutInflater.from(context!!).inflate(R.layout.dialog_profile_pic, null)
        val builder =
                AlertDialog.Builder(context!!, R.style.FullScreenDialogTheme)
        dialogView.btnProceed.setBackgroundColor(
                ContextCompat.getColor(
                        context!!,
                        R.color.light_grey
                )
        )
        dialogView.btnProceed.isEnabled = false
        builder.setView(dialogView)
        val dialog = Dialog(context!!, R.style.FullScreenDialogTheme)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogView)
        val lp = dialog.getWindow()!!.getAttributes()
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.MATCH_PARENT
        dialog.getWindow()!!.setAttributes(lp)
        dialog.show()
        dialogView.img_profile.setImageBitmap(bitmap)
        detectFace(
                bitmap,
                dialogView.img_profile,
                dialogView.face_detection_camera_image_view,
                dialogView
        )
        dialogView.btnProceed.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                dialog.dismiss()
                uploadProfileImage(fileUriToUpload!!)
            }
        })
        dialogView.btnClose.setOnClickListener(View.OnClickListener {
            dialog.cancel()
        })
    }

    private fun uploadProfileImage(fileUri: String) {
        val file = File(fileUri)
        val requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file)

        val profileImgBody =
                MultipartBody.Part.createFormData("file", file.name, requestBody)
        val filename = CommonUtils.requestBody(file.name)
        val postField = HashMap<String, RequestBody>()
        postField.put("PhoneNumber", CommonUtils.requestBody(Pref.getValue(context, Pref.PHONE_NUMBER, "")!!))
        postField.put("DeviceID", CommonUtils.requestBody(CommonUtils.getDeviceUUID(context!!)))
        postField.put("CATEGORY", CommonUtils.requestBody("PROFILEPICUPDATE"))
        postField.put("MobileUserId", CommonUtils.requestBody(Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()))
        postField.put("DocumentType", CommonUtils.requestBody("Profile Picture"))
        postField.put("FileName ", CommonUtils.requestBody(file.name))

        profileViewModel.uploadImage(profileImgBody, filename, postField)


    }


    private fun getMyProfile() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context))
        postParam.put("MobileUserId", Pref.getValue(context, Pref.MOBILE_USER_ID, 0))
        profileViewModel.getProfileAPI(postParam)
    }

    private fun saveMyProfile() {
        val postParam = HashMap<String, Any?>()
        postParam.put("PhoneNumber", Pref.getValue(context, Pref.PHONE_NUMBER, ""))
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context))
        postParam.put("MobileUserId", Pref.getValue(context, Pref.MOBILE_USER_ID, 0))
        postParam.put("LicensePlate", view.edtlicence.text.toString())
        postParam.put("CarMake", view.edtmake.text.toString())
        profileViewModel.saveProfileAPI(postParam)
    }

    private fun setProfile(data: ProfileResponse.Object) {
        view.edtServiceTyp.setText(data.vendorTypeDesc)
        view.edtVendrName.setText(data.name)
        view.edtAddress.setText(data.vendorAddress)
        if (data.eOFlag.equals("y", true)) {
            view.edtEoCoverage.setText("Yes")
        } else {
            view.edtEoCoverage.setText("No")
        }
        view.edtEoAmount.setText(data.eoAmount.trim())
        view.edtExpiryDte.setText(data.eoExpiryDate)
        view.txtEmail.setText(data.email)
        view.txtName.setText(data.firstName + " " + data.lastName)
        view.txtPhoneNumber.setText(CommonUtils.formatNumber(data.primaryPhone))
        view.edtlicence.setText(data.licaencePlate)
        view.edtmake.setText(data.carMake)

        if (data.profilePicStatus.equals("Y", true)) {
            loadProfileImage(data.profileImageUrl)
        }

    }

    private fun getRealPathFromURI(context: Context, contentUri: Uri): String? {
        var cursor: Cursor? = null
        var path: String?
        try {
            var proj: Array<out String?> = arrayOf<String>(MediaStore.Images.Media.DATA)
            cursor = context.getContentResolver().query(contentUri, proj, null, null, null)
            if (cursor == null) { // Source is Dropbox or other similar local file path
                path = contentUri.getPath()
            } else {
                var columnIndex = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                cursor?.moveToFirst()
                path = cursor?.getString(columnIndex!!)
            }
            return path
        } finally {
            if (cursor != null) {
                cursor.close()
            }
        }
    }

}
