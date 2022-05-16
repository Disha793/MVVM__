package com.radian.myradianvaluations.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/radian/myradianvaluations/repository/SettingsRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "notiStatusResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/NotiStatusResponse;", "postParam", "Ljava/util/HashMap;", "", "statusResponse", "Lcom/radian/myradianvaluations/Response/StatusResponse;", "getNotistatus", "saveNotiStatus", "Companion", "app_DevDebug"})
public final class SettingsRepository {
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.NotiStatusResponse> notiStatusResponse;
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> statusResponse;
    private java.util.HashMap<java.lang.String, java.lang.String> postParam;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    public static final com.radian.myradianvaluations.repository.SettingsRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.NotiStatusResponse> getNotistatus() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> saveNotiStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public SettingsRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/radian/myradianvaluations/repository/SettingsRepository$Companion;", "", "()V", "getInstance", "Lcom/radian/myradianvaluations/repository/SettingsRepository;", "context", "Landroid/content/Context;", "app_DevDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.repository.SettingsRepository getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}