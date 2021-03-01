package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.NewOrderResponse
import com.radian.vendorbridge.Response.OrderListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewOrderRepository(val context:Context) {
    var orderResponse = MutableLiveData<NewOrderResponse>()

    companion object {
        fun getInstance(context: Context): NewOrderRepository {
            return NewOrderRepository(context)
        }
    }

    fun getNewOrderList(): MutableLiveData<NewOrderResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java).newOrderList(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!
            )
            orderResponse.postValue(call.body())
        }
        return orderResponse
    }
}