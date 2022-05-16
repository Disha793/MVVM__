package com.radian.myradianvaluations.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\n\u001a\u0012\u0010\r\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n\u001a\u0012\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n\u00a8\u0006\u0011"}, d2 = {"getCompatColor", "", "Landroid/content/Context;", "colorInt", "getCompatDrawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "isNetworkStatusAvailable", "", "toBase64", "", "Landroid/graphics/Bitmap;", "toBitmapFromBase64", "toastLong", "", "message", "toastShort", "app_DevDebug"})
public final class ContextExtensionKt {
    
    /**
     * Checks network connectivity
     */
    public static final boolean isNetworkStatusAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isNetworkStatusAvailable) {
        return false;
    }
    
    /**
     * Get color from resources
     */
    public static final int getCompatColor(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getCompatColor, @androidx.annotation.ColorRes()
    int colorInt) {
        return 0;
    }
    
    /**
     * Get drawable from resources
     */
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.drawable.Drawable getCompatDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getCompatDrawable, @androidx.annotation.DrawableRes()
    int drawableRes) {
        return null;
    }
    
    /**
     * Toast
     */
    public static final void toastShort(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toastShort, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public static final void toastLong(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toastLong, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toBase64(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap $this$toBase64) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.Bitmap toBitmapFromBase64(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$toBitmapFromBase64) {
        return null;
    }
}