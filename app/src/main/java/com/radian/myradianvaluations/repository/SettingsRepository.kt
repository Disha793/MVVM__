package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.NotiStatusResponse
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsRepository(val context: Context) {
    private var notiStatusResponse = MutableLiveData<NotiStatusResponse>()
    private var statusResponse = MutableLiveData<StatusResponse>()
    private var postParam = HashMap<String, String?>()

    companion object {
        fun getInstance(context: Context): SettingsRepository {
            return SettingsRepository(context)
        }
    }

    fun getNotistatus(): MutableLiveData<NotiStatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
            postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
            postParam.put(
                "MobileUserId",
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
            )
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getNotificatnStatus(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    postParam
                )
            notiStatusResponse.postValue(call.body())
        }
        return notiStatusResponse
    }

    fun saveNotiStatus(): MutableLiveData<StatusResponse>? {
        postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
        postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
        postParam.put(
            "MobileUserId",
            Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
        )
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .saveNotificatnStatus(Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!, postParam)
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }
}