package com.radian.myradianvaluations.utils

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Color
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics
import com.radian.myradianvaluations.R
import okhttp3.MediaType
import okhttp3.RequestBody
import java.text.SimpleDateFormat
import java.util.*

object CommonUtils {

    fun getDeviceUUID(mContext: Context): String {
        return Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID)

    }

    fun hideKeybord(view: View, context: Context) {

        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
    internal fun getRealPathFromURI(context: Context, contentUri: Uri): String? {
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
    fun convertDatetoString(date: Date, sdf: SimpleDateFormat): String {
        return sdf.format(date)
    }
    fun convertStringtoDate(date: String, sdf: SimpleDateFormat): Date {
        return sdf.parse(date)
    }
    fun displayMessage(mView: View, msg: String) {
        Snackbar.make(mView, msg, Snackbar.LENGTH_SHORT).show()
    }

    fun getMapIntent(lat: String, long: String): Intent {
        val gmmIntentUri = Uri.parse(
            "geo:$lat,$long?q=$lat,$long"
        )
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        return mapIntent
    }

    internal fun checkCallPermission(context: Context): Boolean {
        val result = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CALL_PHONE
        )
        return result == PackageManager.PERMISSION_GRANTED

    }

    fun displayMessageAction(

        mView: View,
        msg: String,
        actionText: String,
        onClickListener: View.OnClickListener
    ) {
        val snackbar = Snackbar.make(mView, msg, Snackbar.LENGTH_INDEFINITE)
        val snackView = snackbar.view
        snackView.setBackgroundColor(Color.BLACK)
        snackbar.setActionTextColor(Color.WHITE)
        var textView: TextView = snackView.findViewById<TextView>(R.id.snackbar_text)
        textView.setTextColor(Color.WHITE)
        snackbar.setAction(actionText, onClickListener)
        snackbar.show()
    }

    fun allPermissionsGranted(context: Context): Boolean {
        val requiredPermissions =
            arrayOf("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR")
        for (permission in requiredPermissions) {
            if (ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return false
            }
        }
        return true
    }

    fun getAppVersion(context: Context): String? {
        try {
            var pInfo: PackageInfo =
                context.getPackageManager().getPackageInfo(context.getPackageName(), 0)
            val version = pInfo.versionName
            return version
        } catch (e: PackageManager.NameNotFoundException) {
            LogUtils.logE("PackageInfo", e)
        }
        return null
    }

    fun requestBody(name: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), name)
    }

    internal fun formatNumber(phone: String): String {
        return String.format(
            "(%s)%s-%s",
            phone.substring(0, 3),
            phone.substring(3, 6),
            phone.substring(6, 10)
        )
    }

    internal fun checkPermission(context: Context): Boolean {
        val result = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        val result1 = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
        val result2 = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)

        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED && result2 == PackageManager.PERMISSION_GRANTED
    }

    fun addParamstoFirebaseEvent(
        firebaseAnalytics: FirebaseAnalytics,
        key: String,
        params: Bundle
    ) {
        firebaseAnalytics.logEvent(key, params)
    }

    fun showOkDialog(
        context: Context,
        message: String,
        onClickListener: DialogInterface.OnClickListener,
        okText: String

    ) {
        AlertDialog.Builder(context).setMessage(message).setCancelable(false)
            .setPositiveButton(
                okText
            ) { p0, p1 -> onClickListener.onClick(p0, p1) }

            .show()


    }

    fun getPhoneNumber(phoneNumber: String): String {
        var formattedPhoneNumber = phoneNumber
        for (i in 0..phoneNumber.length - 1) {
            if (phoneNumber.get(i).equals('(') || phoneNumber.get(i).equals(')') || phoneNumber.get(
                    i
                ).equals('-')
            ) {
                formattedPhoneNumber = formattedPhoneNumber.replace(phoneNumber.get(i), ' ', false)
            }
        }
        return formattedPhoneNumber.replace(" ", "")
    }

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true
        return isConnected
    }

    fun showDialog(
        context: Context,
        message: String,
        onClickListener: DialogInterface.OnClickListener,
        onCancelListener: DialogInterface.OnCancelListener,
        okText: String,
        cancelText: String
    ) {
        AlertDialog.Builder(context).setMessage(message).setCancelable(false)

            .setNegativeButton(
                okText
            ) { p0, p1 -> onClickListener.onClick(p0, p1) }
            .setPositiveButton(
                cancelText
            ) { p0, p1 -> onCancelListener.onCancel(p0) }
            .show()


    }
}