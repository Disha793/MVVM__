package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J(\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u00108\u001a\u000202H\u0002J\u001a\u00109\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\'H\u0002J\b\u0010;\u001a\u000202H\u0002J\u0012\u0010<\u001a\u0002022\b\u0010=\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010>\u001a\u000202H\u0002J\u0012\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010\u001fH\u0016J\"\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001a\u0010F\u001a\u0002022\b\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020\u0006H\u0016J\u0012\u0010F\u001a\u0002022\b\u0010J\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010K\u001a\u0004\u0018\u00010\u00142\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010@\u001a\u0004\u0018\u00010\u001fH\u0016J+\u0010P\u001a\u0002022\u0006\u0010B\u001a\u00020\u00062\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u000b0R2\u0006\u0010S\u001a\u00020TH\u0016\u00a2\u0006\u0002\u0010UJ\b\u0010V\u001a\u000202H\u0002J\b\u0010W\u001a\u000202H\u0002J\b\u0010X\u001a\u000202H\u0002J\b\u0010Y\u001a\u000202H\u0002J\b\u0010Z\u001a\u000202H\u0002J\b\u0010[\u001a\u000202H\u0002J\u0012\u0010\\\u001a\u0002022\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0010\u0010]\u001a\u0002022\u0006\u0010D\u001a\u00020^H\u0002J\u0010\u0010_\u001a\u0002022\u0006\u0010`\u001a\u000204H\u0002J\b\u0010a\u001a\u000202H\u0002J\u0010\u0010b\u001a\u0002022\u0006\u0010c\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u00020\u0014X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018\u00a8\u0006d"}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/view/View$OnClickListener;", "()V", "REQUEST_FOR_CAMERA", "", "REQUEST_FOR_GALLERY", "REQUEST_PERMISSION_ACESS", "REQ_FACE_DETECTION", "TAG", "", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext$app_DevDebug", "()Landroid/content/Context;", "setContext$app_DevDebug", "(Landroid/content/Context;)V", "dialogView", "Landroid/view/View;", "getDialogView$app_DevDebug", "()Landroid/view/View;", "setDialogView$app_DevDebug", "(Landroid/view/View;)V", "factory", "Lcom/radian/myradianvaluations/viewmodel/ProfileViewModelFactory;", "fileUriToUpload", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseParams", "Landroid/os/Bundle;", "photoFile", "Ljava/io/File;", "getPhotoFile", "()Ljava/io/File;", "setPhotoFile", "(Ljava/io/File;)V", "photoURI", "Landroid/net/Uri;", "getPhotoURI$app_DevDebug", "()Landroid/net/Uri;", "setPhotoURI$app_DevDebug", "(Landroid/net/Uri;)V", "profileViewModel", "Lcom/radian/myradianvaluations/viewmodel/ProfileViewModel;", "view", "getView$app_DevDebug", "setView$app_DevDebug", "detectFace", "", "myBitmap", "Landroid/graphics/Bitmap;", "imgProfile", "Landroid/widget/ImageView;", "faceDetectionCameraImageView", "getMyProfile", "getRealPathFromURI", "contentUri", "initViewModel", "loadProfileImage", "url", "observeProfileData", "onActivityCreated", "savedInstanceState", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "p0", "Landroid/content/DialogInterface;", "position", "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "openCamera", "openDialog", "openGallery", "requestPermission", "saveMyProfile", "setCameraImage", "setGalleryImage", "setProfile", "Lcom/radian/myradianvaluations/Response/ProfileResponse$Object;", "showImageIndialog", "bitmap", "showProfileInfoDialog", "uploadProfileImage", "fileUri", "app_DevDebug"})
public final class ProfileFragment extends androidx.fragment.app.Fragment implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener {
    private java.lang.String TAG;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    @org.jetbrains.annotations.NotNull()
    public android.net.Uri photoURI;
    @org.jetbrains.annotations.NotNull()
    public java.io.File photoFile;
    private com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics;
    private final android.os.Bundle firebaseParams = null;
    @org.jetbrains.annotations.NotNull()
    public android.view.View dialogView;
    private com.radian.myradianvaluations.viewmodel.ProfileViewModel profileViewModel;
    private com.radian.myradianvaluations.viewmodel.ProfileViewModelFactory factory;
    private java.lang.String fileUriToUpload;
    @org.jetbrains.annotations.NotNull()
    public android.content.Context context;
    private final int REQUEST_FOR_CAMERA = 101;
    private final int REQUEST_FOR_GALLERY = 102;
    private final int REQUEST_PERMISSION_ACESS = 103;
    private final int REQ_FACE_DETECTION = 104;
    private java.util.HashMap _$_findViewCache;
    
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
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getDialogView$app_DevDebug() {
        return null;
    }
    
    public final void setDialogView$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext$app_DevDebug() {
        return null;
    }
    
    public final void setContext$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void initViewModel() {
    }
    
    private final void observeProfileData() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.content.DialogInterface p0, int position) {
    }
    
    private final void showProfileInfoDialog() {
    }
    
    private final void loadProfileImage(java.lang.String url) {
    }
    
    private final void detectFace(android.graphics.Bitmap myBitmap, android.widget.ImageView imgProfile, android.widget.ImageView faceDetectionCameraImageView, android.view.View dialogView) {
    }
    
    private final void requestPermission() {
    }
    
    private final void openDialog() {
    }
    
    private final void openCamera() {
    }
    
    private final void openGallery() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void setCameraImage() {
    }
    
    private final void setGalleryImage(android.content.Intent data) {
    }
    
    private final void showImageIndialog(android.graphics.Bitmap bitmap) {
    }
    
    private final void uploadProfileImage(java.lang.String fileUri) {
    }
    
    private final void getMyProfile() {
    }
    
    private final void saveMyProfile() {
    }
    
    private final void setProfile(com.radian.myradianvaluations.Response.ProfileResponse.Object data) {
    }
    
    private final java.lang.String getRealPathFromURI(android.content.Context context, android.net.Uri contentUri) {
        return null;
    }
    
    public ProfileFragment() {
        super();
    }
}