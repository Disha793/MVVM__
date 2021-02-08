package com.radian.vendorbridge.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class LoginResponse() : Parcelable {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    constructor(parcel: Parcel) : this() {
        status = parcel.readString()!!
        this.data = parcel.readParcelable(Data::class.java.classLoader)!!
    }

    class Data() : Parcelable {
        @SerializedName("DeviceStatus")
        var deviceStatus: Int = 0
        @SerializedName("PhoneNumber")
        var phoneNumber: String = ""
        @SerializedName("AuthToken")
        var authToken: String = ""
        @SerializedName("MobileUserId")
        var mobileUserId: Int = 0
        @SerializedName("UserDetailsJson")
        var userDetailJson = UserDetailJson()

        constructor(parcel: Parcel) : this() {
            deviceStatus = parcel.readInt()
            phoneNumber = parcel.readString()!!
            authToken = parcel.readString()!!
            mobileUserId = parcel.readInt()
            userDetailJson = parcel.readParcelable(UserDetailJson::class.java.classLoader)!!

        }

        class UserDetailJson() : Parcelable {
            @SerializedName("Users")
            var userList = ArrayList<User>()
            @SerializedName("CocFlag")
            var cocFlag: Boolean = false
            @SerializedName("BtnCount")
            var btnCount: Int = 0

            constructor(parcel: Parcel) : this() {
                this.userList =
                    parcel.readArrayList(User::class.java.classLoader) as ArrayList<User>
            }


            class User : Parcelable {


                @SerializedName("OrgId")
                var orgId = 0
                @SerializedName("LoginId")
                var loginId: String? = null
                @SerializedName("UserId")
                var userId: Int? = null

                constructor(parcel: Parcel) : this() {
                    orgId = parcel.readInt()
                    loginId = parcel.readString()
                }

                constructor()


                companion object CREATOR : Parcelable.Creator<User> {
                    override fun createFromParcel(parcel: Parcel): User {
                        return User(parcel)
                    }

                    override fun newArray(size: Int): Array<User?> {
                        return arrayOfNulls(size)
                    }
                }

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeInt(orgId)
                    parcel.writeString(loginId)
                }

                override fun describeContents(): Int {
                    return 0
                }

            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeList(this.userList as List<*>?)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<UserDetailJson> {
                override fun createFromParcel(parcel: Parcel): UserDetailJson {
                    return UserDetailJson(parcel)
                }

                override fun newArray(size: Int): Array<UserDetailJson?> {
                    return arrayOfNulls(size)
                }
            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(deviceStatus)
            parcel.writeString(phoneNumber)
            parcel.writeString(authToken)
            parcel.writeInt(mobileUserId)
            parcel.writeParcelable(userDetailJson, flags)
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeParcelable(data, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoginResponse> {
        override fun createFromParcel(parcel: Parcel): LoginResponse {
            return LoginResponse(parcel)
        }

        override fun newArray(size: Int): Array<LoginResponse?> {
            return arrayOfNulls(size)
        }
    }

}