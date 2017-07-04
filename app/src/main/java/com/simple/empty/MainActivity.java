package com.simple.empty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import com.simple.handling.ItemAction;
import com.simple.handling.OnItemActionListener;
import com.simple.handling.SimpleRecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            list.add("" + i);
        }

        SimpleRecyclerView simpleRecyclerView =
                (SimpleRecyclerView) findViewById(R.id.simple_recycler_view);
        simpleRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        simpleRecyclerView.setHasFixedSize(true);
        simpleRecyclerView.setAdapter(new SampleAdapter(list));
        simpleRecyclerView.setOnItemAction(new ItemAction() {
            @Override
            public void onTap(View view, int position) {
                Log.i("tap", position + "");
            }

            @Override
            public void onLongTap(View view, int position) {
                Log.i("long", position + "");
            }

            @Override
            public void onDoubleTap(View view, int position) {
                Log.i("double", position + "");
            }
        });

    }
}
