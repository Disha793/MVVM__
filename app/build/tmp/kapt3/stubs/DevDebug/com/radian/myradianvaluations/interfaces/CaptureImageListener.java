package com.radian.myradianvaluations.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/radian/myradianvaluations/interfaces/CaptureImageListener;", "Lcom/otaliastudios/cameraview/CameraListener;", "photofile", "Ljava/io/File;", "faceDetectionActivity", "Lcom/radian/myradianvaluations/view/activity/FaceDetectionActivity;", "(Ljava/io/File;Lcom/radian/myradianvaluations/view/activity/FaceDetectionActivity;)V", "classTag", "", "getClassTag", "()Ljava/lang/String;", "setClassTag", "(Ljava/lang/String;)V", "getFaceDetectionActivity", "()Lcom/radian/myradianvaluations/view/activity/FaceDetectionActivity;", "setFaceDetectionActivity", "(Lcom/radian/myradianvaluations/view/activity/FaceDetectionActivity;)V", "getPhotofile", "()Ljava/io/File;", "setPhotofile", "(Ljava/io/File;)V", "onPictureTaken", "", "result", "Lcom/otaliastudios/cameraview/PictureResult;", "app_DevDebug"})
public final class CaptureImageListener extends com.otaliastudios.cameraview.CameraListener {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String classTag;
    @org.jetbrains.annotations.NotNull()
    private java.io.File photofile;
    @org.jetbrains.annotations.NotNull()
    private com.radian.myradianvaluations.view.activity.FaceDetectionActivity faceDetectionActivity;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClassTag() {
        return null;
    }
    
    public final void setClassTag(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onPictureTaken(@org.jetbrains.annotations.NotNull()
    com.otaliastudios.cameraview.PictureResult result) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getPhotofile() {
        return null;
    }
    
    public final void setPhotofile(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.view.activity.FaceDetectionActivity getFaceDetectionActivity() {
        return null;
    }
    
    public final void setFaceDetectionActivity(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.view.activity.FaceDetectionActivity p0) {
    }
    
    public CaptureImageListener(@org.jetbrains.annotations.NotNull()
    java.io.File photofile, @org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.view.activity.FaceDetectionActivity faceDetectionActivity) {
        super();
    }
}