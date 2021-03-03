package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.Response.EORepository
import com.radian.vendorbridge.Response.LicenceMasterModel
import com.radian.vendorbridge.Response.VendorProfileResponse

class EOViewModel : ViewModel() {
    private lateinit var eoRepository: EORepository
    fun init(context: Context):EORepository{
        eoRepository= EORepository.getInstance(context)
        return eoRepository
    }
    fun getVendorProfileDetails(actionType:String):MutableLiveData<VendorProfileResponse>{
        return eoRepository.getVendorProfileDetails(actionType)
    }
    fun getLicenceMaster():MutableLiveData<LicenceMasterModel>{
        return eoRepository.getLicenceMaster()
    }
}