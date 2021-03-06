package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class profile_Activity extends Activity {


    private TextView profile_name;
    private TextView profile_uni;
    private TextView profile_age;
    private TextView profile_sex;
    private TextView profile_selfintro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_name=findViewById(R.id.profile_name);
        profile_uni=findViewById(R.id.profile_uni);
        profile_sex=findViewById(R.id.profile_sex);
        profile_age=findViewById(R.id.profile_age);
        profile_selfintro=findViewById(R.id.profile_selfintro);

        Intent profile_intent = getIntent();
        Bundle profile_bundle = profile_intent.getExtras();
        String name = profile_bundle.getString("name");
        String uni = profile_bundle.getString("uni");
        String age = profile_bundle.getString("age");
        String sex = profile_bundle.getString("sex");
        String selfintro = profile_bundle.getString("selfintro");

        profile_name.setText(name);
        profile_uni.setText(uni);
        profile_age.setText(age);
        profile_sex.setText(sex);
        profile_selfintro.setText(selfintro);

    }
}
