package com.radian.myradianvaluations.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/radian/myradianvaluations/adapter/NewOrdersAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/radian/myradianvaluations/adapter/NewOrdersAdapter$ViewHolder;", "context", "Landroid/content/Context;", "newOrderList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/NewOrderResponse$Data$OrderResponse;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_DevDebug"})
public final class NewOrdersAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.radian.myradianvaluations.adapter.NewOrdersAdapter.ViewHolder> {
    private final android.content.Context context = null;
    private final java.util.ArrayList<com.radian.myradianvaluations.Response.NewOrderResponse.Data.OrderResponse> newOrderList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.radian.myradianvaluations.adapter.NewOrdersAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.adapter.NewOrdersAdapter.ViewHolder holder, int position) {
    }
    
    public NewOrdersAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.NewOrderResponse.Data.OrderResponse> newOrderList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/radian/myradianvaluations/adapter/NewOrdersAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "cardNewOrdr", "Landroidx/cardview/widget/CardView;", "kotlin.jvm.PlatformType", "getCardNewOrdr", "()Landroidx/cardview/widget/CardView;", "lblnworderAdd", "Landroidx/appcompat/widget/AppCompatTextView;", "getLblnworderAdd", "()Landroidx/appcompat/widget/AppCompatTextView;", "lblnworderProduct", "getLblnworderProduct", "lblnworderTime", "getLblnworderTime", "app_DevDebug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final androidx.cardview.widget.CardView cardNewOrdr = null;
        private final androidx.appcompat.widget.AppCompatTextView lblnworderAdd = null;
        private final androidx.appcompat.widget.AppCompatTextView lblnworderProduct = null;
        private final androidx.appcompat.widget.AppCompatTextView lblnworderTime = null;
        
        public final androidx.cardview.widget.CardView getCardNewOrdr() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getLblnworderAdd() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getLblnworderProduct() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getLblnworderTime() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}