package com.example.shamsad.materialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by shamsad on 1/16/17.
 */

public class recycler_adapter extends RecyclerView.Adapter <recycler_adapter.MyViewHolder>{

    private LayoutInflater inflater;
    List<information>data = Collections.emptyList();

    public void recycler_adapter(Context context,List<information>data){
       inflater=LayoutInflater.from(context);
        this.data=data;

   }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_row,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        information current=data.get(position);
        holder.text.setText(current.getTitle());
        holder.icon.setImageResource(current.getIconid());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            text=(TextView)itemView.findViewById(R.id.rcl_text);
            icon=(ImageView)itemView.findViewById(R.id.rcl_icon);
        }
    }
}
