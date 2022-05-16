package com.radian.myradianvaluations.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/radian/myradianvaluations/adapter/OrderDocListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/radian/myradianvaluations/adapter/OrderDocListAdapter$ViewHolder;", "itemClick", "Lcom/radian/myradianvaluations/interfaces/ListItemClickListener;", "docList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/OrderDocResponse$TileOrder;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "(Lcom/radian/myradianvaluations/interfaces/ListItemClickListener;Ljava/util/ArrayList;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_DevDebug"})
public final class OrderDocListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.radian.myradianvaluations.adapter.OrderDocListAdapter.ViewHolder> {
    private final com.radian.myradianvaluations.interfaces.ListItemClickListener itemClick = null;
    private final java.util.ArrayList<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> docList = null;
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.radian.myradianvaluations.adapter.OrderDocListAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.adapter.OrderDocListAdapter.ViewHolder holder, int position) {
    }
    
    public OrderDocListAdapter(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.interfaces.ListItemClickListener itemClick, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> docList, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0010\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00110\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/radian/myradianvaluations/adapter/OrderDocListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/radian/myradianvaluations/adapter/OrderDocListAdapter;Landroid/view/View;)V", "imgDot", "Landroidx/appcompat/widget/AppCompatImageView;", "kotlin.jvm.PlatformType", "getImgDot", "()Landroidx/appcompat/widget/AppCompatImageView;", "imgNavigation", "getImgNavigation", "linearDocument", "Landroidx/appcompat/widget/LinearLayoutCompat;", "getLinearDocument", "()Landroidx/appcompat/widget/LinearLayoutCompat;", "txtDoc", "Landroidx/appcompat/widget/AppCompatTextView;", "getTxtDoc", "()Landroidx/appcompat/widget/AppCompatTextView;", "txtNewDoc", "getTxtNewDoc", "app_DevDebug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final androidx.appcompat.widget.AppCompatTextView txtDoc = null;
        private final androidx.appcompat.widget.AppCompatImageView imgNavigation = null;
        private final androidx.appcompat.widget.AppCompatImageView imgDot = null;
        private final androidx.appcompat.widget.AppCompatTextView txtNewDoc = null;
        private final androidx.appcompat.widget.LinearLayoutCompat linearDocument = null;
        
        public final androidx.appcompat.widget.AppCompatTextView getTxtDoc() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatImageView getImgNavigation() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatImageView getImgDot() {
            return null;
        }
        
        public final androidx.appcompat.widget.AppCompatTextView getTxtNewDoc() {
            return null;
        }
        
        public final androidx.appcompat.widget.LinearLayoutCompat getLinearDocument() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}