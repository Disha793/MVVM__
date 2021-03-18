package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.Response.OrderDocResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.repository.DocumentListRepository


class DocumentListViewModel : ViewModel() {
    private lateinit var documentListRepository: DocumentListRepository
    fun init(context: Context): DocumentListRepository {
        documentListRepository = DocumentListRepository.getInstance(context)
        return documentListRepository
    }

    fun getDocuments(itemId: Int): MutableLiveData<OrderDocResponse>? {
        return documentListRepository.getDocuments(itemId)
    }
   fun markAsRead(postParam:HashMap<String,Any?>):MutableLiveData<StatusResponse>?{
       return documentListRepository.markAsRead(postParam)
   }
}