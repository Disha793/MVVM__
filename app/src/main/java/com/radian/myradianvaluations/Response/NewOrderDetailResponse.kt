package com.radian.myradianvaluations.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewOrderDetailResponse {


    @SerializedName("Data")
    @Expose
    val data: Data? = null

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()


    class Data {
        @SerializedName("OrderDetail")
        @Expose
        val orderDetail: OrderDetail? = null

        class OrderDetail() :Parcelable {
            @SerializedName("OrderGenId")
            @Expose
            var orderGenId = ""

            @SerializedName("ItemId")
            @Expose
            var itemId = 0

            @SerializedName("OrgId")
            @Expose
            var orgId = 0

            @SerializedName("DisplayAddressInfo")
            @Expose
            var displayAddressInfo = ""

            @SerializedName("Product")
            @Expose
            var product = ""
            @SerializedName("ProductName")
            @Expose
            var productName = ""
            @SerializedName("Lockbox")
            @Expose
            var lockbox = ""

            @SerializedName("BorrowerPhone")
            @Expose
            var borrowerPhone = ""

            @SerializedName("BorrowerName")
            @Expose
            var borrowerName = ""

            @SerializedName("BorrowerEmail")
            @Expose
            var borrowerEmail = ""

            @SerializedName("StartTimeSlot")
            @Expose
            var startTimeSlot = ""

            @SerializedName("EndTimeSlot")
            @Expose
            var endTimeSlot = ""

            @SerializedName("AppointmentDate")
            @Expose
            var appointmentDate = ""

            @SerializedName("Lat")
            @Expose
            var lat = ""

            @SerializedName("Lng")
            @Expose
            var lng = ""

            @SerializedName("UserId")
            @Expose
            var userId = 0

            @SerializedName("ItemSrNo")
            @Expose
            var itemSrNo = 0

            @SerializedName("ProductDueDate")
            @Expose
            var productDueDate = ""

            @SerializedName("ServiceRequestType")
            @Expose
            var serviceRequestType = 0

            @SerializedName("ClientName")
            @Expose
            var clientName = ""

            @SerializedName("PaymentAmount")
            @Expose
            var paymentAmount = ""

            @SerializedName("Broadcastcount")
            @Expose
            var broadcastcount = 0

            @SerializedName("AppointmentTimedetails")
            @Expose
            var appointmentTimedetails : ArrayList<String>? = null

            @SerializedName("Message")
            @Expose
            var message = ""
            @SerializedName("IsAssigned")
            @Expose
            var isAssigned=0

            constructor(parcel: Parcel) : this() {
                orderGenId = parcel.readString().toString()
                itemId = parcel.readInt()
                orgId = parcel.readInt()
                displayAddressInfo = parcel.readString().toString()
                product = parcel.readString().toString()
                lockbox = parcel.readString().toString()
                borrowerPhone = parcel.readString().toString()
                borrowerName = parcel.readString().toString()
                borrowerEmail = parcel.readString().toString()
                startTimeSlot = parcel.readString().toString()
                endTimeSlot = parcel.readString().toString()
                appointmentDate = parcel.readString().toString()
                lat = parcel.readString().toString()
                lng = parcel.readString().toString()
                userId = parcel.readInt()
                itemSrNo = parcel.readInt()
                productDueDate = parcel.readString().toString()
                serviceRequestType = parcel.readInt()
                clientName = parcel.readString().toString()
                paymentAmount = parcel.readString().toString()
                broadcastcount = parcel.readInt()
                message = parcel.readString().toString()
                isAssigned = parcel.readInt()
            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
               orderGenId.let{parcel.writeString(it)}
                parcel.writeInt(itemId)
                parcel.writeInt(orgId)
                parcel.writeString(displayAddressInfo)
                parcel.writeString(product)
                parcel.writeString(lockbox)
                parcel.writeString(borrowerPhone)
                parcel.writeString(borrowerName)
                parcel.writeString(borrowerEmail)
                parcel.writeString(startTimeSlot)
                parcel.writeString(endTimeSlot)
                parcel.writeString(appointmentDate)
                parcel.writeString(lat)
                parcel.writeString(lng)
                parcel.writeInt(userId)
                parcel.writeInt(itemSrNo)
                parcel.writeString(productDueDate)
                parcel.writeInt(serviceRequestType)
                parcel.writeString(clientName)
                parcel.writeString(paymentAmount)
                parcel.writeInt(broadcastcount)
                parcel.writeString(message)
                parcel.writeInt(isAssigned)
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
}
