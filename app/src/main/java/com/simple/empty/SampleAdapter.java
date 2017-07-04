package com.simple.empty;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.simple.handling.SimpleAdapter;
import com.simple.handling.SimpleViewHolder;
import java.util.List;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 04/07/2017.
 */

public class SampleAdapter extends SimpleAdapter {

    private List<String> mList;

    public SampleAdapter(List<String> list) {
        mList = list;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        TextView textView = holder.itemView.findViewById(R.id.text_view);
        textView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    private class ViewHolder extends SimpleViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
