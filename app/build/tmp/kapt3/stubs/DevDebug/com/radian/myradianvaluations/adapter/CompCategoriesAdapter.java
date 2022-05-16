package com.radian.myradianvaluations.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001/B\u0095\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00126\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b\u00126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000b\u00a2\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020%H\u0016J\u0018\u0010\'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020%H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0016J\u0014\u0010-\u001a\u00020\u00112\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bRJ\u0010\n\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRJ\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f\u00a8\u00060"}, d2 = {"Lcom/radian/myradianvaluations/adapter/CompCategoriesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/radian/myradianvaluations/adapter/CompCategoriesAdapter$CategoriesViewHolder;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "listCategories", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$Data;", "Lkotlin/collections/ArrayList;", "onAddImageClick", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "filterList", "position", "", "onImageClick", "(Landroid/content/Context;Ljava/util/ArrayList;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getListCategories", "()Ljava/util/ArrayList;", "setListCategories", "(Ljava/util/ArrayList;)V", "getOnAddImageClick", "()Lkotlin/jvm/functions/Function2;", "setOnAddImageClick", "(Lkotlin/jvm/functions/Function2;)V", "getOnImageClick", "setOnImageClick", "getFilter", "Landroid/widget/Filter;", "getItemCount", "", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "updateFilterList", "catData", "CategoriesViewHolder", "app_DevDebug"})
public final class CompCategoriesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.radian.myradianvaluations.adapter.CompCategoriesAdapter.CategoriesViewHolder> implements android.widget.Filterable {
    private java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> filterList;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context context;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> listCategories;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> onAddImageClick;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> onImageClick;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.radian.myradianvaluations.adapter.CompCategoriesAdapter.CategoriesViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void updateFilterList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> catData) {
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.adapter.CompCategoriesAdapter.CategoriesViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public final void setContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> getListCategories() {
        return null;
    }
    
    public final void setListCategories(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> getOnAddImageClick() {
        return null;
    }
    
    public final void setOnAddImageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> getOnImageClick() {
        return null;
    }
    
    public final void setOnImageClick(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> p0) {
    }
    
    public CompCategoriesAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> listCategories, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> onAddImageClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, kotlin.Unit> onImageClick) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/radian/myradianvaluations/adapter/CompCategoriesAdapter$CategoriesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "ivCamera", "Landroidx/appcompat/widget/AppCompatImageView;", "getIvCamera", "()Landroidx/appcompat/widget/AppCompatImageView;", "setIvCamera", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "ivDelete", "getIvDelete", "setIvDelete", "ivGallery", "getIvGallery", "setIvGallery", "ivImage", "getIvImage", "setIvImage", "tvAddImage", "Landroidx/appcompat/widget/AppCompatTextView;", "getTvAddImage", "()Landroidx/appcompat/widget/AppCompatTextView;", "setTvAddImage", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "tvCategoryName", "getTvCategoryName", "setTvCategoryName", "tvCount", "getTvCount", "setTvCount", "app_DevDebug"})
    public static final class CategoriesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatTextView tvCategoryName;
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatImageView ivImage;
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatImageView ivGallery;
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatImageView ivCamera;
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatImageView ivDelete;
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatTextView tvCount;
        @org.jetbrains.annotations.NotNull()
        private androidx.appcompat.widget.AppCompatTextView tvAddImage;
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatTextView getTvCategoryName() {
            return null;
        }
        
        public final void setTvCategoryName(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatTextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageView getIvImage() {
            return null;
        }
        
        public final void setIvImage(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageView getIvGallery() {
            return null;
        }
        
        public final void setIvGallery(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageView getIvCamera() {
            return null;
        }
        
        public final void setIvCamera(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatImageView getIvDelete() {
            return null;
        }
        
        public final void setIvDelete(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatImageView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatTextView getTvCount() {
            return null;
        }
        
        public final void setTvCount(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatTextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.AppCompatTextView getTvAddImage() {
            return null;
        }
        
        public final void setTvAddImage(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.AppCompatTextView p0) {
        }
        
        public CategoriesViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}