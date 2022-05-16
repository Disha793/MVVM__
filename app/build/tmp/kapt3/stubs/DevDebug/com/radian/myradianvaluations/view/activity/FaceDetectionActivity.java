package com.radian.myradianvaluations.view.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/radian/myradianvaluations/view/activity/FaceDetectionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/otaliastudios/cameraview/frame/FrameProcessor;", "()V", "cameraFacing", "Lcom/otaliastudios/cameraview/controls/Facing;", "cameraListener", "Lcom/otaliastudios/cameraview/CameraListener;", "getCameraListener$app_DevDebug", "()Lcom/otaliastudios/cameraview/CameraListener;", "setCameraListener$app_DevDebug", "(Lcom/otaliastudios/cameraview/CameraListener;)V", "isFaceDetected", "", "pictureFile", "Ljava/io/File;", "getPictureFile$app_DevDebug", "()Ljava/io/File;", "setPictureFile$app_DevDebug", "(Ljava/io/File;)V", "createImageFile", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "process", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "uploadProfile", "app_DevDebug"})
public final class FaceDetectionActivity extends androidx.appcompat.app.AppCompatActivity implements com.otaliastudios.cameraview.frame.FrameProcessor {
    private com.otaliastudios.cameraview.controls.Facing cameraFacing = com.otaliastudios.cameraview.controls.Facing.FRONT;
    @org.jetbrains.annotations.NotNull()
    public com.otaliastudios.cameraview.CameraListener cameraListener;
    @org.jetbrains.annotations.NotNull()
    public java.io.File pictureFile;
    private boolean isFaceDetected = false;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.otaliastudios.cameraview.CameraListener getCameraListener$app_DevDebug() {
        return null;
    }
    
    public final void setCameraListener$app_DevDebug(@org.jetbrains.annotations.NotNull()
    com.otaliastudios.cameraview.CameraListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getPictureFile$app_DevDebug() {
        return null;
    }
    
    public final void setPictureFile$app_DevDebug(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @java.lang.Override()
    public void process(@org.jetbrains.annotations.NotNull()
    com.otaliastudios.cameraview.frame.Frame frame) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void uploadProfile() {
    }
    
    private final java.io.File createImageFile() {
        return null;
    }
    
    public FaceDetectionActivity() {
        super();
    }
}