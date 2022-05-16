package com.radian.myradianvaluations.view.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001fH\u0003J\b\u0010#\u001a\u00020!H\u0003J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010\'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0015J\b\u0010*\u001a\u00020!H\u0014J\u0010\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020!H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u00100\u001a\u000201H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/radian/myradianvaluations/view/activity/CameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "Landroid/location/LocationListener;", "()V", "binding", "Lcom/radian/myradianvaluations/databinding/ActivityCameraBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "currentLatitude", "", "currentListPosition", "", "currentLongitude", "imageCapture", "Landroidx/camera/core/ImageCapture;", "itemId", "listCategories", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$Data;", "listUploadedPhotos", "Lcom/radian/myradianvaluations/Response/UploadedPhotos;", "locationManager", "Landroid/location/LocationManager;", "locationPermissionCode", "mContext", "Landroid/content/Context;", "outputDirectory", "Ljava/io/File;", "getLocation", "", "getOutputDirectory", "init", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLocationChanged", "loc", "Landroid/location/Location;", "startCamera", "takePhoto", "photoCategory", "", "app_DevDebug"})
public final class CameraActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener, android.location.LocationListener {
    private int itemId = 0;
    private android.location.LocationManager locationManager;
    private com.radian.myradianvaluations.databinding.ActivityCameraBinding binding;
    private android.content.Context mContext;
    private androidx.camera.core.ImageCapture imageCapture;
    private java.io.File outputDirectory;
    private java.util.concurrent.ExecutorService cameraExecutor;
    private java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> listCategories;
    private java.util.ArrayList<com.radian.myradianvaluations.Response.UploadedPhotos> listUploadedPhotos;
    private int currentListPosition = 0;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<androidx.constraintlayout.widget.ConstraintLayout> bottomSheetBehavior;
    private final int locationPermissionCode = 2;
    private double currentLongitude = 0.0;
    private double currentLatitude = 0.0;
    private java.util.HashMap _$_findViewCache;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    private final void init() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.LOLLIPOP)
    private final java.io.File getOutputDirectory() {
        return null;
    }
    
    private final void takePhoto(java.lang.String photoCategory) {
    }
    
    private final void startCamera() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void getLocation() {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.NotNull()
    android.location.Location loc) {
    }
    
    public CameraActivity() {
        super();
    }
}