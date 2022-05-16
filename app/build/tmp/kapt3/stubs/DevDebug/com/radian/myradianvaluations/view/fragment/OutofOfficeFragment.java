package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010(\u001a\u00020\u001eH\u0002J\u0006\u0010)\u001a\u00020\u001eJ\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\b0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006-"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/OutofOfficeFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "cal", "Ljava/util/Calendar;", "dateListener", "Landroid/app/DatePickerDialog$OnDateSetListener;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseParams", "Landroid/os/Bundle;", "outOfficeViewModel", "Lcom/radian/myradianvaluations/viewmodel/OutOfficeViewModel;", "tag", "", "tagEnd", "tagStrt", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "isValid", "", "observeOutOfficeData", "", "onActivityCreated", "savedInstanceState", "onClick", "p0", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "saveVendorVacationInfo", "setToolbar", "showDatePickerDialog", "minDate", "", "app_DevDebug"})
public final class OutofOfficeFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private java.util.Calendar cal;
    private final int tagStrt = 100;
    private final int tagEnd = 101;
    private int tag = 0;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private final java.lang.String TAG = null;
    private android.app.DatePickerDialog.OnDateSetListener dateListener;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private final android.os.Bundle firebaseParams = null;
    private com.radian.myradianvaluations.viewmodel.OutOfficeViewModel outOfficeViewModel;
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
    
    public final void setToolbar() {
    }
    
    private final void observeOutOfficeData() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View p0) {
    }
    
    private final void saveVendorVacationInfo() {
    }
    
    private final boolean isValid() {
        return false;
    }
    
    private final void showDatePickerDialog(long minDate) {
    }
    
    public OutofOfficeFragment() {
        super();
    }
}