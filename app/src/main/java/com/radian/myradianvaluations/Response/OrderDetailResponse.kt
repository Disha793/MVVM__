package com.radian.myradianvaluations.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.properties.Delegates


class OrderDetailResponse() : Parcelable {

    @SerializedName("Data")
    @Expose
    var data: Data? = null
    @SerializedName("Status")
    @Expose
    var status: String? = null
    @SerializedName("ErrorInfo")
    @Expose
    var errorInfo = ArrayList<ErrorInfo>()
    @SerializedName("Message")
    @Expose
    var message: Any? = null

    constructor(parcel: Parcel) : this() {
        status = parcel.readString()
        this.data = parcel.readParcelable(Data::class.java.classLoader)!!
    }

    class Data() : Parcelable {

        @SerializedName("Orderdetails")
        @Expose
        var orderdetails: Orderdetail? = null

        constructor(parcel: Parcel) : this() {
            this.orderdetails =
                parcel.readParcelable(Orderdetail::class.java.classLoader)

        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeValue(this.orderdetails)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Data> {
            override fun createFromParcel(parcel: Parcel): Data {
                return Data(parcel)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }

    }


    class Orderdetail() : Parcelable {

        @SerializedName("IsAllowInspection")
        @Expose
        var isAllowInspection: String? = null
        @SerializedName("AppointmentDate")
        @Expose
        var appointmentDate: String? = null
        @SerializedName("OrderGenId")
        @Expose
        var orderGenId: String? = null
        @SerializedName("ItemId")
        @Expose
        var itemId: Int? = null
        @SerializedName("UserId")
        @Expose
        var userId: Int? = null
        @SerializedName("ItemNoteId")
        @Expose
        var itemNoteId: Int? = null
        @SerializedName("OrgId")
        @Expose
        var orgId: Int? = null
        @SerializedName("DiplayBorrowerInfo")
        @Expose
        var diplayBorrowerInfo: String? = null
        @SerializedName("DisplayAddressInfo")
        @Expose
        var displayAddressInfo: String? = null
        @SerializedName("DisplayLoanInfo")
        @Expose
        var displayLoanInfo: String? = null
        @SerializedName("FHA")
        @Expose
        var fHA: Any? = null
        @SerializedName("Product")
        @Expose
        var product: String? = null
        @SerializedName("AppointmentTime")
        @Expose
        var appointmentTime: String? = null
        @SerializedName("Message")
        @Expose
        var message: String? = null
        @SerializedName("DueDate")
        @Expose
        var dueDate: String? = null
        @SerializedName("Status")
        @Expose
        var status: String? = null
        @SerializedName("DocumentId")
        @Expose
        var documentId: Any? = null
        @SerializedName("DocumentName")
        @Expose
        var documentName: Any? = null
        @SerializedName("TileAbbr")
        @Expose
        var tileAbbr: String? = null
        @SerializedName("ClientName")
        @Expose
        var clientName: String? = null
        @SerializedName("ClientPhone")
        @Expose
        var clientPhone: String? = null
        @SerializedName("ClientEmail")
        @Expose
        var clientEmail: String? = null
        @SerializedName("DocumentURL")
        @Expose
        var documentURL: Any? = null
        @SerializedName("ServiceRequestType")
        @Expose
        var serviceRequestType: Int? = null
        @SerializedName("PaymentRequired")
        @Expose
        var paymentRequired: String? = null
        @SerializedName("PaymentAmount")
        @Expose
        var paymentAmount: Int? = null
        @SerializedName("CondAcceptance")
        @Expose
        var condAcceptance: String? = null
        @SerializedName("ItemSrNo")
        @Expose
        var itemSrNo: Int? = null
        @SerializedName("IsNotify")
        @Expose
        var isNotify = false
        @SerializedName("IsComplete")
        @Expose
        var isComplete = false
        @SerializedName("Lat")
        @Expose
        var lat: String? = null
        @SerializedName("Lng")
        @Expose
        var lng: String? = null
        @SerializedName("BorrowerPhone")
        @Expose
        var borrowerPhone: String? = null
        @SerializedName("BorrowerEmail")
        @Expose
        var borrowerEmail: String? = null


        constructor(parcel: Parcel) : this() {
            isAllowInspection = parcel.readString()
            appointmentDate = parcel.readString()
            orderGenId = parcel.readString()
            itemId = parcel.readValue(Int::class.java.classLoader) as? Int
            userId = parcel.readValue(Int::class.java.classLoader) as? Int
            itemNoteId = parcel.readValue(Int::class.java.classLoader) as? Int
            orgId = parcel.readValue(Int::class.java.classLoader) as? Int
            diplayBorrowerInfo = parcel.readString()
            displayAddressInfo = parcel.readString()
            displayLoanInfo = parcel.readString()
            product = parcel.readString()
            appointmentTime = parcel.readString()
            message = parcel.readString()
            dueDate = parcel.readString()
            status = parcel.readString()
            tileAbbr = parcel.readString()
            clientName = parcel.readString()
            serviceRequestType = parcel.readValue(Int::class.java.classLoader) as? Int
            paymentRequired = parcel.readString()
            paymentAmount = parcel.readValue(Int::class.java.classLoader) as? Int
            condAcceptance = parcel.readString()
            itemSrNo = parcel.readValue(Int::class.java.classLoader) as? Int
            borrowerPhone=parcel.readString()
            borrowerEmail=parcel.readString()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(isAllowInspection)
            parcel.writeString(appointmentDate)
            parcel.writeString(orderGenId)
            parcel.writeValue(itemId)
            parcel.writeValue(userId)
            parcel.writeValue(itemNoteId)
            parcel.writeValue(orgId)
            parcel.writeString(diplayBorrowerInfo)
            parcel.writeString(displayAddressInfo)
            parcel.writeString(displayLoanInfo)
            parcel.writeString(product)
            parcel.writeString(appointmentTime)
            parcel.writeString(message)
            parcel.writeString(dueDate)
            parcel.writeString(status)
            parcel.writeString(tileAbbr)
            parcel.writeString(clientName)
            parcel.writeValue(serviceRequestType)
            parcel.writeString(paymentRequired)
            parcel.writeValue(paymentAmount)
            parcel.writeString(condAcceptance)
            parcel.writeValue(itemSrNo)
            parcel.writeString(borrowerPhone)
            parcel.writeString(borrowerEmail)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Orderdetail> {
            override fun createFromParcel(parcel: Parcel): Orderdetail {
                return Orderdetail(parcel)
            }

            override fun newArray(size: Int): Array<Orderdetail?> {
                return arrayOfNulls(size)
            }
        }


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeParcelable(data, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OrderDetailResponse> {
        override fun createFromParcel(parcel: Parcel): OrderDetailResponse {
            return OrderDetailResponse(parcel)
        }

        override fun newArray(size: Int): Array<OrderDetailResponse?> {
            return arrayOfNulls(size)
        }
    }


}