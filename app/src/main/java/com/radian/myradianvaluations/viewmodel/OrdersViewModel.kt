package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.Response.OrderListResponse
import com.radian.myradianvaluations.repository.OrdersRepository


class OrdersViewModel :ViewModel(){
    private lateinit var orderRepository: OrdersRepository
    fun init(context: Context) {
        orderRepository = OrdersRepository.getInstance(context)
    }
    fun getOrderList():MutableLiveData<OrderListResponse>?{
        return orderRepository.getOrderList()
    }

}