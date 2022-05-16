package com.radian.myradianvaluations.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J.\u0010\u0017\u001a\u00020\u00182&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aj\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c`\u001dJ.\u0010\u001e\u001a\u00020\u00182&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aj\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c`\u001dJ\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001bH\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020\u001bH\u0016JB\u0010&\u001a\u00020\u00182\u0016\u0010\'\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*2\"\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020+0\u001aj\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020+`\u001dR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e\u00a8\u0006,"}, d2 = {"Lcom/radian/myradianvaluations/viewmodel/PhotoUploadViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/radian/myradianvaluations/networking/ApiResponseCallBack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiServiceProviderGeneric", "Lcom/radian/myradianvaluations/networking/ApiServiceProviderGeneric;", "categoryResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse;", "getCategoryResponse", "()Landroidx/lifecycle/MutableLiveData;", "setCategoryResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "deletePhotosResponse", "Lcom/radian/myradianvaluations/Response/DeletePhotosResponse;", "getDeletePhotosResponse", "setDeletePhotosResponse", "uploadPhotosResponse", "Lcom/radian/myradianvaluations/Response/UploadImageResponse;", "getUploadPhotosResponse", "setUploadPhotosResponse", "deletePhotos", "", "postParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getCategoryList", "onError", "returnType", "Lcom/radian/myradianvaluations/networking/ReturnType;", "error", "onPreExecute", "onSuccess", "response", "uploadPhoto", "file", "Ljava/util/ArrayList;", "Lokhttp3/MultipartBody$Part;", "Lkotlin/collections/ArrayList;", "Lokhttp3/RequestBody;", "app_DevDebug"})
public final class PhotoUploadViewModel extends androidx.lifecycle.ViewModel implements com.radian.myradianvaluations.networking.ApiResponseCallBack {
    private final com.radian.myradianvaluations.networking.ApiServiceProviderGeneric apiServiceProviderGeneric = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse> categoryResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.DeletePhotosResponse> deletePhotosResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.UploadImageResponse> uploadPhotosResponse;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse> getCategoryResponse() {
        return null;
    }
    
    public final void setCategoryResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.DeletePhotosResponse> getDeletePhotosResponse() {
        return null;
    }
    
    public final void setDeletePhotosResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.DeletePhotosResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.UploadImageResponse> getUploadPhotosResponse() {
        return null;
    }
    
    public final void setUploadPhotosResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.UploadImageResponse> p0) {
    }
    
    public final void getCategoryList(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void deletePhotos(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void uploadPhoto(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<okhttp3.MultipartBody.Part> file, @org.jetbrains.annotations.NotNull()
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
    
    public PhotoUploadViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}