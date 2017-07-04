package com.simple.handling;

import android.view.View;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 04/07/2017.
 */

public interface OnItemActionListener {
    void onTap(View view, int position);
    void onLongTap(View view, int position);
    void onDoubleTap(View view, int position);
}
