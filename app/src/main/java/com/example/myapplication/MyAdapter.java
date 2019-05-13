package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<MyData> mDataset;
    private static View.OnClickListener onClickListener;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView TextView_name;
        public TextView TextView_uni;
        public TextView TextView_sex;
        public TextView TextView_age;
        public TextView TextView_selfintro;
        public ImageView ImageView_title;
        public View LinearLayout_Click;

        public MyViewHolder(View view) {
            super(view);

            TextView_name = view.findViewById(R.id.TextView_name);
            TextView_uni = view.findViewById(R.id.TextView_uni);
            TextView_sex = view.findViewById(R.id.TextView_sex);
            TextView_age = view.findViewById(R.id.TextView_age);
            TextView_selfintro = view.findViewById(R.id.TextView_selfintro);
            ImageView_title = view.findViewById(R.id.ImageView_title);
            LinearLayout_Click = view.findViewById(R.id.LinearLayout_Click);

            LinearLayout_Click.setClickable(true);
            LinearLayout_Click.setEnabled(true);
            LinearLayout_Click.setOnClickListener(onClickListener);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MyData> myDataset,View.OnClickListener onClick) {

        mDataset = myDataset;
        onClickListener = onClick;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cardview, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.TextView_name.setText(mDataset.get(position).name);
        holder.TextView_uni.setText(mDataset.get(position).uni);
        holder.TextView_sex.setText(mDataset.get(position).sex);
        holder.TextView_age.setText(mDataset.get(position).age);
        holder.TextView_selfintro.setText(mDataset.get(position).selfintro);
        holder.ImageView_title.setImageResource(mDataset.get(position).img);
        holder.LinearLayout_Click.setTag(position);
   }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset.size();
    }



}
class MyData{
    public String name,uni,sex,age,selfintro;
    public int img;
    public MyData(String name,String uni,String sex,String age,String selfintro, int img){
        this.name=name;
        this.uni=uni;
        this.sex=sex;
        this.age=age;
        this.selfintro=selfintro;
        this.img=img;
    }
}
