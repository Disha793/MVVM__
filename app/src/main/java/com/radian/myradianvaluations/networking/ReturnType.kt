package com.radian.myradianvaluations.networking

enum class ReturnType(val endPoint: String) {
    POST_GetUserStatus("mobile/Login/GetUserStatus"),
    POST_GenerateOtp("mobile/Login/GenerateOTPCode"),
    POST_VerifyOtp("mobile/Login/VerifyOTPCode"),
    POST_SignIn("mobile/Login/SignIn"),
    POST_Dashboard("Mobile/Dashboard/GetNewDashboardRefereshDetails"),
    POST_WhatsNew("Mobile/Dashboard/whatsnew"),
    POST_NewOrderList("Mobile/Dashboard/NewOrderList"),
    POST_NewOrderDetail("Mobile/Dashboard/GetNewOrderDetail"),
    POST_ConfirmOrder("mobile/Dashboard/SaveConfirmOrder"),
    GET_HELPTROUBLE("Mobile/Dashboard/OrganizationInfo"),
    POST_SaveProfile("Mobile/Dashboard/SaveMyProfile"),
    POST_GetProfile("mobile/Dashboard/GetMyProfile"),
    POST_OutOffice("mobile/Dashboard/SaveVendorVacationInfo"),
    POST_UploadImage("mobile/Dashboard/UploadDocument"),
    POST_OrderList("Mobile/Dashboard/OrderList"),
    POST_ManageOrderDetail("Mobile/Dashboard/GetManageOrderDetail"),

    //For Mark as read from dashboard
    POST_Dashboard_MarkReadRevisionReq("Mobile/Dashboard/DismissRequest"),
    POST_OrderDocListReq("mobile/Dashboard/GetTileOrderDocuments"),

    //For doc masrk as read from dashboard and order detail
    POST_OrderMarkDocReadReq("mobile/Dashboard/SaveDocumentMarkAsRead"),

    //For Revision and Message mark As read from order detail
    POST_OrderMarkReadReq("Mobile/notification/ReadBulkNotification"),
    POST_MessageChat("mobile/Dashboard/GetTileOrderNotes"),
    POST_SendMessage("mobile/Dashboard/AddMessage"),
    POST_DashboardTile("mobile/Dashboard/GetDashboardTileDetails"),

    //Revision List from order detail
    POST_OrderRevisionRequest("mobile/Dashboard/GetTileOrderRevision"),

    //to add/edit appoitment from order detail
    POST_AddAppointment("mobile/Dashboard/AddEditInspection"),

    POST_DeleteMessage("mobile/Dashboard/SaveMessageMarkAsRead"),

    //For code of conduct
    POST_SAVECOC("mobile/Dashboard/SaveVendorCompliance"),

    POST_VendorProfileDetail("mobile/vendorprofile/GetVendorProfileDetails"),
    POST_LicenceMaster("mobile/Dashboard/GetLicenseDropdownList"),
    POST_SaveLicence("mobile/vendorprofile/UpdateVendorLI"),
    POST_SaveW9Data("Mobile/VendorProfile/UpdateVendorW9"),
    POST_SaveEoDocData("mobile/vendorprofile/UpdateVendorEO"),
    POST_GetNotiStatus("mobile/Dashboard/GetNotificationStatus"),
    POST_SaveNotiStatus("mobile/Dashboard/SaveDeviceSetting"),

}