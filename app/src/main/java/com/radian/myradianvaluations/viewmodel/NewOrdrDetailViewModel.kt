package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.NewOrdrDetailRepository
import com.radian.vendorbridge.Response.NewOrderDetailResponse
import com.radian.vendorbridge.Response.StatusResponse

class NewOrdrDetailViewModel : ViewModel() {
    private lateinit var nwOrdrRepository: NewOrdrDetailRepository
    fun init(context: Context): NewOrdrDetailRepository {
        nwOrdrRepository = NewOrdrDetailRepository.getInstance(context)
        return nwOrdrRepository
    }
    fun getOrderDetail(itemId:Int):MutableLiveData<NewOrderDetailResponse>?
    {
       return nwOrdrRepository.getOrderDetail(itemId)
    }
    fun confirmOrder(postParam:HashMap<String,Any?>,itemIdList:ArrayList<Int>,unassignedItemId:ArrayList<Int>):MutableLiveData<StatusResponse>?{
        return nwOrdrRepository.confirmOrder(postParam,itemIdList,unassignedItemId)
    }
    fun rejectOrder(
        postParam:HashMap<String,Any?>,
        itemId:ArrayList<Int>,
        rejectNote: Array<String?>,
        orgId:ArrayList<Int>):MutableLiveData<StatusResponse>?
    {
        return nwOrdrRepository.rejectOrder(postParam,itemId,rejectNote,orgId)
    }
}