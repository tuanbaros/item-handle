package com.simple.handling;

import android.support.v7.widget.RecyclerView;

import javax.annotation.OverridingMethodsMustInvokeSuper;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 04/07/2017.
 */

public abstract class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private OnItemActionListener mOnItemActionListener;

    @OverridingMethodsMustInvokeSuper
    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.setHandler(mOnItemActionListener);
    }

    void setHandler(OnItemActionListener onItemClickListener) {
        mOnItemActionListener = onItemClickListener;
    }
}
