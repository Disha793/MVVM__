package com.radian.myradianvaluations.view.activity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.Categories
import com.radian.myradianvaluations.Response.UploadedPhotos
import com.radian.myradianvaluations.constants.Const
import com.radian.myradianvaluations.databinding.ActivityCameraBinding
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.utils.Pref
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCameraBinding
    private lateinit var mContext: Context
    private var imageCapture: ImageCapture? = null
    private lateinit var outputDirectory: File
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var listCategories: ArrayList<Categories>
    private lateinit var listUploadedPhotos: ArrayList<UploadedPhotos>
    private var currentListPosition = 0
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_camera)
        mContext = this

        init()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun init() {

        currentListPosition = intent.getIntExtra(Const.INTENT_POSITION_KEY, 0)

        listCategories = Pref.getCategoriesArrayList(this, Const.CATEGORIES_SHARED_PREF_KEY, "")

        binding.tvTitle.text = listCategories[currentListPosition].name

        binding.ivCapture.setOnClickListener(this)
        binding.ivClose.setOnClickListener(this)

        outputDirectory = getOutputDirectory()
        cameraExecutor = Executors.newSingleThreadExecutor()

        Dexter.withContext(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if (report.areAllPermissionsGranted()) {
                        startCamera()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {

                }
            }).check()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun getOutputDirectory(): File {
        val mediaDir = externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else filesDir
    }

    private fun takePhoto(photoCategory: String) {

        val imageCapture = imageCapture ?: return

        // Create time-stamped output file to hold the image
        val photoFile = File(
            outputDirectory,
            SimpleDateFormat(
                "yyyy-MM-dd", Locale.US
            ).format(System.currentTimeMillis()) + ".jpg"
        )

        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                   LogUtils.logE("TAG", "Photo capture failed: ${exc.message}", exc)
                    Toast.makeText(baseContext, "Photo capture failed", Toast.LENGTH_SHORT).show()
                }

                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)
                    val msg = "Photo capture succeeded: $savedUri"

                    listCategories[currentListPosition].imageUri = savedUri.toString()
                    Pref.setCategoriesArrayList(
                        this@CameraActivity,
                        Const.CATEGORIES_SHARED_PREF_KEY,
                        listCategories
                    )
                    var intent = Intent(this@CameraActivity, StepsActivity::class.java)
                    intent.putExtra(Const.INTENT_CAMERA_KEY, true)
                    startActivity(intent)
                    LogUtils.logD("TAG", msg)
                }
            })
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener(Runnable {
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.pvCamera.createSurfaceProvider())
                }

            imageCapture = ImageCapture.Builder()
                .build()

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageCapture
                )

            } catch (exc: Exception) {
                LogUtils.logE("TAG", "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }


    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ivCapture -> {
                takePhoto(listCategories[currentListPosition].name)
            }
            R.id.ivClose -> {
                var intent = Intent(this@CameraActivity, StepsActivity::class.java)
                intent.putExtra(Const.INTENT_CAMERA_KEY, true)
                startActivity(intent)
            }
        }
    }
}