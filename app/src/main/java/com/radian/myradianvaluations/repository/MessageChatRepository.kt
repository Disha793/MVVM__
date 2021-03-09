package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.MessageChatResponse
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.android.synthetic.main.fragment_message_chat.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageChatRepository(val context: Context) {
    private  var messageResponse= MutableLiveData<MessageChatResponse>()
    private  var statusResponse= MutableLiveData<StatusResponse>()
    private var postParam = HashMap<String, String?>()

    companion object {
        fun getInstance(context: Context): MessageChatRepository {
            return MessageChatRepository(context)
        }

    }

    fun getMessages(itemId: Int): MutableLiveData<MessageChatResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            postParam.put("PhoneNumber", Pref.getValue(context!!, Pref.PHONE_NUMBER, ""))
            postParam.put("DeviceID", CommonUtils.getDeviceUUID(context!!))
            postParam.put(
                "MobileUserId",
                Pref.getValue(context!!, Pref.MOBILE_USER_ID, 0).toString()
            )
            postParam.put("ItemId", itemId.toString())
            postParam.put(
                "OrganizationIds",
                Pref.getValue(context!!, Pref.ORGANIZATN_ID, 0).toString()
            )
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getMessageChat(Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!, postParam)
            messageResponse.postValue(call.body())
        }
        return messageResponse
    }

    fun addMessage(note: String): MutableLiveData<StatusResponse>? {
        CoroutineScope(Dispatchers.IO).launch {
            postParam.put("Notes", note)
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .addMessageChat(Pref.getValue(context!!, Pref.AUTH_TOKEN, "")!!, postParam)
            statusResponse.postValue(call.body())
        }
        return statusResponse
    }

}