package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class list_recycler_Activity extends Activity {

    private RecyclerView list_recyclerView;
    private RecyclerView.Adapter list_Adapter;
    private RecyclerView.LayoutManager list_layoutManager;
    private ArrayList<list_Data> listDataset;
    private String[] list_name={"최대윤","김동현","박충현","이지영","나영석"};
    private String[] list_uni={"부경대학교","울산대학교","중앙대학교","서울대학교","서강대학교"};
    private String[] list_sex={"남자","남자","남자","여자","남자"};
    private String[] list_age={"20세","24세","22세","21세","25세"};
    private String[] list_selfintro={"안녕하세요~","잘 부탁 드립니다.","반갑습니다~","ㅎㅇㅎㅇ","Hello World!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycler);

        list_recyclerView=findViewById(R.id.list_recycler_view); //activity_list_recycler 의 리스트 뷰

        list_recyclerView.setHasFixedSize(true);

        listDataset = new ArrayList<>();
        list_layoutManager = new LinearLayoutManager(this);
        list_recyclerView.setLayoutManager(list_layoutManager);


        Intent intent = getIntent();
        try{
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");
            int count = 0;
            String userID, userPassword, userName, userAge, userUniversity;
            while(count < jsonArray.length()){
                JSONObject object = jsonArray.getJSONObject(count);
                userID = object.getString("userID");
                userPassword = object.getString("userPassword");
                userName = object.getString("userName");
                userAge = object.getString("userAge");
                userUniversity = object.getString("userUniversity");
                User user = new User(userID, userPassword, userName, userAge, userUniversity);

                count++;

            }
        }catch(Exception e){
            e.printStackTrace();
        }


        list_Adapter = new list_Adapter(listDataset, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int list_position = (int)v.getTag();

                Intent list_intent = new Intent(list_recycler_Activity.this, profile_Activity.class);

                list_intent.putExtra("name",list_name[list_position]);
                list_intent.putExtra("uni",list_uni[list_position]);
                list_intent.putExtra("sex",list_sex[list_position]);
                list_intent.putExtra("age",list_age[list_position]);
                list_intent.putExtra("selfintro",list_selfintro[list_position]);

                startActivity(list_intent);
            }
        });
        list_recyclerView.setAdapter(list_Adapter);

        listDataset.add(new list_Data(list_name[0],list_uni[0],list_sex[0],list_age[0],list_selfintro[0],R.drawable.list_bobgotyping));
        listDataset.add(new list_Data(list_name[1],list_uni[1],list_sex[1],list_age[1],list_selfintro[1],R.drawable.list_bobgotyping));
        listDataset.add(new list_Data(list_name[2],list_uni[2],list_sex[2],list_age[2],list_selfintro[2],R.drawable.list_bobgotyping));
        listDataset.add(new list_Data(list_name[3],list_uni[3],list_sex[3],list_age[3],list_selfintro[3],R.drawable.list_bobgotyping));
        listDataset.add(new list_Data(list_name[4],list_uni[4],list_sex[4],list_age[4],list_selfintro[4],R.drawable.list_bobgotyping));




    }
}
