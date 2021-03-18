package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class MessageChatResponse{

    @SerializedName("Data")
    @Expose
    var data: Data? = null
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()
    inner class Data {

        @SerializedName("TileOrderNotes")
        @Expose
        var tileOrderNotes: List<TileOrderNote>? = null

    }
    inner class TileOrderNote {

        @SerializedName("CreatedDate")
        @Expose
        var createdDate: String? = null
        @SerializedName("CreatedUserName")
        @Expose
        var createdUserName: String? = null
        @SerializedName("Note")
        @Expose
        var note: String? = null
        @SerializedName("ProductName")
        @Expose
        var productName: String? = null
        @SerializedName("DocumentId")
        @Expose
        var documentId: Int? = null
        @SerializedName("DocumentName")
        @Expose
        var documentName: Any? = null
        @SerializedName("ActionFlag")
        @Expose
        var actionFlag: String? = null
        @SerializedName("UserId")
        @Expose
        var userId: Int? = null
        @SerializedName("SRNo")
        @Expose
        var sRNo: Any? = null
        @SerializedName("RejectReason")
        @Expose
        var rejectReason: Any? = null
        @SerializedName("RejectNote")
        @Expose
        var rejectNote: Any? = null
        @SerializedName("RejectDate")
        @Expose
        var rejectDate: Any? = null

    }
}