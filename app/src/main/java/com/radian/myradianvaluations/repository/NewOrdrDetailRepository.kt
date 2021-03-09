package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.NewOrderDetailResponse
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewOrdrDetailRepository(val context: Context) {
    private var orderResponse = MutableLiveData<NewOrderDetailResponse>()
    private var statusResponse = MutableLiveData<StatusResponse>()
    fun getOrderDetail(itemId: Int): MutableLiveData<NewOrderDetailResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java).newOrderDetail(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!, itemId
            )
            orderResponse.postValue(call.body())
        }
        return orderResponse
    }

    fun confirmOrder(
        postParam: HashMap<String, Any?>,
        itemIdList: ArrayList<Int>,
        unassignedItemId: ArrayList<Int>
    ): MutableLiveData<StatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .confirmOrder(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    postParam,
                    itemIdList,
                    unassignedItemId
                )
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }

    fun rejectOrder(
        postParam: HashMap<String, Any?>,
        itemId: ArrayList<Int>,
        rejectNote: Array<String?>,
        orgId: ArrayList<Int>
    ): MutableLiveData<StatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .rejectOrder(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    postParam,
                    itemId,
                    rejectNote,
                    orgId
                )
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }


    companion object {
        fun getInstance(context: Context): NewOrdrDetailRepository {
            return NewOrdrDetailRepository(context)
        }
    }
}