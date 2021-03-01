package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.DashboardResponseNew
import com.radian.vendorbridge.Response.OrderListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrdersRepository(val context: Context) {
    var orderResponse = MutableLiveData<OrderListResponse>()

    companion object {
        fun getInstance(context: Context): OrdersRepository {
            return OrdersRepository(context)
        }
    }

    fun getOrderList(): MutableLiveData<OrderListResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java).orderList(
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