package com.radian.myradianvaluations.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J.\u0010!\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$j\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&`\'J.\u0010(\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$j\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&`\'J\u0018\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0016J\u0010\u0010-\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0018\u0010.\u001a\u00020\"2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020%H\u0016J.\u00100\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$j\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&`\'J.\u0010\u0013\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$j\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&`\'J.\u0010\u0016\u001a\u00020\"2&\u0010#\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&0$j\u0010\u0012\u0004\u0012\u00020%\u0012\u0006\u0012\u0004\u0018\u00010&`\'J:\u00101\u001a\u00020\"2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\"\u0010#\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u0002050$j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u000205`\'R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e\u00a8\u00066"}, d2 = {"Lcom/radian/myradianvaluations/viewmodel/EODocViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/radian/myradianvaluations/networking/ApiResponseCallBack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiServiceProviderGeneric", "Lcom/radian/myradianvaluations/networking/ApiServiceProviderGeneric;", "licenceMasterResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/LicenceMasterModel;", "getLicenceMasterResponse", "()Landroidx/lifecycle/MutableLiveData;", "setLicenceMasterResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "saveEoDocResponse", "Lcom/radian/myradianvaluations/Response/StatusResponse;", "getSaveEoDocResponse", "setSaveEoDocResponse", "saveLicenceResponse", "getSaveLicenceResponse", "setSaveLicenceResponse", "saveW9DataResponse", "getSaveW9DataResponse", "setSaveW9DataResponse", "uploadImageResponse", "Lcom/radian/myradianvaluations/Response/UploadImageResponse;", "getUploadImageResponse", "setUploadImageResponse", "vendorProfileResponse", "Lcom/radian/myradianvaluations/Response/VendorProfileResponse;", "getVendorProfileResponse", "setVendorProfileResponse", "getLicenceMaster", "", "postParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getVendorProfileDetails", "onError", "returnType", "Lcom/radian/myradianvaluations/networking/ReturnType;", "error", "onPreExecute", "onSuccess", "response", "saveEoDateResponse", "uploadImage", "file", "Lokhttp3/MultipartBody$Part;", "fileName", "Lokhttp3/RequestBody;", "app_DevDebug"})
public final class EODocViewModel extends androidx.lifecycle.ViewModel implements com.radian.myradianvaluations.networking.ApiResponseCallBack {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.UploadImageResponse> uploadImageResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.VendorProfileResponse> vendorProfileResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.LicenceMasterModel> licenceMasterResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> saveLicenceResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> saveW9DataResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> saveEoDocResponse;
    private final com.radian.myradianvaluations.networking.ApiServiceProviderGeneric apiServiceProviderGeneric = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.UploadImageResponse> getUploadImageResponse() {
        return null;
    }
    
    public final void setUploadImageResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.UploadImageResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.VendorProfileResponse> getVendorProfileResponse() {
        return null;
    }
    
    public final void setVendorProfileResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.VendorProfileResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.LicenceMasterModel> getLicenceMasterResponse() {
        return null;
    }
    
    public final void setLicenceMasterResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.LicenceMasterModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getSaveLicenceResponse() {
        return null;
    }
    
    public final void setSaveLicenceResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getSaveW9DataResponse() {
        return null;
    }
    
    public final void setSaveW9DataResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getSaveEoDocResponse() {
        return null;
    }
    
    public final void setSaveEoDocResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    public final void getVendorProfileDetails(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void getLicenceMaster(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void saveLicenceResponse(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void saveW9DataResponse(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void saveEoDateResponse(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void uploadImage(@org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody fileName, @org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, okhttp3.RequestBody> postParams) {
    }
    
    @java.lang.Override()
    public void onPreExecute(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.networking.ReturnType returnType) {
    }
    
    @java.lang.Override()
    public void onSuccess(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.networking.ReturnType returnType, @org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    @java.lang.Override()
    public void onError(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.networking.ReturnType returnType, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    public EODocViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}