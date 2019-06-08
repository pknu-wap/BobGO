package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText et_ID;
    EditText et_PW;
    Button btn_Login;
    Button btn_Join;
    ImageView im_Food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //로그인 메인화면

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        et_ID = findViewById(R.id.et_ID);
        et_PW = findViewById(R.id.et_PW);
        btn_Login = findViewById(R.id.btn_Login);
        btn_Join = findViewById(R.id.btn_Join);
        im_Food = findViewById(R.id.im_Food);

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //로그인 버튼
                //Intent intent = new Intent(LoginActivity.this, SubActivity.class);
                //startActivity(intent);
            }
        });
        btn_Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //회원가입버튼
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(LoginActivity.this, list_Adapter.class);
               // startActivity(intent);
            }
        });
    }
}
