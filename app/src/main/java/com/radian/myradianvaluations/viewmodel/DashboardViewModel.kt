package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.DashboardRepository
import com.radian.myradianvaluations.repository.LoginRepository
import com.radian.vendorbridge.Response.DashboardResponseNew
import com.radian.vendorbridge.Response.StatusResponse
import com.radian.vendorbridge.Response.WhatsNewResponse

class DashboardViewModel : ViewModel() {
    private lateinit var dashboardRepository: DashboardRepository
    fun init(context: Context) {
        dashboardRepository = DashboardRepository.getInstance(context)
    }

    fun getDashboardData(): MutableLiveData<DashboardResponseNew> {
        return dashboardRepository.getDashboardData()
    }

    fun getWhatsNewAPI(): MutableLiveData<WhatsNewResponse> {
        return dashboardRepository.whatsNewAPI()
    }

}