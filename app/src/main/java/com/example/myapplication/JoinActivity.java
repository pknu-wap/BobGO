package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import org.json.JSONException;
import org.json.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
//activity_join.xml
public class JoinActivity extends AppCompatActivity {

    Button btn_confirm;
    Button btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        //회원가입 필요 정보 저장
        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText nameText = (EditText) findViewById(R.id.nameText);
        final EditText stdText = (EditText) findViewById(R.id.stdText);
        final EditText nickText = (EditText) findViewById(R.id.nickText);


        btn_confirm = findViewById(R.id.btn_confirm); //확인
        btn_cancel = findViewById(R.id.btn_cancel);//취소

        //확인창 클릭
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = idText.getText().toString();
                String userPassword = passwordText.getText().toString();
                String userName = nameText.getText().toString();
                int userSTUID = Integer.parseInt(nickText.getText().toString());
                String userNID = nameText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                builder.setMessage("회원 등록에 성공했습니다.")
                                        .setPositiveButton("확인",null)
                                        .create()
                                        .show();
                                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                                JoinActivity.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                builder.setMessage("회원 등록에 실패했습니다..")
                                        .setNegativeButton("다시시도",null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                            builder.setMessage("회원 등록에 실패했습니다..")
                                    .setNegativeButton("다시시도",null)
                                    .create()
                                    .show();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, userSTUID, userNID, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(registerRequest);

            }
        });
        //취소창 클릭
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(JoinActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}

