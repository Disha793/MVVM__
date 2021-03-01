package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.ManageOrderRepository
import com.radian.vendorbridge.Response.ManageOrderResponse
import com.radian.vendorbridge.Response.StatusResponse

class ManageOrderViewModel : ViewModel() {
    private lateinit var manageOrderRepository: ManageOrderRepository
    fun init(context: Context) {
        manageOrderRepository = ManageOrderRepository.getInstance(context)
    }
    fun getOrderDetail(itemId:Int):MutableLiveData<ManageOrderResponse>?
    {
       return manageOrderRepository.getManageOrder(itemId)
    }
    fun markAsReadRevision(itemId: Int,orderGenId:String):MutableLiveData<StatusResponse>?{
        return manageOrderRepository.markAsReadRevision(itemId,orderGenId)
    }
}