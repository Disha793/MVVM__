package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J(\u0010$\u001a\u00020!2\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`%2\u0006\u0010&\u001a\u00020\u0015H\u0002J\b\u0010\'\u001a\u00020!H\u0002J\u0012\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010,\u001a\u0004\u0018\u00010\u001b2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010)\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u00101\u001a\u00020!H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u00063"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/OrderDocumentListFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "classTag", "", "kotlin.jvm.PlatformType", "docList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/OrderDocResponse$TileOrder;", "factory", "Lcom/radian/myradianvaluations/viewmodel/OrderDocumentListViewModelFactory;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setFirebaseAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "firebaseParams", "Landroid/os/Bundle;", "itemId", "", "orderDetail", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "orderDocumentListViewModel", "Lcom/radian/myradianvaluations/viewmodel/OrderDocumentListViewModel;", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "getDocuments", "", "initViewModel", "listItemClick", "markAsRead", "Lkotlin/collections/ArrayList;", "position", "observeData", "onActivityCreated", "savedInstanceState", "onClick", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setToolbar", "Companion", "app_DevDebug"})
public final class OrderDocumentListFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private final java.lang.String classTag = null;
    private int itemId = 0;
    private java.util.ArrayList<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> docList;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private final android.os.Bundle firebaseParams = null;
    private com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail orderDetail;
    private com.radian.myradianvaluations.viewmodel.OrderDocumentListViewModel orderDocumentListViewModel;
    private com.radian.myradianvaluations.viewmodel.OrderDocumentListViewModelFactory factory;
    public static final com.radian.myradianvaluations.view.fragment.OrderDocumentListFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView$app_DevDebug() {
        return null;
    }
    
    public final void setView$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.analytics.FirebaseAnalytics getFirebaseAnalytics() {
        return null;
    }
    
    public final void setFirebaseAnalytics(@org.jetbrains.annotations.NotNull()
    com.google.firebase.analytics.FirebaseAnalytics p0) {
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
    
    private final void setToolbar() {
    }
    
    private final void listItemClick() {
    }
    
    private final void observeData() {
    }
    
    private final void getDocuments() {
    }
    
    private final void markAsRead(java.util.ArrayList<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> docList, int position) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    public OrderDocumentListFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/OrderDocumentListFragment$Companion;", "", "()V", "newInstance", "Lcom/radian/myradianvaluations/view/fragment/OrderDocumentListFragment;", "itemId", "", "app_DevDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.view.fragment.OrderDocumentListFragment newInstance(int itemId) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}