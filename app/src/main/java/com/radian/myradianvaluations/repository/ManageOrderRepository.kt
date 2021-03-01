package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.ManageOrderResponse
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.net.ssl.SSLEngineResult

class ManageOrderRepository(val context: Context) {
    private var manageResponse = MutableLiveData<ManageOrderResponse>()
    private var statusResponse = MutableLiveData<StatusResponse>()

    companion object {
        fun getInstance(context: Context): ManageOrderRepository {
            return ManageOrderRepository(context)
        }
    }

    fun getManageOrder(itemId: Int): MutableLiveData<ManageOrderResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java).manageOrder(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!, itemId
            )
            manageResponse.postValue(call.body())
        }
        return manageResponse

    }

    fun markAsReadRevision(itemId: Int, orderGenId: String): MutableLiveData<StatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java).readBulkNotificatn(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!,
                "R",
                itemId!!,
                orderGenId
            )
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }
}