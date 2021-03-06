package com.radian.myradianvaluations.constants

object Const {
    val scrMessgaeTag = "Message"
    val scrTag: String = "ScrTag"
    val scrDocTag: Int = 101
    val scrAcceptTag: Int = 102
    val scrAttentnTag = 103
    val scrSettingsTag = 104
    val scrOrderDetailTag = 105
    val scrMsgListTag = 106
    val scrRewardsTag = 107
    val scrCovidTag = 108
    val scrOrgInfo = 109
    val scrSignUp = 110
    val scrViewPdf = 111
    val scrSearchFilterTag = "SearchFilter"
    val idTag = "id"
    val itemIdTag = "ItemId"
    val currentCatPos = "CurrentCategoryPos"
    val detailData = "NewOrderDetailData"
    val notificationidTag = "mobileNotificationId"
    val loeUrlTag = "loeurl"
    val scrDrawerTag = "Drawer"
    val formatYYYY = "yyyy/MM/dd"
    val formatMM = "MM/dd/yyyy"
    const val CONNECTION_TIMEOUT: Long = 3
    val formatMMM = "dd MMM, yyyy"
    val formatHH = "hh:mm:ss a"
    val formatDateTime = formatMMM + " " + formatHH
    val basicLoginDetail = "LoginDetail"
    val formatDueDateTime = formatMM + " " + formatHH
    val formatCurrentDueDateTime = "MM-dd-yyyy" + " " + "hh:mm:ss"
    val formatAppoinmnt = formatMM + " " + "hh:mm" + " a"

    //Firebase event key name
    val methodInvoked = "methodInvoked"
    val screenLaunched = "screenLaunched"
    val conditional = "Conditional"
    val accept = "Accept"
    val reject = "Reject"
    val btnCount = "BtnCount"
    val actionView = "View"
    val actionRead = "Read"
    const val INTENT_CAMERA_KEY: String = "FROM_CAMERA"
    const val INTENT_POSITION_KEY: String = "POSITION"
    const val ASSET_SHARED_PREF_KEY = "ASSETS"
    const val CATEGORIES_SHARED_PREF_KEY = "CATEGORIES"
    const val UPLOADED_PHOTOS_SHARED_PREF_KEY = "UPLOADED_PHOTOS"
    const val IS_FIRST_TIME = "TRUE"
    const val PASSWORD_PATTERN="^" +
            "(?=.*[0-9])" +         //at least 1 digit
            "(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[@#$%^&+=!()-_])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{8,}" +               //at least 8 characters
            "$"
const val imgnName="MyRVal_Img"
var IS_REFRESH_SUB:Boolean=true
var IS_REFRESH_COMP:Boolean=true
}