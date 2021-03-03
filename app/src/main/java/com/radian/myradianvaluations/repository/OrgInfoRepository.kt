package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.vendorbridge.Response.OrgInfoResponse
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrgInfoRepository (val context: Context){
    companion object {
        fun getInstance(context: Context): OrgInfoRepository {

            return OrgInfoRepository(context)
        }
    }
    fun getOrgInfoAPI():MutableLiveData<OrgInfoResponse>{
        val responseData = MutableLiveData<OrgInfoResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getOrganizationInfo()
            if (call.code() == 200 && call.body() != null) {

                responseData.postValue(call.body() as OrgInfoResponse)

            }

        }
        return responseData

    }
}