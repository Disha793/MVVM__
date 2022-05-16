package com.radian.myradianvaluations.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Lcom/radian/myradianvaluations/utils/LoadingDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "Companion", "app_DevDebug"})
public final class LoadingDialog extends android.app.Dialog {
    private static android.app.Dialog mainDialog;
    public static final com.radian.myradianvaluations.utils.LoadingDialog.Companion Companion = null;
    
    public LoadingDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/radian/myradianvaluations/utils/LoadingDialog$Companion;", "", "()V", "mainDialog", "Landroid/app/Dialog;", "dismissDialog", "", "show", "context", "Landroid/content/Context;", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "app_DevDebug"})
    public static final class Companion {
        
        public final void show(@org.jetbrains.annotations.NotNull()
        android.content.Context context, boolean cancelable) {
        }
        
        public final void show(@org.jetbrains.annotations.NotNull()
        android.content.Context context, boolean cancelable, @org.jetbrains.annotations.Nullable()
        android.content.DialogInterface.OnCancelListener cancelListener) {
        }
        
        /**
         * Dismiss dialog.
         */
        public final void dismissDialog() {
        }
        
        private Companion() {
            super();
        }
    }
}