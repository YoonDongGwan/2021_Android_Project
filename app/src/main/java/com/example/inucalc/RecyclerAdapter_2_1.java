package com.example.inucalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter_2_1 extends RecyclerView.Adapter<RecyclerAdapter_2_1.ViewHolder> {

    ArrayList<String> arrayList = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ViewHolder(View itemview){
            super(itemview);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.textView.setText(text);
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
