package com.radian.myradianvaluations.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J.\u0010&\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,J.\u0010\u0012\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,J.\u0010-\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,J.\u0010.\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,J.\u0010/\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,J.\u00100\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,J\u0018\u00101\u001a\u00020\'2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020*H\u0016J\u0010\u00105\u001a\u00020\'2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00106\u001a\u00020\'2\u0006\u00102\u001a\u0002032\u0006\u00107\u001a\u00020*H\u0016J.\u00108\u001a\u00020\'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+0)j\u0010\u0012\u0004\u0012\u00020*\u0012\u0006\u0012\u0004\u0018\u00010+`,R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR \u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000e\u00a8\u00069"}, d2 = {"Lcom/radian/myradianvaluations/viewmodel/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/radian/myradianvaluations/networking/ApiResponseCallBack;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "apiServiceProviderGeneric", "Lcom/radian/myradianvaluations/networking/ApiServiceProviderGeneric;", "appointmentResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/StatusResponse;", "getAppointmentResponse", "()Landroidx/lifecycle/MutableLiveData;", "setAppointmentResponse", "(Landroidx/lifecycle/MutableLiveData;)V", "dashboardData", "Landroidx/lifecycle/LiveData;", "Lcom/radian/myradianvaluations/DashboardResponseNew;", "getDashboardData", "()Landroidx/lifecycle/LiveData;", "dashboardResponse", "docMarkReadResponse", "getDocMarkReadResponse", "setDocMarkReadResponse", "manageOrderResponse", "Lcom/radian/myradianvaluations/Response/ManageOrderResponse;", "getManageOrderResponse", "setManageOrderResponse", "rejectOrderResponse", "getRejectOrderResponse", "setRejectOrderResponse", "revisionMarkReadResponse", "getRevisionMarkReadResponse", "setRevisionMarkReadResponse", "whatsNewResponse", "Lcom/radian/myradianvaluations/Response/WhatsNewResponse;", "getWhatsNewResponse", "setWhatsNewResponse", "addAppointment", "", "postParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getOrderDetail", "getWhatsNewAPI", "markAsReadDoc", "markAsReadRevision", "onError", "returnType", "Lcom/radian/myradianvaluations/networking/ReturnType;", "error", "onPreExecute", "onSuccess", "response", "rejectOrder", "app_DevDebug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel implements com.radian.myradianvaluations.networking.ApiResponseCallBack {
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.DashboardResponseNew> dashboardResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.WhatsNewResponse> whatsNewResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> rejectOrderResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> docMarkReadResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> revisionMarkReadResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> appointmentResponse;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.ManageOrderResponse> manageOrderResponse;
    private final com.radian.myradianvaluations.networking.ApiServiceProviderGeneric apiServiceProviderGeneric = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.WhatsNewResponse> getWhatsNewResponse() {
        return null;
    }
    
    public final void setWhatsNewResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.WhatsNewResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getRejectOrderResponse() {
        return null;
    }
    
    public final void setRejectOrderResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getDocMarkReadResponse() {
        return null;
    }
    
    public final void setDocMarkReadResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getRevisionMarkReadResponse() {
        return null;
    }
    
    public final void setRevisionMarkReadResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> getAppointmentResponse() {
        return null;
    }
    
    public final void setAppointmentResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.ManageOrderResponse> getManageOrderResponse() {
        return null;
    }
    
    public final void setManageOrderResponse(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.ManageOrderResponse> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.radian.myradianvaluations.DashboardResponseNew> getDashboardData() {
        return null;
    }
    
    public final void getDashboardData(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void getWhatsNewAPI(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void rejectOrder(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void markAsReadDoc(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void markAsReadRevision(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void getOrderDetail(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParams) {
    }
    
    public final void addAppointment(@org.jetbrains.annotations.NotNull()
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
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}