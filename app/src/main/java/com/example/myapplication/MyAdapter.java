package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView TextView_title;
        public TextView TextView_content;
        public ImageView ImageView_title;

        public MyViewHolder(View view) {
            super(view);

            TextView_title = view.findViewById(R.id.TextView_title);
            TextView_content = view.findViewById(R.id.TextView_content);
            ImageView_title = view.findViewById(R.id.ImageView_title);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<MyData> myDataset) {
        mDataset = myDataset;
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
        holder.TextView_title.setText(mDataset.get(position).text);
        holder.TextView_content.setText(mDataset.get(position).text2);
        holder.ImageView_title.setImageResource(mDataset.get(position).img);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset.size();
    }



}
class MyData{
    public String text,text2;
    public int img;
    public MyData(String text,String text2, int img){
        this.text=text;
        this.text2=text2;
        this.img=img;
    }
}
