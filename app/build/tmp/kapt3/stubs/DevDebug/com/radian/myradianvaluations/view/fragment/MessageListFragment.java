package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020!H\u0002J\u0012\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010)\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010.\u001a\u00020!H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020!H\u0002J\b\u00102\u001a\u00020!H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u00063"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/MessageListFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "classTag", "", "kotlin.jvm.PlatformType", "countMessageTitle", "factory", "Lcom/radian/myradianvaluations/viewmodel/MessageListViewModelFactory;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setFirebaseAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "firebaseParams", "Landroid/os/Bundle;", "messageList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$Order;", "messageListViewModel", "Lcom/radian/myradianvaluations/viewmodel/MessageListViewModel;", "postParam", "Ljava/util/HashMap;", "", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "getMessageList", "", "initViewModel", "manageUI", "observeMessageListData", "onActivityCreated", "savedInstanceState", "onClick", "p0", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "setMessageCount", "count", "setToolbar", "showNoMsg", "app_DevDebug"})
public final class MessageListFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private java.util.HashMap<java.lang.String, java.lang.Object> postParam;
    private java.lang.String countMessageTitle = "";
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private final android.os.Bundle firebaseParams = null;
    private com.radian.myradianvaluations.viewmodel.MessageListViewModel messageListViewModel;
    private com.radian.myradianvaluations.viewmodel.MessageListViewModelFactory factory;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private final java.lang.String classTag = null;
    private final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> messageList = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.analytics.FirebaseAnalytics getFirebaseAnalytics() {
        return null;
    }
    
    public final void setFirebaseAnalytics(@org.jetbrains.annotations.NotNull()
    com.google.firebase.analytics.FirebaseAnalytics p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView$app_DevDebug() {
        return null;
    }
    
    public final void setView$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViewModel() {
    }
    
    private final void observeMessageListData() {
    }
    
    private final void manageUI() {
    }
    
    private final void setMessageCount(java.lang.String count) {
    }
    
    private final void setToolbar() {
    }
    
    public final void getMessageList() {
    }
    
    private final void showNoMsg() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    public MessageListFragment() {
        super();
    }
}