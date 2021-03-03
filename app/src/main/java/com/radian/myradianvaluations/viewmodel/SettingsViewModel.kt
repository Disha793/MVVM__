package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.provider.Settings
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.SettingsRepository
import com.radian.vendorbridge.Response.NotiStatusResponse
import com.radian.vendorbridge.Response.StatusResponse

class SettingsViewModel : ViewModel() {
    private lateinit var settingsRepository: SettingsRepository
    fun init(context: Context): SettingsRepository {
        settingsRepository = SettingsRepository.getInstance(context)
        return settingsRepository
    }
    fun getNotiStatus():MutableLiveData<NotiStatusResponse>?{
      return settingsRepository.getNotistatus()
    }
    fun saveNotiStatus():MutableLiveData<StatusResponse>?{
        return settingsRepository.saveNotiStatus()
    }
}