package com.example.inucalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<grades> List = null;
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,sort,score,point;
        ViewHolder(View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.name);
            sort = itemview.findViewById(R.id.sort);
            score = itemview.findViewById(R.id.score);
            point = itemview.findViewById(R.id.point);
        }
    }
    public RecyclerAdapter(List<grades> list){
        List = list;
    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false);
        RecyclerAdapter.ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.name.setText(List.get(position).getName());
        holder.sort.setText(List.get(position).getSort());
        holder.score.setText(List.get(position).getScore());
        holder.point.setText("3");
    }

    @Override
    public int getItemCount() {
        return List.size();
    }
}
