package com.example.inucalc;

import android.content.Context;
import android.graphics.Color;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
    private Context context;
    // Item의 클릭 상태를 저장할 array 객체
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    // 직전에 클릭됐던 Item의 position
    private int prePosition = -1;
    ImageView iv;
    @NonNull
    @Override
    public Adapter_ai_recomm.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recomm,parent,false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_ai_recomm.CustomerViewHolder holder, int position) {
        Data_ai_recomm data_ai_recomm = arrayList.get(position);

        holder.btn_detail.setImageResource(arrayList.get(position).getBtn_detail());
        holder.tv1.setText(arrayList.get(position).getTv1());
        holder.tv2.setText(arrayList.get(position).getTv2());
        holder.tv3.setText(arrayList.get(position).getTv3());
        holder.tv4.setText(arrayList.get(position).getTv4());
        holder.tv5.setText(arrayList.get(position).getTv5());

        boolean isExpendable = arrayList.get(position).isExpendable();
        holder.expendableLayout.setVisibility(isExpendable ? View .VISIBLE : View.GONE);

        if(isExpendable)
        {
            holder.header.setBackgroundColor(Color.parseColor("#FCAF17"));
            holder.tv1.setTextColor(Color.parseColor("#FFFFFF"));
            holder.btn_detail.setImageResource(R.drawable.ic_uptry);
            holder.tv2.setTextColor(Color.parseColor("#FCAF17"));
            holder.tv3.setTextColor(Color.parseColor("#FCAF17"));
            holder.tv4.setText("이수학점");
            holder.tv4.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tv5.setText("19");
            holder.tv5.setTextColor(Color.parseColor("#FFFFFF"));

        }
        else
        {
            holder.header.setBackgroundColor(Color.parseColor("#F9F9F9"));
            holder.tv1.setTextColor(Color.parseColor("#000000"));
            holder.btn_detail.setImageResource(R.drawable.ic_undertry);
            holder.tv2.setTextColor(Color.parseColor("#767676"));
            holder.tv3.setTextColor(Color.parseColor("#000000"));
            holder.tv4.setText("교양");
            holder.tv4.setTextColor(Color.parseColor("#767676"));
            holder.tv5.setText("5과목");
            holder.tv5.setTextColor(Color.parseColor("#000000"));

        }

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        ImageView btn_detail;
        TextView tv1,tv2,tv3,tv4,tv5;
        LinearLayout linearLayout;
        LinearLayout expendableLayout;
        View header;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_detail = (ImageView) itemView.findViewById(R.id.btn_detail);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            tv3 = (TextView) itemView.findViewById(R.id.tv3);
            tv4 = (TextView) itemView.findViewById(R.id.tv4);
            tv5 = (TextView) itemView.findViewById(R.id.tv5);
            linearLayout = itemView.findViewById(R.id.linearlayout);
            expendableLayout = itemView.findViewById(R.id.expendableLayout);
            header = itemView.findViewById(R.id.header);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Data_ai_recomm data_ai_recomm = arrayList.get(getAdapterPosition());
                    data_ai_recomm.setExpendable(!data_ai_recomm.isExpendable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}

