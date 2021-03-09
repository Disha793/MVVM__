package com.radian.myradianvaluations.networking

enum class ReturnType(val endPoint: String) {
    POST_GetUserStatus("mobile/Login/GetUserStatus"),
    POST_GenerateOtp("mobile/Login/GenerateOTPCode"),
    POST_VerifyOtp("mobile/Login/GetUserStatus"),
    POST_SignIn("mobile/Login/GetUserStatus"),


}