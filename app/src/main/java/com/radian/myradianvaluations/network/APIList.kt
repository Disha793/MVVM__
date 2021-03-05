package com.radian.myradianvaluations.network


import com.radian.vendorbridge.Response.*
import io.reactivex.Observable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.*

interface APIList {
    @FormUrlEncoded
    @POST("mobile/Login/SignIn")
    suspend fun login(
        @Field("DeviceID") deviceId: String, @Field("PhoneNumber") phoneNumber: String,
        @Field("PinNo") pinCode: String,
        @Field("FcmToken") fcmToken: String

    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("mobile/Login/GetUserStatus")
    suspend fun getUserStatus(
        @Field("deviceID") deviceId: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("UserName") userName: String,
        @Field("Password") password: String
    ): Response<StatusResponse>


    @GET("Mobile/Dashboard/OrganizationInfo")
    suspend fun getOrganizationInfo(

    ): Response<OrgInfoResponse>

    @FormUrlEncoded
    @POST("mobile/Login/GenerateOTPCode")
    suspend fun generateOtp(
        @Field("deviceID") deviceId: String,
        @Field("PhoneNumber") phoneNumber: String
    ): Response<OtpResponse>

    @FormUrlEncoded
    @POST("mobile/Login/VerifyOTPCode")
    suspend fun verifyOtp(
        @Field("DeviceID") deviceId: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("VerificationCode") verificatnCode: String,
        @Field("DeviceName") deviceName: String,
        @Field("DeviceType") deviceTyp: String,
        @Field("Manufacturer") manufacturer: String,
        @Field("OsVersion") osVersion: String,
        @Field("FcmToken") fcmToken: String
    ): Response<OtpResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetDashboardRefereshDetails")
    suspend fun getDashboardDataOld(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("LoginId") loginId: String,
        @Field("OrganizationIds") organizatnId: Int,
        @Field("AndroidAppversion") androidAppVersion: String?,
        @Field("iOSAppversion") iosappVersion: String?

    ): Response<DashboadResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetDashboardTileDetails")
    suspend fun getMyOrders(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organizatnId: Int,
        @Field("Tiles") tiles: String
    ): Response<SearchFilterResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetSearchFilterTileDetails")
    suspend fun getsearchFilterDetails(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String>
    ): Response<SearchFilterResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetMyProfile")
    fun getMyProfile(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int
    ): Observable<ProfileResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveVendorVacationInfo")
    suspend fun saveoutOfOffice(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("Note") note: String,
        @Field("Startdate") startDate: String,
        @Field("Enddate") endDate: String,
        @Field("OnVacation") onVacation: String
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/AddEditInspection")
    suspend fun addInspection(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, Any?>
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/OrderDetail")
    suspend fun getOrderDetail(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, Any?>
    ): Response<OrderDetailResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetTileOrderDocuments")
    suspend fun getOrderDocument(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, Any?>
    ): Response<OrderDocResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetTileOrderNotes")
    suspend fun getMessageChat(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String?>
    ): Response<MessageChatResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/AddMessage")
    suspend fun addMessageChat(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String?>
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetNotificationStatus")
    suspend fun getNotificatnStatus(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String?>
    ): Response<NotiStatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveDeviceSetting")
    suspend fun saveNotificatnStatus(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String?>
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetOrganizationsList")
    suspend fun getOrganizatn(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String?>
    ): Response<OrganizatnResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetTileOrderRevision")
    suspend fun getOrderRevisn(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, String?>
    ): Response<OrderRevisionResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveMessageMarkAsRead")
    fun deleteMessage(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, Any?>
    ): Observable<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveDocumentMarkAsRead")
    suspend fun deleteDocument(
        @Header("Authorization") authToken: String,
        @FieldMap field: HashMap<String, Any?>
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveConfirmOrder")
    suspend fun confirmOrder(
        @Header("Authorization") authToken: String, @FieldMap field: HashMap<String, Any?>, @Field(
            "ItemIds"
        ) itemId: List<Int>,
        @Field(
            "UnassignedItemIds"
        ) unassignedItemId: List<Int>
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveConfirmOrder")
    suspend fun conditionlOrder(
        @Header("Authorization") authToken: String, @FieldMap field: HashMap<String, Any?>, @Field(
            "ItemIds"
        ) itemId: List<Int>,
        @Field(
            "ItemNotes"
        ) noteList: Array<String?>,
        @Field(
            "PriceChanges"
        ) priceList: Array<String?>,
        @Field(
            "DueDateChanges"
        ) dateList: Array<String?>,
        @Field(
            "OrganizationIds"
        ) orgIds: List<Int>

    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveConfirmOrder")
    suspend fun rejectOrder(
        @Header("Authorization") authToken: String, @FieldMap field: HashMap<String, Any?>, @Field(
            "ItemIds"
        ) itemId: List<Int>,
        @Field(
            "ItemNotes"
        ) noteList: Array<String?>,
        @Field(
            "OrganizationIds"
        ) orgIds: List<Int>

    ): Response<StatusResponse>

    @Multipart
    @POST("mobile/Dashboard/UploadDocument")
    fun uploadImage(
        @Header("Authorization") authToken: String,
        @Part file: @JvmSuppressWildcards MultipartBody.Part,
        @Part("filename") filename: @JvmSuppressWildcards RequestBody,
        @PartMap values: HashMap<String, RequestBody>
    )
            : Observable<ProfileImageResponse>

    @FormUrlEncoded
    @POST("Mobile/Notification/NotificationList")
    suspend fun getNotificationList(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int
    ): Response<NotificationResponse>

    @FormUrlEncoded
    @POST("Mobile/Notification/ReadNotification")
    suspend fun updateReadFlag(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("MobileNotificationId") notificationId: Int,
        @Field("NotificationReadFlag") readFlag: String
    ): Response<NotiStatusResponse>

    @FormUrlEncoded
    @POST("Mobile/Dashboard/NotifyBorrower")
    suspend fun notifyBorrower(
        @Header("Authorization") authToken: String,
        @FieldMap postparams: HashMap<String, Any?>
    ): Response<NotiStatusResponse>

    @FormUrlEncoded
    @POST("Mobile/Dashboard/MobileVendorRewardDetail")
    suspend fun getRewards(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field(
            "OrganizationIds"
        ) orgId: Int
    ): Response<RewardsResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/SaveVendorCompliance")
    suspend fun saveCompliance(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("ActionType") actionType: String,
        @Field("AcceptedBy") acceptedBy: String?
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("Mobile/Dashboard/SaveMyProfile")
    fun saveProfile(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("LicensePlate") licencePlate: String,
        @Field("CarMake") carMake: String
    ): Observable<StatusResponse>

    @FormUrlEncoded
    @POST("mobile/Dashboard/GetLicenseDropdownList")
    suspend fun getLicenceMaster(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("Organizations") organization: Int,
        @Field("DropDownType") drpdwnType: String
    ): Response<LicenceMasterModel>

    @FormUrlEncoded
    @POST("mobile/vendorprofile/GetVendorProfileDetails")
    suspend fun getVendorProfileData(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("ActionType") actionType: String

    ): Response<VendorProfileResponse>

    @FormUrlEncoded
    @POST("/mobile/vendorprofile/UpdateVendorLI")
    fun saveLicenceDetails(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("ActionType") actionType: String,
        @Field("VENDORID") vendorId: String?,
        @Field("VENDORGROUPID") vendrGrpId: String?,
        @Field("DOCGROUP") docGrp: String?,
        @Field("DOCID") docId: String?,
        @Field("DOCDESCRIPTION") docDes: String?,
        @Field("DOCIDABBR") docIdAbbr: String?,
        @Field("VPCATEGORY") vpCat: String?,
        @Field("LICENSE") licence: String?,
        @Field("LICENSETYPEID") licenceType: String?,
        @Field("EXPIRYDATE") expiryDte: String?
    ): Observable<StatusResponse>

    @FormUrlEncoded
    @POST("/mobile/vendorprofile/UpdateVendorEO")
    fun saveEoDetails(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("VENDORID") vendorId: String?,
        @Field("VENDORGROUPID") vendrGrpId: String?,
        @Field("DOCGROUP") docGrp: String?,
        @Field("DOCID") docId: String?,
        @Field("EOCARRIER") docDes: String?,
        @Field("DOCIDABBR") docAbbr: String?,
        @Field("VPCATEGORY") vpCat: String?,
        @Field("EOAMOUNT") eoAmnt: String?,
        @Field("EOPOLICYNO") eoPolicy: String?,
        @Field("EXPIRYDATE") expiry: String?

    ): Observable<StatusResponse>


    @FormUrlEncoded
    @POST("/Mobile/VendorProfile/UpdateVendorW9")
    fun saveW9Details(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("VENDORID") vendorId: String?,
        @FieldMap map: HashMap<String, Any?>
    ): Observable<StatusResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/whatsnew")
    suspend fun whatsNew(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int
    ): Response<WhatsNewResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/DismissUpcomingAppointment")
    suspend fun dismissAppt(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organization: Int,
        @Field("ItemId") itemId: String
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/OrderList")
    suspend fun orderList(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organization: Int
    ): Response<OrderListResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/GetManageOrderDetail")
    suspend fun manageOrder(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organization: Int,
        @Field("Itemid") itemId: Int
    ): Response<ManageOrderResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/NewOrderList")
    suspend fun newOrderList(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organization: Int
    ): Response<NewOrderResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/GetNewOrderDetail")
    suspend fun newOrderDetail(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organization: Int,
        @Field("Itemid") itemId: Int
    ): Response<NewOrderDetailResponse>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/GetNewDashboardRefereshDetails")
     fun getDashboardData(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("LoginId") loginId: String,
        @Field("OrganizationIds") organizatnId: Int,
        @Field("AndroidAppversion") androidAppVersion: String?,
        @Field("iOSAppversion") iosappVersion: String?
    ): Observable<DashboardResponseNew>

    @FormUrlEncoded
    @POST("/Mobile/Dashboard/DismissRequest")
    suspend fun dismissRevisionReq(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organizatnId: Int,
        @Field("ActionType") actionType: String,
        @Field("Itemid") itemId: Int
    ): Response<StatusResponse>

    @FormUrlEncoded
    @POST("/Mobile/notification/ReadBulkNotification")
    suspend fun readBulkNotificatn(
        @Header("Authorization") authToken: String,
        @Field("PhoneNumber") phoneNumber: String,
        @Field("DeviceID") deviceId: String,
        @Field("MobileUserId") mobileUserId: Int,
        @Field("OrganizationIds") organizatnId: Int,
        @Field("ActionType") actionType: String,
        @Field("Itemid") itemId: Int,
        @Field("Orderid") orderId: String
    ): Response<StatusResponse>

}