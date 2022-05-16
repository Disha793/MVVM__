package com.radian.myradianvaluations.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J.\u0010\u0018\u001a\u00020\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bj\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001eJ6\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b2&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bj\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001eJ\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001cH\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u001cH\u0016J6\u0010\'\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000b2&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001bj\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d`\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010\u00a8\u0006("}, d2 = {"Lcom/radian/myradianvaluations/viewmodel/PasscodeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/radian/myradianvaluations/networking/ApiResponseCallBack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiServiceProviderGeneric", "Lcom/radian/myradianvaluations/networking/ApiServiceProviderGeneric;", "getContext", "()Landroid/content/Context;", "loginResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/LoginResponse;", "getLoginResponse", "()Landroidx/lifecycle/MutableLiveData;", "setLoginResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "otpResponse", "Lcom/radian/myradianvaluations/Response/OtpResponse;", "getOtpResponse", "setOtpResponse", "verifyotpResponse", "getVerifyotpResponse", "setVerifyotpResponse", "callSignIn", "", "postParam", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "generateOtp", "onError", "returnType", "Lcom/radian/myradianvaluations/networking/ReturnType;", "error", "onPreExecute", "onSuccess", "response", "verifyOtp", "app_DevDebug"})
public final class PasscodeViewModel extends androidx.lifecycle.ViewModel implements com.radian.myradianvaluations.networking.ApiResponseCallBack {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> otpResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> verifyotpResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.LoginResponse> loginResponse;
    private final com.radian.myradianvaluations.networking.ApiServiceProviderGeneric apiServiceProviderGeneric = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> getOtpResponse() {
        return null;
    }
    
    public final void setOtpResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> getVerifyotpResponse() {
        return null;
    }
    
    public final void setVerifyotpResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.LoginResponse> getLoginResponse() {
        return null;
    }
    
    public final void setLoginResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.LoginResponse> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> generateOtp(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParam) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OtpResponse> verifyOtp(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParam) {
        return null;
    }
    
    public final void callSignIn(@org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public PasscodeViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}