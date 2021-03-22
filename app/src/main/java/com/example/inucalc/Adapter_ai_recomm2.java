package com.example.inucalc;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class Adapter_ai_recomm2 extends RecyclerView.Adapter<Adapter_ai_recomm2.ViewHolder>  {
    private ArrayList<Data_ai_recomm2> arrayList2;
    java.util.List<retakeTuple> List = null;
    String[] list;
    String reinfo;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv11,tv22,tv44;

        Button btn33;
        AlertDialog.Builder builder;
        ViewHolder(View itemview){
            super(itemview);
            tv11 = itemview.findViewById(R.id.tv11);
            tv22 = itemview.findViewById(R.id.tv22);
            btn33 = itemview.findViewById(R.id.btn33);
            tv44 = itemview.findViewById(R.id.tv44);

        }
    }
    public Adapter_ai_recomm2(java.util.List<retakeTuple> list){
        List = list;
    }
    @NonNull
    @Override
    public Adapter_ai_recomm2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recomm2,parent,false);
        Adapter_ai_recomm2.ViewHolder viewHolder = new Adapter_ai_recomm2.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_ai_recomm2.ViewHolder holder, int position) {
        holder.tv11.setText(List.get(position).getName());
        holder.tv22.setText(List.get(position).getScore());
        if((reinfo=List.get(position).getReInfo())==null) { reinfo="A+"; }
        holder.btn33.setText(reinfo);
        holder.tv44.setText("3.25");
        holder.btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list=v.getResources().getStringArray(R.array.goal_grade);
                holder.builder = new AlertDialog.Builder(v.getContext());
                holder.builder.setTitle("목표성적");
                holder.builder.setNegativeButton("닫기",null);
                holder.builder.setItems(list, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        reinfo=list[which];
                        holder.btn33.setText(reinfo);

                        AppDatabase db = Room.databaseBuilder(v.getContext(),AppDatabase.class,"grades")
                                .allowMainThreadQueries()
                                .build();
                        // reInfo update
                        db.gradesDAO().setReInfo(List.get(position).getName(),reinfo);
                    }
                });
                AlertDialog alertDialog = holder.builder.create();
                alertDialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return List.size();
    }
}
