package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<MyData> myDataset;
    private String[] name={"최대윤","김동현","박충현","이지영","나영석"};
    private String[] uni={"부경대학교","울산대학교","중앙대학교","서울대학교","서강대학교"};
    private String[] sex={"남자","남자","남자","여자","남자"};
    private String[] age={"20세","24세","22세","21세","25세"};
    private String[] selfintro={"안녕하세요~","잘 부탁 드립니다.","반갑습니다~","ㅎㅇㅎㅇ","Hello World!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=(RecyclerView)findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        myDataset = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(myDataset, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (int)v.getTag();

                Intent intent = new Intent(MainActivity.this, profileActivity.class);

                intent.putExtra("name",name[position]);
                intent.putExtra("uni",uni[position]);
                intent.putExtra("sex",sex[position]);
                intent.putExtra("age",age[position]);
                intent.putExtra("selfintro",selfintro[position]);

                startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);

        myDataset.add(new MyData(name[0],uni[0],sex[0],age[0],selfintro[0],R.drawable.bobgotyping));
        myDataset.add(new MyData(name[1],uni[1],sex[1],age[1],selfintro[1],R.drawable.bobgotyping));
        myDataset.add(new MyData(name[2],uni[2],sex[2],age[2],selfintro[2],R.drawable.bobgotyping));
        myDataset.add(new MyData(name[3],uni[3],sex[3],age[3],selfintro[3],R.drawable.bobgotyping));
        myDataset.add(new MyData(name[4],uni[4],sex[4],age[4],selfintro[4],R.drawable.bobgotyping));




    }
}
