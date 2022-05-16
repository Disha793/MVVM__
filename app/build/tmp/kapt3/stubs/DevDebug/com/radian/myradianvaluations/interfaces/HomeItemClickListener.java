package com.radian.myradianvaluations.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/radian/myradianvaluations/interfaces/HomeItemClickListener;", "", "homeItemClicked", "", "position", "", "abbr", "", "actionType", "app_DevDebug"})
public abstract interface HomeItemClickListener {
    
    public abstract void homeItemClicked(int position, @org.jetbrains.annotations.NotNull()
    java.lang.String abbr, @org.jetbrains.annotations.NotNull()
    java.lang.String actionType);
}