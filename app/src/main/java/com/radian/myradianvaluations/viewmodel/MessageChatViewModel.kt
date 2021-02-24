package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.MessageChatRepository
import com.radian.vendorbridge.Response.MessageChatResponse
import com.radian.vendorbridge.Response.StatusResponse

class MessageChatViewModel : ViewModel() {
    private lateinit var messageRespository: MessageChatRepository
    fun init(context: Context) {
        messageRespository = MessageChatRepository.getInstance(context)
    }
    fun getMessageChat(itemId:Int):MutableLiveData<MessageChatResponse>?{
        return messageRespository.getMessages(itemId)
    }
    fun addMessage(note:String):MutableLiveData<StatusResponse>?{
        return messageRespository.addMessage(note)
    }
}