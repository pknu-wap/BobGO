package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {


    EditText et_ID;
    EditText et_PW;
    //Button btn_Login;
    Button btn_Join;
    ImageView im_Food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //로그인 메인화면

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText idText = (EditText) findViewById(R.id.et_ID);
        final EditText passwordText = (EditText) findViewById(R.id.et_PW);

        final Button btn_Login = (Button) findViewById(R.id.btn_Login);
       // et_ID = findViewById(R.id.et_ID);
        // et_PW = findViewById(R.id.et_PW);
        //btn_Login = findViewById(R.id.btn_Login);
        btn_Join = findViewById(R.id.btn_Join);
        im_Food = findViewById(R.id.im_Food);

        btn_Join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //회원가입버튼
                Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
                startActivity(intent);
            }
        });
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //로그인 버튼
                final String userID = idText.getText().toString();
                final String userPassword = passwordText.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() { //response받아와서 여기에 저장할수있게 도와줌
                    public void onResponse(String response){
                        try{
                            JSONObject jsonResponse = new JSONObject(response); //json으로 가져와 저장
                            boolean success = jsonResponse.getBoolean("success");  //php bool 값 success로

                            if(success){
                                String userID = jsonResponse.getString("userID");
                                String userPassword = jsonResponse.getString("userPassword");
                                Intent intent = new Intent(LoginActivity.this, loginOn.class);

                                intent.putExtra("userID",userID);
                                intent.putExtra("userPassword", userPassword);
                                LoginActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity .this);
                                builder.setMessage("로그인에 실패하였습니다.")
                                        .setNegativeButton("다시 시도", null)
                                        .create()
                                        .show();
                            }

                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);



            }
        });
    }
}
