package com.radian.myradianvaluations.Response

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.LicenceMasterModel
import com.radian.vendorbridge.Response.VendorProfileResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EORepository(val context: Context) {
    private var response = MutableLiveData<VendorProfileResponse>()
    private var licenceMasterresponse = MutableLiveData<LicenceMasterModel>()

    companion object {
        fun getInstance(context: Context): EORepository {
            return EORepository(context)
        }
    }

    fun getVendorProfileDetails(actionType: String): MutableLiveData<VendorProfileResponse> {
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java).getVendorProfileData(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                actionType
            )
            response.postValue(call.body())
        }
        return response
    }
    fun getLicenceMaster():MutableLiveData<LicenceMasterModel>{
        CoroutineScope(Dispatchers.IO).launch {
           val call= RetrofitBase.getClient().create(APIList::class.java).getLicenceMaster(
                Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!,
                Pref.getValue(context!!, Pref.PHONE_NUMBER, "")!!,
                CommonUtils.getDeviceUUID(context!!),
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0)!!,
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0)!!,
                "LICTYPE"
            )
            licenceMasterresponse.postValue(call.body())
        }
        return licenceMasterresponse
    }
}