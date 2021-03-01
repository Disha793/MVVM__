package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.DashboardRepository
import com.radian.myradianvaluations.repository.OrdersRepository
import com.radian.vendorbridge.Response.OrderListResponse

class OrdersViewModel :ViewModel(){
    private lateinit var orderRepository: OrdersRepository
    fun init(context: Context) {
        orderRepository = OrdersRepository.getInstance(context)
    }
    fun getOrderList():MutableLiveData<OrderListResponse>?{
        return orderRepository.getOrderList()
    }

}