package com.radian.myradianvaluations.view.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J&\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001bH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006("}, d2 = {"Lcom/radian/myradianvaluations/view/fragment/ImageViewerFragment;", "Landroidx/fragment/app/Fragment;", "catData", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$Data;", "Lkotlin/collections/ArrayList;", "currentCategoryPosition", "", "itemIdTag", "(Ljava/util/ArrayList;II)V", "categoryData", "currentCatPos", "currentViewPagerPos", "factory", "Lcom/radian/myradianvaluations/viewmodel/ImageViewerViewModelFactory;", "imageViewerAdapter", "Lcom/radian/myradianvaluations/adapter/ImageViewerAdapter;", "imageViewerViewModel", "Lcom/radian/myradianvaluations/viewmodel/ImageViewerViewModel;", "itemId", "view", "Landroid/view/View;", "getView$app_DevDebug", "()Landroid/view/View;", "setView$app_DevDebug", "(Landroid/view/View;)V", "deletePhoto", "", "init", "initViewModel", "listener", "observePhotos", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setToolbar", "app_DevDebug"})
public final class ImageViewerFragment extends androidx.fragment.app.Fragment {
    private int currentViewPagerPos = 0;
    private int currentCatPos;
    private int itemId;
    private java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> categoryData;
    private com.radian.myradianvaluations.adapter.ImageViewerAdapter imageViewerAdapter;
    @org.jetbrains.annotations.NotNull()
    public android.view.View view;
    private com.radian.myradianvaluations.viewmodel.ImageViewerViewModel imageViewerViewModel;
    private com.radian.myradianvaluations.viewmodel.ImageViewerViewModelFactory factory;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getView$app_DevDebug() {
        return null;
    }
    
    public final void setView$app_DevDebug(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setToolbar() {
    }
    
    private final void observePhotos() {
    }
    
    private final void initViewModel() {
    }
    
    private final void init() {
    }
    
    private final void listener() {
    }
    
    private final void deletePhoto() {
    }
    
    public ImageViewerFragment(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> catData, int currentCategoryPosition, int itemIdTag) {
        super();
    }
}