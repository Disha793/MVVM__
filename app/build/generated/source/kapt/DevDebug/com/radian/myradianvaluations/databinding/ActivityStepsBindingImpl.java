package com.radian.myradianvaluations.databinding;
import com.radian.myradianvaluations.R;
import com.radian.myradianvaluations.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStepsBindingImpl extends ActivityStepsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.includedToolbar, 1);
        sViewsWithIds.put(R.id.rlStepOne, 2);
        sViewsWithIds.put(R.id.rlStepTwo, 3);
        sViewsWithIds.put(R.id.tvStepOne, 4);
        sViewsWithIds.put(R.id.tvStepTwo, 5);
        sViewsWithIds.put(R.id.rvAssets, 6);
        sViewsWithIds.put(R.id.llCategories, 7);
        sViewsWithIds.put(R.id.svCategory, 8);
        sViewsWithIds.put(R.id.rvCategories, 9);
        sViewsWithIds.put(R.id.llButton, 10);
        sViewsWithIds.put(R.id.btnStart, 11);
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityStepsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private ActivityStepsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.appcompat.widget.AppCompatButton) bindings[11]
            , (android.view.View) bindings[1]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[0]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[10]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[7]
            , (android.widget.RelativeLayout) bindings[2]
            , (android.widget.RelativeLayout) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (androidx.appcompat.widget.SearchView) bindings[8]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[5]
            );
        this.ll.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}