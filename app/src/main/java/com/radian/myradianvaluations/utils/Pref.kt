package com.radian.myradianvaluations.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.Response.Assets
import com.radian.myradianvaluations.Response.Categories
import java.lang.reflect.Type

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
    fun setCategoriesArrayList(
        context: Context,
        key: String,
        listCategories: ArrayList<Categories>
    ) {

        try {
            openPref(context)
            val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
            val gson: Gson = Gson()
            val json = gson.toJson(listCategories)
            prefPrivateEditor.putString(key, json)
            prefPrivateEditor.apply()
            Pref.sharedPreferences = null
        } catch (e: Exception) {

        }
    }
    fun getCategoriesArrayList(
        context: Context,
        key: String,
        defaultValue: Any
    ): ArrayList<Categories> {

        openPref(context)
        val gson = Gson()
        val json: String? = sharedPreferences?.getString(key, "")
        val type: Type = object : TypeToken<List<Categories?>?>() {}.type
        val listCategories: ArrayList<Categories> = gson.fromJson(json, type)
        Pref.sharedPreferences = null
        return listCategories
    }
    fun setAssetsArrayList(
        context: Context,
        key: String,
        listAssets: ArrayList<Assets>
    ) {

        try {
            openPref(context)
            val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
            val gson: Gson = Gson()
            val json = gson.toJson(listAssets)
            prefPrivateEditor.putString(key, json)
            prefPrivateEditor.apply()
            Pref.sharedPreferences = null
        } catch (e: Exception) {

        }
    }
    fun getAssetsArrayList(
        context: Context,
        key: String,
        defaultValue: Any
    ): ArrayList<Assets> {

        openPref(context)
        val gson = Gson()
        val json: String? = sharedPreferences?.getString(key, "")
        val type: Type = object : TypeToken<List<Assets?>?>() {}.type
        val listAssets: ArrayList<Assets> = gson.fromJson(json, type)
        Pref.sharedPreferences = null
        return listAssets
    }




}