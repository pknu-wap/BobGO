package com.example.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    final static String URL = "http://hennible0612.cafe24.com/BGregister.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userName, int userSTUID, String userNick, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userID", userID);
        parameters.put("userPassword", userPassword);
        parameters.put("userName", userName);
        parameters.put("userAge", userSTUID + "");
        parameters.put("userUniversity", userNick);
    }
    @Override
    public Map<String, String> getParams(){
        return parameters;

    }

}
