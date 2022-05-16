package com.radian.myradianvaluations.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J.\u0010\r\u001a\u00020\u000f2&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011j\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013`\u0014J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001c"}, d2 = {"Lcom/radian/myradianvaluations/viewmodel/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/radian/myradianvaluations/networking/ApiResponseCallBack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiServiceProviderGeneric", "Lcom/radian/myradianvaluations/networking/ApiServiceProviderGeneric;", "mlLoginResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/StatusResponse;", "userStatus", "Landroidx/lifecycle/LiveData;", "getUserStatus", "()Landroidx/lifecycle/LiveData;", "", "postParam", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "onError", "returnType", "Lcom/radian/myradianvaluations/networking/ReturnType;", "error", "onPreExecute", "onSuccess", "response", "app_DevDebug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel implements com.radian.myradianvaluations.networking.ApiResponseCallBack {
    private final com.radian.myradianvaluations.networking.ApiServiceProviderGeneric apiServiceProviderGeneric = null;
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> mlLoginResponse;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.radian.myradianvaluations.Response.StatusResponse> getUserStatus() {
        return null;
    }
    
    public final void getUserStatus(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParam) {
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
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}