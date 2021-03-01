package com.radian.myradianvaluations.interfaces


import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.PictureResult
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.myradianvaluations.view.FaceDetectionActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class CaptureImageListener(
    var photofile: File,
    var faceDetectionActivity: FaceDetectionActivity
) : CameraListener() {
    var classTag = this::class.java.canonicalName!!
    override fun onPictureTaken(result: PictureResult) {
        super.onPictureTaken(result)
        try {
            val fos = FileOutputStream(photofile)
            fos.write(result.data)
            fos.close()
            faceDetectionActivity.uploadProfile()
        } catch (e: FileNotFoundException) {
            LogUtils.logE(classTag, e)
        } catch (e: IOException) {
            LogUtils.logE(classTag, e)
        }

    }
}