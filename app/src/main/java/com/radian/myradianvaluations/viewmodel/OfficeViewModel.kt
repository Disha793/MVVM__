package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.OfficeRepository
import com.radian.vendorbridge.Response.StatusResponse

class OfficeViewModel : ViewModel() {
    private lateinit var officeRepository: OfficeRepository
    fun init(context: Context): OfficeRepository {
        officeRepository = OfficeRepository(context)
        return officeRepository
    }
    fun saveOutOfOffice(startDate:String,endDate:String,note:String):MutableLiveData<StatusResponse>?{
       return officeRepository.saveOutOfOfc(startDate,endDate,note)
    }
}