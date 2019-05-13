package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class list_Adapter extends RecyclerView.Adapter<list_Adapter.MyViewHolder> {
    private ArrayList<list_Data> list_Dataset;
    private static View.OnClickListener list_onClickListener;



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView list_TextView_name;
        public TextView list_TextView_uni;
        public TextView list_TextView_sex;
        public TextView list_TextView_age;
        public TextView list_TextView_selfintro;
        public ImageView list_ImageView_title;
        public View list_LinearLayout_Click;

        public MyViewHolder(View view) {
            super(view);

            list_TextView_name = view.findViewById(R.id.list_TextView_name);
            list_TextView_uni = view.findViewById(R.id.list_TextView_uni);
            list_TextView_sex = view.findViewById(R.id.list_TextView_sex);
            list_TextView_age = view.findViewById(R.id.list_TextView_age);
            list_TextView_selfintro = view.findViewById(R.id.list_TextView_selfintro);
            list_ImageView_title = view.findViewById(R.id.list_ImageView_title);
            list_LinearLayout_Click = view.findViewById(R.id.list_LinearLayout_Click);

            list_LinearLayout_Click.setClickable(true);
            list_LinearLayout_Click.setEnabled(true);
            list_LinearLayout_Click.setOnClickListener(list_onClickListener);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public list_Adapter(ArrayList<list_Data> listDataset, View.OnClickListener list_onClick) {

        list_Dataset = listDataset;
        list_onClickListener = list_onClick;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public list_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.list_TextView_name.setText(list_Dataset.get(position).name);
        holder.list_TextView_uni.setText(list_Dataset.get(position).uni);
        holder.list_TextView_sex.setText(list_Dataset.get(position).sex);
        holder.list_TextView_age.setText(list_Dataset.get(position).age);
        holder.list_TextView_selfintro.setText(list_Dataset.get(position).selfintro);
        holder.list_ImageView_title.setImageResource(list_Dataset.get(position).img);
        holder.list_LinearLayout_Click.setTag(position);
   }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return list_Dataset.size();
    }



}
class list_Data {
    public String name,uni,sex,age,selfintro;
    public int img;
    public list_Data(String name, String uni, String sex, String age, String selfintro, int img){
        this.name=name;
        this.uni=uni;
        this.sex=sex;
        this.age=age;
        this.selfintro=selfintro;
        this.img=img;
    }
}
