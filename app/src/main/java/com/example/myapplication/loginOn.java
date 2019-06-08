package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class loginOn extends AppCompatActivity { //로그인했을때

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_login_on);


        EditText idText = (EditText) findViewById(R.id.idText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        //TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);
    }
}
