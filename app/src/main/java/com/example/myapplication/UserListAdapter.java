package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<User> userList;


    public UserListAdapter(Context context, List<User> userList){
        this.context = context;
        this.userList = userList;
    }
    @Override
    public int getCount() {
        return userList.size(); //현재 사용자의 사이즈 바ㅣㄴ환
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        return null;
    }
}
