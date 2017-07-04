package com.simple.handling;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 04/07/2017.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {

    private OnItemActionListener mOnItemActionListener;

    private View mView;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mView.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetector gestureDetector =
                    new GestureDetector(mView.getContext(), new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onDoubleTap(MotionEvent e) {
                            if (mOnItemActionListener != null) {
                                mOnItemActionListener.onDoubleTap(mView, getAdapterPosition());
                            }
                            return true;
                        }

                        @Override
                        public boolean onSingleTapConfirmed(MotionEvent e) {
                            if (mOnItemActionListener != null) {
                                mOnItemActionListener.onTap(mView, getAdapterPosition());
                            }
                            return true;
                        }

                        @Override
                        public void onLongPress(MotionEvent e) {
                            if (mOnItemActionListener != null) {
                                mOnItemActionListener.onLongTap(mView, getAdapterPosition());
                            }
                        }
                    });

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    void setHandler(OnItemActionListener onItemActionListener) {
        mOnItemActionListener = onItemActionListener;
    }
}
