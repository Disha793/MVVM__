package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010&\u001a\u00020!2\b\u0010\'\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010(\u001a\u0004\u0018\u00010\u001b2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006/"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/SettingsFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "classTag", "", "kotlin.jvm.PlatformType", "getClassTag", "()Ljava/lang/String;", "factory", "Lcom/radian/myradianvaluations/viewmodel/SettingsViewModelFactory;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseParams", "Landroid/os/Bundle;", "getFirebaseParams", "()Landroid/os/Bundle;", "postParam", "Ljava/util/HashMap;", "", "getPostParam", "()Ljava/util/HashMap;", "setPostParam", "(Ljava/util/HashMap;)V", "settingsViewModel", "Lcom/radian/myradianvaluations/viewmodel/SettingsViewModel;", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "getNotificatnStatus", "", "initViewModel", "observeNotificationData", "onActivityCreated", "savedInstanceState", "onClick", "p0", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "saveNotiStatus", "setToolbar", "app_DevDebug"})
public final class SettingsFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private com.radian.myradianvaluations.viewmodel.SettingsViewModelFactory factory;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Bundle firebaseParams = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.HashMap<java.lang.String, java.lang.Object> postParam;
    private final java.lang.String classTag = null;
    private com.radian.myradianvaluations.viewmodel.SettingsViewModel settingsViewModel;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.os.Bundle getFirebaseParams() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, java.lang.Object> getPostParam() {
        return null;
    }
    
    public final void setPostParam(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> p0) {
    }
    
    public final java.lang.String getClassTag() {
        return null;
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
    
    private final void observeNotificationData() {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViewModel() {
    }
    
    private final void setToolbar() {
    }
    
    private final void getNotificatnStatus() {
    }
    
    private final void saveNotiStatus() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    public SettingsFragment() {
        super();
    }
}