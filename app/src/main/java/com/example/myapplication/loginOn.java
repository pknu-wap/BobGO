package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class loginOn extends AppCompatActivity { //로그인했을때

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_on);


        TextView idText = (TextView) findViewById(R.id.idText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");
        String userPassword = intent.getStringExtra("userPassword");
        String message = "환영합니다, " + userID + "님";

        idText.setText(userID);
        passwordText.setText(userPassword);
        welcomeMessage.setText(message);
    }
}
