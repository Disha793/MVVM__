package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.Response.SearchFilterResponse
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.DashboardAbbr
import com.radian.myradianvaluations.utils.Pref
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageListRepository(val context: Context) {
    private  var messageResponse= MutableLiveData<SearchFilterResponse>()

    companion object {
        fun getInstance(context: Context): MessageListRepository {
            return MessageListRepository(context)
        }
    }

    fun getMessageList(): MutableLiveData<SearchFilterResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getMyOrders(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                    CommonUtils.getDeviceUUID(context!!),
                    Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                    Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!,
                    DashboardAbbr.N_MESSAGE
                )
            messageResponse.postValue(call.body())
        }
        return messageResponse
    }
}