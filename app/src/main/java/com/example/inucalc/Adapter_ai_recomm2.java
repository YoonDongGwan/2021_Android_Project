package com.example.inucalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_ai_recomm2 extends RecyclerView.Adapter<Adapter_ai_recomm2.CustomerViewHolder>  {
    private ArrayList<Data_ai_recomm2> arrayList2;

    public Adapter_ai_recomm2(ArrayList<Data_ai_recomm2> arrayList2) {
        this.arrayList2 = arrayList2;
    }
    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recomm2,parent,false);
        Adapter_ai_recomm2.CustomerViewHolder holder = new Adapter_ai_recomm2.CustomerViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.tv11.setText(arrayList2.get(position).getTv11());
        holder.tv22.setText(arrayList2.get(position).getTv22());
        holder.tv33.setText(arrayList2.get(position).getTv33());
        holder.tv44.setText(arrayList2.get(position).getTv44());


    }

    @Override
    public int getItemCount() {
        return (null!= arrayList2 ? arrayList2.size():0);
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        protected TextView tv11;
        protected TextView tv22;
        protected TextView tv33;
        protected TextView tv44;
        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv11=(TextView)itemView.findViewById(R.id.tv11);
            this.tv22=(TextView)itemView.findViewById(R.id.tv22);
            this.tv33=(TextView)itemView.findViewById(R.id.tv33);
            this.tv44=(TextView)itemView.findViewById(R.id.tv44);

        }
    }
}
