package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.Response.OrderDocResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DocumentListRepository(val context: Context) {
    private var postParam = HashMap<String, Any?>()
    private var docResponse = MutableLiveData<OrderDocResponse>()
    private var statusResponse = MutableLiveData<StatusResponse>()

    companion object {
        fun getInstance(context: Context): DocumentListRepository {
            return DocumentListRepository(context)
        }
    }

    fun getDocuments(itemId: Int): MutableLiveData<OrderDocResponse> {
        CoroutineScope(Dispatchers.IO).launch {
            postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
            postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
            postParam.put(
                "MobileUserId",
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
            )
            postParam.put("ItemId", itemId.toString())
            postParam.put(
                "OrganizationIds",
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString()
            )
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getOrderDocument(Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!, postParam)
            docResponse.postValue(call.body())
        }
        return docResponse
    }

    fun markAsRead(postParam: HashMap<String, Any?>): MutableLiveData<StatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .deleteDocument(Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!, postParam)
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }
}