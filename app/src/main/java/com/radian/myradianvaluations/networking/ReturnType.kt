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
    GET_HELPTROUBLE("Mobile/Dashboard/OrganizationInfo")


    POST_SaveProfile("Mobile/Dashboard/SaveMyProfile"),
    POST_GetProfile("mobile/Dashboard/GetMyProfile"),
    POST_OutOffice("mobile/Dashboard/SaveVendorVacationInfo")
}