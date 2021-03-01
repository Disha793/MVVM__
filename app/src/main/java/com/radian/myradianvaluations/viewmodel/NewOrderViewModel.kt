package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.NewOrderRepository
import com.radian.myradianvaluations.repository.OrdersRepository
import com.radian.vendorbridge.Response.NewOrderResponse
import com.radian.vendorbridge.Response.OrderListResponse

class NewOrderViewModel :ViewModel()
{
    private lateinit var newOrderRepository: NewOrderRepository
    fun init(context: Context) {
        newOrderRepository = NewOrderRepository.getInstance(context)
    }
    fun getOrderList(): MutableLiveData<NewOrderResponse>?{
        return newOrderRepository.getNewOrderList()
    }
}