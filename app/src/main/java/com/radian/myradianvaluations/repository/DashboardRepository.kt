package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.DashboardResponseNew
import com.radian.vendorbridge.Response.StatusResponse
import com.radian.vendorbridge.Response.WhatsNewResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardRepository(var context: Context) {
    var dashboardResponse = MutableLiveData<DashboardResponseNew>()
    var whatsNewResponse = MutableLiveData<WhatsNewResponse>()
    var statusResponse = MutableLiveData<StatusResponse>()
    private lateinit var rejectnoteList: Array<String?>
    private val postParam = HashMap<String, Any?>()
    private val itemId = ArrayList<Int>()
    companion object {
        fun getInstance(context: Context): DashboardRepository {
            return DashboardRepository(context)
        }
    }

    fun getDashboardData(): MutableLiveData<DashboardResponseNew> {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getDashboardData(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                    CommonUtils.getDeviceUUID(context!!),
                    Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                    "",
                    Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!,
                    CommonUtils.getAppVersion(context!!),
                    null
                )
            dashboardResponse.postValue(call.body() as DashboardResponseNew)

        }
        return dashboardResponse
    }
    fun whatsNewAPI():MutableLiveData<WhatsNewResponse>{
        CoroutineScope(Dispatchers.IO).launch {
            val call =   RetrofitBase.getClient().create(APIList::class.java)
                .whatsNew(
                    Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                    Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                    CommonUtils.getDeviceUUID(context!!),
                    Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!
                )
            whatsNewResponse.postValue(call.body() as WhatsNewResponse)

        }
        return whatsNewResponse
    }
fun rejectOrde(item:Int):MutableLiveData<StatusResponse>{

    return statusResponse

}
}