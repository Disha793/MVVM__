package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/radian/myradianvaluations/Response/ProfileResponse;", "", "()V", "data", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ProfileResponse$Object;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "errorInfo", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "setErrorInfo", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Object", "app_DevDebug"})
public final class ProfileResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ProfileResponse.Object> data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.ProfileResponse.Object> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.ProfileResponse.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> getErrorInfo() {
        return null;
    }
    
    public final void setErrorInfo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> p0) {
    }
    
    public ProfileResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\\\n\u0002\u0010\u000b\n\u0002\bN\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001e\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010\'\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001e\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001e\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001e\u00100\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001e\u00103\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001e\u00106\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001e\u00109\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\f\"\u0004\b;\u0010\u000eR\u001e\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001e\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001e\u0010B\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR\u001e\u0010E\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010\u000eR\u001e\u0010H\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR\u001e\u0010K\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u000eR\u001e\u0010N\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\f\"\u0004\bP\u0010\u000eR\u001e\u0010Q\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\f\"\u0004\bS\u0010\u000eR\u001e\u0010T\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\f\"\u0004\bV\u0010\u000eR\u001e\u0010W\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\f\"\u0004\bY\u0010\u000eR\u001e\u0010Z\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\f\"\u0004\b\\\u0010\u000eR\u001e\u0010]\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\f\"\u0004\b_\u0010\u000eR\u001e\u0010`\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\f\"\u0004\bb\u0010\u000eR\u001e\u0010c\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\f\"\u0004\be\u0010\u000eR\u001e\u0010f\u001a\u00020g8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010h\"\u0004\bi\u0010jR\u001e\u0010k\u001a\u00020g8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010h\"\u0004\bl\u0010jR\u001e\u0010m\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\f\"\u0004\bo\u0010\u000eR\u001e\u0010p\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\f\"\u0004\br\u0010\u000eR\u001e\u0010s\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\f\"\u0004\bu\u0010\u000eR\u001e\u0010v\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0006\"\u0004\bx\u0010\bR\u001e\u0010y\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\f\"\u0004\b{\u0010\u000eR\u001e\u0010|\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\f\"\u0004\b~\u0010\u000eR \u0010\u007f\u001a\u00020g8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010h\"\u0005\b\u0081\u0001\u0010jR!\u0010\u0082\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\f\"\u0005\b\u0084\u0001\u0010\u000eR#\u0010\u0085\u0001\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\f\"\u0005\b\u0087\u0001\u0010\u000eR!\u0010\u0088\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\f\"\u0005\b\u008a\u0001\u0010\u000eR!\u0010\u008b\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\f\"\u0005\b\u008d\u0001\u0010\u000eR!\u0010\u008e\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\f\"\u0005\b\u0090\u0001\u0010\u000eR!\u0010\u0091\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\f\"\u0005\b\u0093\u0001\u0010\u000eR!\u0010\u0094\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0006\"\u0005\b\u0096\u0001\u0010\bR!\u0010\u0097\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\f\"\u0005\b\u0099\u0001\u0010\u000eR!\u0010\u009a\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\f\"\u0005\b\u009c\u0001\u0010\u000eR!\u0010\u009d\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010\f\"\u0005\b\u009f\u0001\u0010\u000eR!\u0010\u00a0\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a1\u0001\u0010\f\"\u0005\b\u00a2\u0001\u0010\u000eR!\u0010\u00a3\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a4\u0001\u0010\u0006\"\u0005\b\u00a5\u0001\u0010\bR!\u0010\u00a6\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00a7\u0001\u0010\u0006\"\u0005\b\u00a8\u0001\u0010\bR!\u0010\u00a9\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00aa\u0001\u0010\f\"\u0005\b\u00ab\u0001\u0010\u000eR!\u0010\u00ac\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ad\u0001\u0010\f\"\u0005\b\u00ae\u0001\u0010\u000eR!\u0010\u00af\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b0\u0001\u0010\f\"\u0005\b\u00b1\u0001\u0010\u000eR!\u0010\u00b2\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00b3\u0001\u0010\f\"\u0005\b\u00b4\u0001\u0010\u000e\u00a8\u0006\u00b5\u0001"}, d2 = {"Lcom/radian/myradianvaluations/Response/ProfileResponse$Object;", "", "()V", "addressId", "", "getAddressId", "()I", "setAddressId", "(I)V", "addressLine1", "", "getAddressLine1", "()Ljava/lang/String;", "setAddressLine1", "(Ljava/lang/String;)V", "addressLine2", "getAddressLine2", "setAddressLine2", "addressVerified", "getAddressVerified", "setAddressVerified", "agreementFlag", "getAgreementFlag", "setAgreementFlag", "agreementOrgDate", "getAgreementOrgDate", "setAgreementOrgDate", "agreementSignName", "getAgreementSignName", "setAgreementSignName", "agreementUpdDate", "getAgreementUpdDate", "setAgreementUpdDate", "carMake", "getCarMake", "setCarMake", "carrierName", "getCarrierName", "setCarrierName", "cellPhone", "getCellPhone", "setCellPhone", "city", "getCity", "setCity", "county", "getCounty", "setCounty", "countyCode", "getCountyCode", "setCountyCode", "dayPhone", "getDayPhone", "setDayPhone", "dayPhoneExt", "getDayPhoneExt", "setDayPhoneExt", "defaultValues", "getDefaultValues", "setDefaultValues", "docId", "getDocId", "setDocId", "draftVendorNewId", "getDraftVendorNewId", "setDraftVendorNewId", "eOFlag", "getEOFlag", "setEOFlag", "eOFlagDes", "getEOFlagDes", "setEOFlagDes", "email", "getEmail", "setEmail", "entityType", "getEntityType", "setEntityType", "eoAmount", "getEoAmount", "setEoAmount", "eoExpiryDate", "getEoExpiryDate", "setEoExpiryDate", "eoPolicyNo", "getEoPolicyNo", "setEoPolicyNo", "evePhone", "getEvePhone", "setEvePhone", "evePhoneExt", "getEvePhoneExt", "setEvePhoneExt", "fax", "getFax", "setFax", "firstName", "getFirstName", "setFirstName", "homePhone", "getHomePhone", "setHomePhone", "isEOCovered", "", "()Z", "setEOCovered", "(Z)V", "isIndividual", "setIndividual", "lastName", "getLastName", "setLastName", "licaencePlate", "getLicaencePlate", "setLicaencePlate", "middleName", "getMiddleName", "setMiddleName", "mobileUserId", "getMobileUserId", "setMobileUserId", "name", "getName", "setName", "notificationEmail", "getNotificationEmail", "setNotificationEmail", "onVacation", "getOnVacation", "setOnVacation", "primaryPhone", "getPrimaryPhone", "setPrimaryPhone", "profileImageUrl", "getProfileImageUrl", "setProfileImageUrl", "profilePicStatus", "getProfilePicStatus", "setProfilePicStatus", "state", "getState", "setState", "textMsg", "getTextMsg", "setTextMsg", "userDefinedId", "getUserDefinedId", "setUserDefinedId", "userId", "getUserId", "setUserId", "vacationEndDate", "getVacationEndDate", "setVacationEndDate", "vacationNote", "getVacationNote", "setVacationNote", "vacationStartDate", "getVacationStartDate", "setVacationStartDate", "vendorAddress", "getVendorAddress", "setVendorAddress", "vendorContactId", "getVendorContactId", "setVendorContactId", "vendorId", "getVendorId", "setVendorId", "vendorType", "getVendorType", "setVendorType", "vendorTypeDesc", "getVendorTypeDesc", "setVendorTypeDesc", "workPhone", "getWorkPhone", "setWorkPhone", "zip", "getZip", "setZip", "app_DevDebug"})
    public static final class Object {
        @com.google.gson.annotations.SerializedName(value = "DraftVendorNewId")
        private int draftVendorNewId = 0;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VendorId")
        private int vendorId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VendorType")
        private java.lang.String vendorType = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VendorTypeDesc")
        private java.lang.String vendorTypeDesc = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "UserDefinedId")
        private java.lang.String userDefinedId = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Name")
        private java.lang.String name = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsIndividual")
        private boolean isIndividual = true;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EntityType")
        private java.lang.String entityType = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "docId")
        private int docId = 0;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "MobileUserId")
        private int mobileUserId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EoAmount")
        private java.lang.String eoAmount = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsEOCovered")
        private boolean isEOCovered = true;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EoExpiryDate")
        private java.lang.String eoExpiryDate = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EoPolicyNo")
        private java.lang.String eoPolicyNo = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CarrierName")
        private java.lang.String carrierName = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "UserId")
        private int userId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "NotificationEmail")
        private java.lang.String notificationEmail = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DefaultValues")
        private java.lang.String defaultValues = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AgreementFlag")
        private java.lang.String agreementFlag = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AgreementSignName")
        private java.lang.String agreementSignName = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AgreementUpdDate")
        private java.lang.String agreementUpdDate = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AgreementOrgDate")
        private java.lang.String agreementOrgDate = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VendorContactId")
        private int vendorContactId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "FirstName")
        private java.lang.String firstName = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "MiddleName")
        private java.lang.String middleName = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LastName")
        private java.lang.String lastName = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "WorkPhone")
        private java.lang.String workPhone = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DayPhone")
        private java.lang.String dayPhone = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DayPhoneExt")
        private java.lang.String dayPhoneExt = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "HomePhone")
        private java.lang.String homePhone = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EvePhone")
        private java.lang.String evePhone = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EvePhoneExt")
        private java.lang.String evePhoneExt = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CellPhone")
        private java.lang.String cellPhone = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Email")
        private java.lang.String email = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Fax")
        private java.lang.String fax = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "PrimaryPhone")
        private java.lang.String primaryPhone = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "TextMsg")
        private java.lang.String textMsg = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AddressId")
        private int addressId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AddressLine1")
        private java.lang.String addressLine1 = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AddressLine2")
        private java.lang.String addressLine2 = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "City")
        private java.lang.String city = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "State")
        private java.lang.String state = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Zip")
        private java.lang.String zip = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "County")
        private java.lang.String county = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CountyCode")
        private java.lang.String countyCode = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AddressVerified")
        private java.lang.String addressVerified = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VendorAddress")
        private java.lang.String vendorAddress = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "OnVacation")
        private boolean onVacation = false;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VacationStartDate")
        private java.lang.String vacationStartDate = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VacationEndDate")
        private java.lang.String vacationEndDate = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VacationNote")
        private java.lang.String vacationNote = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EOFlag")
        private java.lang.String eOFlag = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EOFlagDes")
        private java.lang.String eOFlagDes = "";
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProfilePicURL")
        private java.lang.String profileImageUrl;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProfilePicStatus")
        private java.lang.String profilePicStatus = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LicensePlate")
        private java.lang.String licaencePlate = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CarMake")
        private java.lang.String carMake = "";
        
        public final int getDraftVendorNewId() {
            return 0;
        }
        
        public final void setDraftVendorNewId(int p0) {
        }
        
        public final int getVendorId() {
            return 0;
        }
        
        public final void setVendorId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVendorType() {
            return null;
        }
        
        public final void setVendorType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVendorTypeDesc() {
            return null;
        }
        
        public final void setVendorTypeDesc(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getUserDefinedId() {
            return null;
        }
        
        public final void setUserDefinedId(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean isIndividual() {
            return false;
        }
        
        public final void setIndividual(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEntityType() {
            return null;
        }
        
        public final void setEntityType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getDocId() {
            return 0;
        }
        
        public final void setDocId(int p0) {
        }
        
        public final int getMobileUserId() {
            return 0;
        }
        
        public final void setMobileUserId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEoAmount() {
            return null;
        }
        
        public final void setEoAmount(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean isEOCovered() {
            return false;
        }
        
        public final void setEOCovered(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEoExpiryDate() {
            return null;
        }
        
        public final void setEoExpiryDate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEoPolicyNo() {
            return null;
        }
        
        public final void setEoPolicyNo(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCarrierName() {
            return null;
        }
        
        public final void setCarrierName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getUserId() {
            return 0;
        }
        
        public final void setUserId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getNotificationEmail() {
            return null;
        }
        
        public final void setNotificationEmail(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDefaultValues() {
            return null;
        }
        
        public final void setDefaultValues(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAgreementFlag() {
            return null;
        }
        
        public final void setAgreementFlag(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAgreementSignName() {
            return null;
        }
        
        public final void setAgreementSignName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAgreementUpdDate() {
            return null;
        }
        
        public final void setAgreementUpdDate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAgreementOrgDate() {
            return null;
        }
        
        public final void setAgreementOrgDate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getVendorContactId() {
            return 0;
        }
        
        public final void setVendorContactId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFirstName() {
            return null;
        }
        
        public final void setFirstName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMiddleName() {
            return null;
        }
        
        public final void setMiddleName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLastName() {
            return null;
        }
        
        public final void setLastName(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getWorkPhone() {
            return null;
        }
        
        public final void setWorkPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDayPhone() {
            return null;
        }
        
        public final void setDayPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDayPhoneExt() {
            return null;
        }
        
        public final void setDayPhoneExt(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getHomePhone() {
            return null;
        }
        
        public final void setHomePhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEvePhone() {
            return null;
        }
        
        public final void setEvePhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEvePhoneExt() {
            return null;
        }
        
        public final void setEvePhoneExt(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCellPhone() {
            return null;
        }
        
        public final void setCellPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmail() {
            return null;
        }
        
        public final void setEmail(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getFax() {
            return null;
        }
        
        public final void setFax(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPrimaryPhone() {
            return null;
        }
        
        public final void setPrimaryPhone(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTextMsg() {
            return null;
        }
        
        public final void setTextMsg(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getAddressId() {
            return 0;
        }
        
        public final void setAddressId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddressLine1() {
            return null;
        }
        
        public final void setAddressLine1(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddressLine2() {
            return null;
        }
        
        public final void setAddressLine2(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCity() {
            return null;
        }
        
        public final void setCity(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getState() {
            return null;
        }
        
        public final void setState(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getZip() {
            return null;
        }
        
        public final void setZip(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCounty() {
            return null;
        }
        
        public final void setCounty(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCountyCode() {
            return null;
        }
        
        public final void setCountyCode(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAddressVerified() {
            return null;
        }
        
        public final void setAddressVerified(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVendorAddress() {
            return null;
        }
        
        public final void setVendorAddress(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final boolean getOnVacation() {
            return false;
        }
        
        public final void setOnVacation(boolean p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVacationStartDate() {
            return null;
        }
        
        public final void setVacationStartDate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVacationEndDate() {
            return null;
        }
        
        public final void setVacationEndDate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVacationNote() {
            return null;
        }
        
        public final void setVacationNote(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEOFlag() {
            return null;
        }
        
        public final void setEOFlag(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEOFlagDes() {
            return null;
        }
        
        public final void setEOFlagDes(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getProfileImageUrl() {
            return null;
        }
        
        public final void setProfileImageUrl(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getProfilePicStatus() {
            return null;
        }
        
        public final void setProfilePicStatus(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLicaencePlate() {
            return null;
        }
        
        public final void setLicaencePlate(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCarMake() {
            return null;
        }
        
        public final void setCarMake(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public Object() {
            super();
        }
    }
}