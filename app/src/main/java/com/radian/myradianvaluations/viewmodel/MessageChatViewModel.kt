package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.Response.MessageChatResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.repository.MessageChatRepository


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