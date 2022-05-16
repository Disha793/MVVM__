package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0016H\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000205H\u0002J\b\u00108\u001a\u000205H\u0002J\u0012\u00109\u001a\u0002052\b\u0010:\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010;\u001a\u0002052\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010@\u001a\u0002052\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0006H\u0016J\u0012\u0010@\u001a\u0002052\b\u0010D\u001a\u0004\u0018\u00010)H\u0016J&\u0010E\u001a\u0004\u0018\u00010)2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010:\u001a\u0004\u0018\u00010\u0014H\u0016J+\u0010J\u001a\u0002052\u0006\u0010<\u001a\u00020\u00062\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\n0L2\u0006\u0010M\u001a\u00020NH\u0016\u00a2\u0006\u0002\u0010OJ\b\u0010P\u001a\u000205H\u0002J\b\u0010Q\u001a\u000205H\u0002J\b\u0010R\u001a\u000205H\u0002J\b\u0010S\u001a\u000205H\u0002J\b\u0010T\u001a\u000205H\u0002J\u0012\u0010U\u001a\u0002052\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010V\u001a\u000205H\u0002J\u0010\u0010W\u001a\u0002052\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001a\u0010(\u001a\u00020)X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006X"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/W9DocFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "()V", "REQUEST_FOR_CAMERA", "", "REQUEST_FOR_GALLERY", "REQUEST_PERMISSION_ACESS", "TAG", "", "kotlin.jvm.PlatformType", "eoDocViewModel", "Lcom/radian/myradianvaluations/viewmodel/EODocViewModel;", "factory", "Lcom/radian/myradianvaluations/viewmodel/EODocViewModelFactory;", "fileUri", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseParams", "Landroid/os/Bundle;", "photoFile", "Ljava/io/File;", "getPhotoFile", "()Ljava/io/File;", "setPhotoFile", "(Ljava/io/File;)V", "photoURI", "Landroid/net/Uri;", "getPhotoURI$app_DevDebug", "()Landroid/net/Uri;", "setPhotoURI$app_DevDebug", "(Landroid/net/Uri;)V", "postParam", "Ljava/util/HashMap;", "", "getPostParam$app_DevDebug", "()Ljava/util/HashMap;", "setPostParam$app_DevDebug", "(Ljava/util/HashMap;)V", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "w9List", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/VendorProfileResponse$Data;", "checkValidation", "", "createImageFile", "displayThumbnail", "", "getw9Data", "initViewModel", "observeW9DocData", "onActivityCreated", "savedInstanceState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "dialog", "Landroid/content/DialogInterface;", "position", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openCamera", "openGallery", "requestPermission", "setCameraImage", "setData", "setGalleryImage", "submitData", "uploadDoc", "app_DevDebug"})
public final class W9DocFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private java.util.HashMap<java.lang.String, java.lang.Object> postParam;
    private com.radian.myradianvaluations.viewmodel.EODocViewModel eoDocViewModel;
    private com.radian.myradianvaluations.viewmodel.EODocViewModelFactory factory;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private final int REQUEST_FOR_CAMERA = 101;
    private final int REQUEST_FOR_GALLERY = 102;
    private final int REQUEST_PERMISSION_ACESS = 103;
    private final java.util.ArrayList<com.radian.myradianvaluations.Response.VendorProfileResponse.Data> w9List = null;
    @org.jetbrains.annotations.NotNull()
    public android.net.Uri photoURI;
    @org.jetbrains.annotations.NotNull()
    public java.io.File photoFile;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private final java.lang.String TAG = null;
    private final android.os.Bundle firebaseParams = null;
    private java.lang.String fileUri = "";
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.HashMap<java.lang.String, java.lang.Object> getPostParam$app_DevDebug() {
        return null;
    }
    
    public final void setPostParam$app_DevDebug(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView$app_DevDebug() {
        return null;
    }
    
    public final void setView$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getPhotoURI$app_DevDebug() {
        return null;
    }
    
    public final void setPhotoURI$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getPhotoFile() {
        return null;
    }
    
    public final void setPhotoFile(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
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
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.content.DialogInterface dialog, int position) {
    }
    
    private final void observeW9DocData() {
    }
    
    private final void getw9Data() {
    }
    
    private final boolean checkValidation() {
        return false;
    }
    
    private final void submitData() {
    }
    
    private final void setData() {
    }
    
    private final void requestPermission() {
    }
    
    private final void uploadDoc(java.lang.String fileUri) {
    }
    
    private final void openCamera() {
    }
    
    private final void openGallery() {
    }
    
    private final java.io.File createImageFile() {
        return null;
    }
    
    private final void setCameraImage() {
    }
    
    private final void displayThumbnail() {
    }
    
    private final void setGalleryImage(android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public W9DocFragment() {
        super();
    }
}