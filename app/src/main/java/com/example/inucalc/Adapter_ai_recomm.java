package com.example.inucalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_ai_recomm extends RecyclerView.Adapter<Adapter_ai_recomm.CustomerViewHolder> {
    private ArrayList<Data_ai_recomm> arrayList;

    public Adapter_ai_recomm(ArrayList<Data_ai_recomm> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter_ai_recomm.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recomm,parent,false);
        CustomerViewHolder holder = new CustomerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_ai_recomm.CustomerViewHolder holder, int position) {
        holder.btn_detail.setImageResource(arrayList.get(position).getBtn_detail());
        holder.tv1.setText(arrayList.get(position).getTv1());
        holder.tv2.setText(arrayList.get(position).getTv2());
        holder.tv3.setText(arrayList.get(position).getTv3());
        holder.tv4.setText(arrayList.get(position).getTv4());
        holder.tv5.setText(arrayList.get(position).getTv5());

        //아이템뷰가 클릭이 되었을 때
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv1.getText().toString();
                Toast.makeText(v.getContext(),curName,Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return (null!= arrayList ? arrayList.size():0);
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        protected ImageView btn_detail;
        protected TextView tv1;
        protected TextView tv2;
        protected TextView tv3;
        protected TextView tv4;
        protected TextView tv5;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.btn_detail=(ImageView)itemView.findViewById(R.id.btn_detail);
            this.tv1=(TextView)itemView.findViewById(R.id.tv1);
            this.tv2 =(TextView)itemView.findViewById(R.id.tv2);
            this.tv3=(TextView)itemView.findViewById(R.id.tv3);
            this.tv4=(TextView)itemView.findViewById(R.id.tv4);
            this.tv5=(TextView)itemView.findViewById(R.id.tv5);
        }
    }
}
