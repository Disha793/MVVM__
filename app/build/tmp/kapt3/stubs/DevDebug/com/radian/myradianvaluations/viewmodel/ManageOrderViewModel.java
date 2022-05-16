package com.radian.myradianvaluations.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J.\u0010\u0013\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u0019J.\u0010\u001a\u001a\u00020\u00142&\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016j\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0018`\u0019J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000e\u00a8\u0006\""}, d2 = {"Lcom/radian/myradianvaluations/viewmodel/ManageOrderViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/radian/myradianvaluations/networking/ApiResponseCallBack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiServiceProviderGeneric", "Lcom/radian/myradianvaluations/networking/ApiServiceProviderGeneric;", "manageOrderResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/ManageOrderResponse;", "getManageOrderResponse", "()Landroidx/lifecycle/MutableLiveData;", "setManageOrderResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "markOrderResponse", "Lcom/radian/myradianvaluations/Response/StatusResponse;", "getMarkOrderResponse", "setMarkOrderResponse", "getOrderDetail", "", "postParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "markAsReadRevision", "onError", "returnType", "Lcom/radian/myradianvaluations/networking/ReturnType;", "error", "onPreExecute", "onSuccess", "response", "app_DevDebug"})
public final class ManageOrderViewModel extends androidx.lifecycle.ViewModel implements com.radian.myradianvaluations.networking.ApiResponseCallBack {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.ManageOrderResponse> manageOrderResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> markOrderResponse;
    private final com.radian.myradianvaluations.networking.ApiServiceProviderGeneric apiServiceProviderGeneric = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.ManageOrderResponse> getManageOrderResponse() {
        return null;
    }
    
    public final void setManageOrderResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.ManageOrderResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getMarkOrderResponse() {
        return null;
    }
    
    public final void setMarkOrderResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    public final void getOrderDetail(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void markAsReadRevision(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
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
    
    public ManageOrderViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}