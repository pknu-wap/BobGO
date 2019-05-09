package com.example.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<MyData> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        myDataset = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(myDataset);
        recyclerView.setAdapter(mAdapter);

        myDataset.add(new MyData("최대윤","부산 남구 대연동",R.drawable.backmac));
        myDataset.add(new MyData("김동현","울산 남구 신정동",R.drawable.mini));
        myDataset.add(new MyData("박충현","서울 용산구 한남동",R.drawable.toystory));
        myDataset.add(new MyData("이지영","부산 부산진구 부전동",R.drawable.insideout));
        myDataset.add(new MyData("나영석","부산 수영구 광안동",R.drawable.backmac));




    }
}
