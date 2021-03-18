package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.Response.SearchFilterResponse
import com.radian.myradianvaluations.repository.MessageListRepository


class MessageListViewModel : ViewModel() {
    private lateinit var messageRepository: MessageListRepository
    fun init(context: Context): MessageListRepository {
        messageRepository = MessageListRepository.getInstance(context)
        return messageRepository
    }

    fun getMessageList(): MutableLiveData<SearchFilterResponse>? {
        return messageRepository.getMessageList()
    }
}