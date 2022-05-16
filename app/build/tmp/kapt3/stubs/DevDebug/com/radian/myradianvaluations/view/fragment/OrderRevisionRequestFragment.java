package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0010R\u00020\u00110\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\'"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/OrderRevisionRequestFragment;", "Landroidx/fragment/app/Fragment;", "()V", "classTag", "", "kotlin.jvm.PlatformType", "factory", "Lcom/radian/myradianvaluations/viewmodel/OrderRevisionRequestViewModelFactory;", "itemId", "", "orderDetaiList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "orderRevisionViewModel", "Lcom/radian/myradianvaluations/viewmodel/OrderRevisionRequestViewModel;", "revisionList", "Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$TileOrderRevision;", "Lcom/radian/myradianvaluations/Response/OrderRevisionResponse;", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "getOrderRevision", "", "initViewModel", "observeRevisionData", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setOrderDetailData", "setToolbar", "Companion", "app_DevDebug"})
public final class OrderRevisionRequestFragment extends androidx.fragment.app.Fragment {
    private java.util.ArrayList<com.radian.myradianvaluations.Response.OrderRevisionResponse.TileOrderRevision> revisionList;
    private int itemId = 0;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private final java.lang.String classTag = null;
    private java.util.ArrayList<com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail> orderDetaiList;
    private com.radian.myradianvaluations.viewmodel.OrderRevisionRequestViewModel orderRevisionViewModel;
    private com.radian.myradianvaluations.viewmodel.OrderRevisionRequestViewModelFactory factory;
    public static final com.radian.myradianvaluations.view.fragment.OrderRevisionRequestFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
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
    
    private final void setToolbar() {
    }
    
    private final void initViewModel() {
    }
    
    private final void getOrderRevision() {
    }
    
    private final void observeRevisionData() {
    }
    
    private final void setOrderDetailData() {
    }
    
    public OrderRevisionRequestFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/OrderRevisionRequestFragment$Companion;", "", "()V", "newInstance", "Lcom/radian/myradianvaluations/view/fragment/OrderRevisionRequestFragment;", "itemId", "", "app_DevDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.view.fragment.OrderRevisionRequestFragment newInstance(int itemId) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}