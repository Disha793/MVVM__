package com.radian.myradianvaluations.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u0011J6\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001`\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/radian/myradianvaluations/repository/DocumentListRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "docResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/radian/myradianvaluations/Response/OrderDocResponse;", "postParam", "Ljava/util/HashMap;", "", "statusResponse", "Lcom/radian/myradianvaluations/Response/StatusResponse;", "getDocuments", "itemId", "", "markAsRead", "Lkotlin/collections/HashMap;", "Companion", "app_DevDebug"})
public final class DocumentListRepository {
    private java.util.HashMap<java.lang.String, java.lang.Object> postParam;
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OrderDocResponse> docResponse;
    private androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> statusResponse;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    public static final com.radian.myradianvaluations.repository.DocumentListRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.OrderDocResponse> getDocuments(int itemId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.MutableLiveData<com.radian.myradianvaluations.Response.StatusResponse> markAsRead(@org.jetbrains.annotations.NotNull()
    java.util.HashMap<java.lang.String, java.lang.Object> postParam) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public DocumentListRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/radian/myradianvaluations/repository/DocumentListRepository$Companion;", "", "()V", "getInstance", "Lcom/radian/myradianvaluations/repository/DocumentListRepository;", "context", "Landroid/content/Context;", "app_DevDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.repository.DocumentListRepository getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}