package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.OrgInfoRepository
import com.radian.vendorbridge.Response.OrgInfoResponse

class OrgInfoViewModel : ViewModel() {
    lateinit var orgInfoRepository: OrgInfoRepository
    private var orgResponse:MutableLiveData<OrgInfoResponse>?=null
    fun init(context: Context) {
        orgInfoRepository = OrgInfoRepository.getInstance(context)
    }
    fun getInfo():MutableLiveData<OrgInfoResponse>?{
        orgResponse=orgInfoRepository.getOrgInfoAPI()
        return orgResponse
    }
}