package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ProfileResponse {
    @SerializedName("Data")
    var data = ArrayList<Object>()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    class Object {

        @SerializedName("DraftVendorNewId")
        var draftVendorNewId = 0
        @SerializedName("VendorId")
        @Expose
        var vendorId = 0
        @SerializedName("VendorType")
        @Expose
        var vendorType = ""
        @SerializedName("VendorTypeDesc")
        @Expose
        var vendorTypeDesc = ""
        @SerializedName("UserDefinedId")
        @Expose
        var userDefinedId = ""
        @SerializedName("Name")
        @Expose
        var name = ""
        @SerializedName("IsIndividual")
        @Expose
        var isIndividual = true
        @SerializedName("EntityType")
        @Expose
        var entityType = ""
        @SerializedName("docId")
        @Expose
        var docId = 0
        @SerializedName("MobileUserId")
        @Expose
        var mobileUserId = 0
        @SerializedName("EoAmount")
        @Expose
        var eoAmount = ""
        @SerializedName("IsEOCovered")
        @Expose
        var isEOCovered = true
        @SerializedName("EoExpiryDate")
        @Expose
        var eoExpiryDate = ""
        @SerializedName("EoPolicyNo")
        @Expose
        var eoPolicyNo = ""
        @SerializedName("CarrierName")
        @Expose
        var carrierName = ""
        @SerializedName("UserId")
        @Expose
        var userId = 0
        @SerializedName("NotificationEmail")
        @Expose
        var notificationEmail = ""
        @SerializedName("DefaultValues")
        @Expose
        var defaultValues = ""
        @SerializedName("AgreementFlag")
        @Expose
        var agreementFlag = ""
        @SerializedName("AgreementSignName")
        @Expose
        var agreementSignName = ""
        @SerializedName("AgreementUpdDate")
        @Expose
        var agreementUpdDate = ""
        @SerializedName("AgreementOrgDate")
        @Expose
        var agreementOrgDate = ""
        @SerializedName("VendorContactId")
        @Expose
        var vendorContactId = 0
        @SerializedName("FirstName")
        @Expose
        var firstName = ""
        @SerializedName("MiddleName")
        @Expose
        var middleName = ""
        @SerializedName("LastName")
        @Expose
        var lastName = ""
        @SerializedName("WorkPhone")
        @Expose
        var workPhone = ""
        @SerializedName("DayPhone")
        @Expose
        var dayPhone = ""
        @SerializedName("DayPhoneExt")
        @Expose
        var dayPhoneExt = ""
        @SerializedName("HomePhone")
        @Expose
        var homePhone = ""
        @SerializedName("EvePhone")
        @Expose
        var evePhone = ""
        @SerializedName("EvePhoneExt")
        @Expose
        var evePhoneExt = ""
        @SerializedName("CellPhone")
        @Expose
        var cellPhone = ""
        @SerializedName("Email")
        @Expose
        var email = ""
        @SerializedName("Fax")
        @Expose
        var fax = ""
        @SerializedName("PrimaryPhone")
        @Expose
        var primaryPhone = ""
        @SerializedName("TextMsg")
        @Expose
        var textMsg = ""
        @SerializedName("AddressId")
        @Expose
        var addressId = 0
        @SerializedName("AddressLine1")
        @Expose
        var addressLine1 = ""
        @SerializedName("AddressLine2")
        @Expose
        var addressLine2 = ""
        @SerializedName("City")
        @Expose
        var city = ""
        @SerializedName("State")
        @Expose
        var state = ""
        @SerializedName("Zip")
        @Expose
        var zip = ""
        @SerializedName("County")
        @Expose
        var county = ""
        @SerializedName("CountyCode")
        @Expose
        var countyCode = ""
        @SerializedName("AddressVerified")
        @Expose
        var addressVerified = ""
        @SerializedName("VendorAddress")
        @Expose
        var vendorAddress = ""
        @SerializedName("OnVacation")
        @Expose
        var onVacation = false
        @SerializedName("VacationStartDate")
        @Expose
        var vacationStartDate = ""
        @SerializedName("VacationEndDate")
        @Expose
        var vacationEndDate = ""
        @SerializedName("VacationNote")
        @Expose
        var vacationNote = ""
        @SerializedName("EOFlag")
        @Expose
        var eOFlag = ""
        @SerializedName("EOFlagDes")
        @Expose
        var eOFlagDes = ""
        @SerializedName("ProfilePicURL")
        @Expose
        var profileImageUrl: String? = null
        @SerializedName("ProfilePicStatus")
        @Expose
        var profilePicStatus = ""
        @SerializedName("LicensePlate")
        @Expose
        var licaencePlate = ""
        @SerializedName("CarMake")
        @Expose
        var carMake = ""
    }
}