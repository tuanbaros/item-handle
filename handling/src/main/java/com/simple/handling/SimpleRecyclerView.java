package com.simple.handling;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 04/07/2017.
 */

public class SimpleRecyclerView extends RecyclerView {

    public SimpleRecyclerView(Context context) {
        super(context);
    }

    public SimpleRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setOnItemAction(OnItemActionListener onItemAction) {
        ((SimpleAdapter) this.getAdapter()).setHandler(onItemAction);
    }
}
