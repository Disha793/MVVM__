package com.radian.myradianvaluations.utils

import android.content.Context
import android.content.SharedPreferences
import com.radian.myradianvaluations.BuildConfig

object Pref {
    val PREF_FILE = BuildConfig.APPLICATION_ID.replace(".", "_")
    val IS_FIRST_TIME = "Is_First_Time"
    val IS_FIRST_TIME_REWARDS = "Is_First_Time_Rewards"
    val PROFILE_URI = "Profile_uri"
    val PHONE_NUMBER = "Phone_number"
    val DEVICE_STATUS = "Device_status"
    val AUTH_TOKEN = "Auth_token"
    val MOBILE_USER_ID = "Mobile_User_Id"
    val USER_ID = "User_Id"
    val ORGANIZATN_ID = "Organizatn_Id"
    val ACCESS_CODE = "Access_Code"
    val FCM_TOKEN = "Fcm_Token"
    val PROFILE_PIC_STATUS = "Profile_Pic_Status"
    val REWARDS_POINTS="Rewards_Points"
    private var sharedPreferences: SharedPreferences? = null

    fun openPref(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)

    }

    fun getValue(context: Context, key: String, defaultValue: String): String? {
        Pref.openPref(context)
        val result = Pref.sharedPreferences?.getString(key, defaultValue)
        Pref.sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String, value: String) {
        Pref.openPref(context)
        val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
        prefPrivateEditor.putString(key, value)
        prefPrivateEditor.apply()
        Pref.sharedPreferences = null
    }

    fun getValue(context: Context, key: String, defaultValue: Boolean): Boolean {
        Pref.openPref(context)
        val result = Pref.sharedPreferences!!.getBoolean(key, defaultValue)
        Pref.sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String, value: Boolean) {
        Pref.openPref(context)
        val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
        prefPrivateEditor.putBoolean(key, value)
        prefPrivateEditor.apply()
        Pref.sharedPreferences = null
    }

    fun setValue(context: Context, key: String, value: Int) {
        Pref.openPref(context)
        val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
        prefPrivateEditor.putInt(key, value)
        prefPrivateEditor.apply()
        Pref.sharedPreferences = null
    }

    fun getValue(context: Context, key: String, defaultValue: Int): Int? {
        Pref.openPref(context)
        val result = Pref.sharedPreferences?.getInt(key, defaultValue)
        Pref.sharedPreferences = null
        return result
    }



}