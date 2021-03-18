package com.radian.myradianvaluations.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ManageOrderResponse {
    @SerializedName("Data")
    var data = Data()

    class Data {
        @SerializedName("OrderDetail")
        var orderDetail = OrderDetail()

        class OrderDetail() : Parcelable {
            @SerializedName("OrderGenId")
            @Expose
            var orderGenId: String? = null

            @SerializedName("ItemId")
            @Expose
            var itemId: Int? = null

            @SerializedName("OrgId")
            @Expose
            var orgId: Int? = null

            @SerializedName("DisplayAddressInfo")
            @Expose
            var displayAddressInfo: String? = null

            @SerializedName("Product")
            @Expose
            var product: String? = null

            @SerializedName("ProductName")
            @Expose
            var productName: String? = null

            @SerializedName("Lockbox")
            @Expose
            var lockbox: String? = null

            @SerializedName("BorrowerPhone")
            @Expose
            var borrowerPhone: String? = null

            @SerializedName("BorrowerName")
            @Expose
            var borrowerName: String? = null

            @SerializedName("BorrowerEmail")
            @Expose
            var borrowerEmail: String? = null

            @SerializedName("AppointmentTime")
            @Expose
            var appointmentTime: String? = null

            @SerializedName("AppointmentStatus")
            @Expose
            var appointmentStatus: String? = null

            @SerializedName("AppointmentDate")
            @Expose
            var appointmentDate: String? = null

            @SerializedName("IsNotify")
            @Expose
            var isNotify: Boolean? = null

            @SerializedName("IsComplete")
            @Expose
            var isComplete: Boolean? = null

            @SerializedName("NotifyBorrower")
            @Expose
            var notifyBorrower: String? = null

            @SerializedName("InspectionComplete")
            @Expose
            var inspectionComplete: String? = null

            @SerializedName("Lat")
            @Expose
            var lat: String? = null

            @SerializedName("Lng")
            @Expose
            var lng: String? = null

            @SerializedName("UserId")
            @Expose
            var userId: Int? = null

            @SerializedName("ItemSrNo")
            @Expose
            var itemSrNo: Int? = null

            @SerializedName("DueDate")
            @Expose
            var dueDate: String? = null

            @SerializedName("ServiceRequestType")
            @Expose
            var serviceRequestType: Int? = null

            @SerializedName("ClientName")
            @Expose
            var clientName: String? = null

            @SerializedName("DisplayLoanInfo")
            @Expose
            var displayLoanInfo: String? = null

            @SerializedName("NewDocumentCount")
            @Expose
            var newDocumentCount: Int? = null

            @SerializedName("NewDocumentFlag")
            @Expose
            var newDocumentFlag: Boolean = false

            @SerializedName("NewRevisionCount")
            @Expose
            var newRevisionCount: Int? = null

            @SerializedName("NewRevisionFlag")
            @Expose
            var newRevisionFlag: Boolean = false

            @SerializedName("NewNoteCount")
            @Expose
            var newNoteCount: Int? = null

            @SerializedName("NewNoteCountFlag")
            @Expose
            var newNoteCountFlag: Boolean = false

            constructor(parcel: Parcel) : this() {
                orderGenId = parcel.readString()
                itemId = parcel.readInt()
                displayAddressInfo = parcel.readString()
                product = parcel.readString()
                productName=parcel.readString()
                lockbox = parcel.readString()
                borrowerPhone = parcel.readString()
                borrowerName = parcel.readString()
                borrowerEmail = parcel.readString()
                appointmentTime = parcel.readString()
                appointmentStatus = parcel.readString()
                appointmentDate = parcel.readString()
                isNotify = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
                isComplete = parcel.readValue(Boolean::class.java.classLoader) as Boolean?
                notifyBorrower = parcel.readString()
                inspectionComplete = parcel.readString()
                lat = parcel.readString()
                lng = parcel.readString()
                userId = parcel.readInt()
                itemSrNo = parcel.readInt()
                dueDate = parcel.readString()
                serviceRequestType = parcel.readInt()
                clientName = parcel.readString()
                displayLoanInfo = parcel.readString()
                newDocumentCount = parcel.readInt()
                newDocumentFlag = parcel.readValue(Boolean::class.java.classLoader) as Boolean
                newRevisionCount = parcel.readInt()
                newRevisionFlag = parcel.readValue(Boolean::class.java.classLoader) as Boolean
                newNoteCount = parcel.readInt()
                newNoteCountFlag = parcel.readValue(Boolean::class.java.classLoader) as Boolean
            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(orderGenId)
                itemId?.let { parcel.writeInt(it) }
                orgId?.let { parcel.writeInt(it) }
                parcel.writeString(displayAddressInfo)
                parcel.writeString(product)
                parcel.writeString(productName)
                parcel.writeString(lockbox)
                parcel.writeString(borrowerPhone)
                parcel.writeString(borrowerName)
                parcel.writeString(borrowerEmail)
                parcel.writeString(appointmentTime)
                parcel.writeString(appointmentStatus)
                parcel.writeString(appointmentDate)
                isNotify?.let { parcel.writeValue(it) }
                isComplete?.let { parcel.writeValue(it) }
                parcel.writeString(notifyBorrower)
                parcel.writeString(inspectionComplete)
                parcel.writeString(lat)
                parcel.writeString(lng)
                userId?.let { parcel.writeInt(it) }
                itemSrNo?.let { parcel.writeInt(it) }
                parcel.writeString(dueDate)
                serviceRequestType?.let { parcel.writeInt(it) }
                parcel.writeString(clientName)
                parcel.writeString(displayLoanInfo)
                newDocumentCount?.let { parcel.writeInt(it) }
                newDocumentFlag.let { parcel.writeValue(it) }
                newRevisionCount?.let { parcel.writeInt(it) }
                newRevisionFlag.let { parcel.writeValue(it) }
                newNoteCount?.let { parcel.writeInt(it) }
                newNoteCountFlag.let { parcel.writeValue(it) }
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<OrderDetail> {
                override fun createFromParcel(parcel: Parcel): OrderDetail {
                    return OrderDetail(parcel)
                }

                override fun newArray(size: Int): Array<OrderDetail?> {
                    return arrayOfNulls(size)
                }
            }
        }

    }

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()
}