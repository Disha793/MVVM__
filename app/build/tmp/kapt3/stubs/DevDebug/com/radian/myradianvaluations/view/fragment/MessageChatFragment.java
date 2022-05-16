package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010/\u001a\u000200J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u000200H\u0002J\b\u00103\u001a\u000200H\u0002J\u0012\u00104\u001a\u0002002\b\u00105\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u00106\u001a\u0002002\b\u00107\u001a\u0004\u0018\u00010*H\u0016J&\u00108\u001a\u0004\u0018\u00010*2\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u00105\u001a\u0004\u0018\u00010\u001aH\u0016J\u0006\u0010=\u001a\u000200J\b\u0010>\u001a\u000200H\u0002R$\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006@"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/MessageChatFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "chatList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/MessageChatResponse$TileOrderNote;", "Lcom/radian/myradianvaluations/Response/MessageChatResponse;", "getChatList", "()Ljava/util/ArrayList;", "setChatList", "(Ljava/util/ArrayList;)V", "classTag", "", "kotlin.jvm.PlatformType", "getClassTag", "()Ljava/lang/String;", "factory", "Lcom/radian/myradianvaluations/viewmodel/MessageChatViewModelFactory;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebaseAnalytics", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "setFirebaseAnalytics", "(Lcom/google/firebase/analytics/FirebaseAnalytics;)V", "firebaseParams", "Landroid/os/Bundle;", "getFirebaseParams", "()Landroid/os/Bundle;", "itemId", "", "getItemId", "()I", "setItemId", "(I)V", "messageChatViewModel", "Lcom/radian/myradianvaluations/viewmodel/MessageChatViewModel;", "orderId", "getOrderId", "setOrderId", "(Ljava/lang/String;)V", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "getMessageChat", "", "initViewModel", "manageUI", "observeChatData", "onActivityCreated", "savedInstanceState", "onClick", "p0", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "sendMessageChat", "setToolbar", "Companion", "app_DevDebug"})
public final class MessageChatFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String orderId = "0";
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private int itemId = 0;
    private final java.lang.String classTag = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.radian.myradianvaluations.Response.MessageChatResponse.TileOrderNote> chatList;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Bundle firebaseParams = null;
    private com.radian.myradianvaluations.viewmodel.MessageChatViewModel messageChatViewModel;
    private com.radian.myradianvaluations.viewmodel.MessageChatViewModelFactory factory;
    @org.jetbrains.annotations.NotNull()
    private static java.lang.String tagOrderId = "orderid";
    public static final com.radian.myradianvaluations.view.fragment.MessageChatFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getOrderId() {
        return null;
    }
    
    public final void setOrderId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView$app_DevDebug() {
        return null;
    }
    
    public final void setView$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    public final int getItemId() {
        return 0;
    }
    
    public final void setItemId(int p0) {
    }
    
    public final java.lang.String getClassTag() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.MessageChatResponse.TileOrderNote> getChatList() {
        return null;
    }
    
    public final void setChatList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.MessageChatResponse.TileOrderNote> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.analytics.FirebaseAnalytics getFirebaseAnalytics() {
        return null;
    }
    
    public final void setFirebaseAnalytics(@org.jetbrains.annotations.NotNull()
    com.google.firebase.analytics.FirebaseAnalytics p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Bundle getFirebaseParams() {
        return null;
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
    
    private final void observeChatData() {
    }
    
    private final void initViewModel() {
    }
    
    private final void manageUI() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    private final void setToolbar() {
    }
    
    public final void getMessageChat() {
    }
    
    public final void sendMessageChat() {
    }
    
    public MessageChatFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/MessageChatFragment$Companion;", "", "()V", "tagOrderId", "", "getTagOrderId", "()Ljava/lang/String;", "setTagOrderId", "(Ljava/lang/String;)V", "newInstance", "Lcom/radian/myradianvaluations/view/fragment/MessageChatFragment;", "orderId", "itemId", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/radian/myradianvaluations/view/fragment/MessageChatFragment;", "app_DevDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTagOrderId() {
            return null;
        }
        
        public final void setTagOrderId(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.view.fragment.MessageChatFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String orderId, @org.jetbrains.annotations.Nullable()
        java.lang.Integer itemId) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}