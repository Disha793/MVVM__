package com.radian.myradianvaluations.utils

import android.content.Context
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.analytics.FirebaseAnalytics

object CommonUtils {

    fun getDeviceUUID(mContext: Context): String {
        return Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID)

    }
    fun hideKeybord(view: View, context: Context) {

        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
    fun displayMessage(mView: View, msg: String) {
        Snackbar.make(mView, msg, Snackbar.LENGTH_SHORT).show()
    }
    fun addParamstoFirebaseEvent(
        firebaseAnalytics: FirebaseAnalytics,
        key: String,
        params: Bundle
    ) {
        firebaseAnalytics.logEvent(key, params)
    }
}