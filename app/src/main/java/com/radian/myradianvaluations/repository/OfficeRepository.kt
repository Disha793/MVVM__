package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OfficeRepository(val context: Context) {
    private var statusResponse = MutableLiveData<StatusResponse>()

    companion object {
        fun getInstance(context: Context): OfficeRepository {
            return OfficeRepository(context)
        }
    }

    fun saveOutOfOfc(
        startDate: String,
        endDate: String,
        note: String
    ): MutableLiveData<StatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .saveoutOfOffice(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                    CommonUtils.getDeviceUUID(context!!),
                    Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                    note,
                    startDate, endDate,
                    "true"
                )
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }
}