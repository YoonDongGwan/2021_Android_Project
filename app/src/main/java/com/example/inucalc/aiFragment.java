package com.example.inucalc;

import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class aiFragment extends Fragment {
    private ArrayList<Data_ai_recomm> arrayList;
    private Adapter_ai_recomm mainAdapter;
    private RecyclerView recyclerView;

    private Adapter_ai_recomm2 mainAdapter2;
    private RecyclerView recyclerView2;

    ImageButton ib_modify;
    List<retakeTuple> tuple;
    Integer cnt;
    List<String> semList = Arrays.asList("1학년 1학기", "1학년 2학기","2학년 1학기", "2학년 2학기", "3학년 1학기","3학년 2학기","4학년 1학기", "4학년 2학기");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ai, container, false);
        ib_modify = v.findViewById(R.id.ib_modify);
        recyclerView = v.findViewById(R.id.rv);
        recyclerView2 = v.findViewById(R.id.rv2);

        AppDatabase db = Room.databaseBuilder(getContext(),AppDatabase.class,"grades")
                .allowMainThreadQueries()
                .build();

    //    initData();
   //     setRecyclerView();
        arrayList = new ArrayList<>();
        cnt = db.gradesDAO().semCnt();
        for(int i=0;i<8-cnt;i++)
        {
            arrayList.add(new Data_ai_recomm(R.drawable.ic_undertry, semList.get(i + cnt), "전공", "5과목", "교양", "5과목"));
            // mainAdapter.notifyDataSetChanged();
        }
        mainAdapter = new Adapter_ai_recomm(arrayList);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setHasFixedSize(true);

////

        tuple = db.gradesDAO().retack();
        mainAdapter2 = new Adapter_ai_recomm2(tuple);
        recyclerView2.setAdapter(mainAdapter2);
////
        ib_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CalcuActivity.class);
                startActivity(intent);
            }
        });



        return v;
    }
    private void setRecyclerView() {
        mainAdapter = new Adapter_ai_recomm(arrayList);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private void initData() {
        arrayList = new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            arrayList.add(new Data_ai_recomm(R.drawable.ic_undertry, "3학년 1학기", "전공", "5과목", "교양", "5과목"));
            // mainAdapter.notifyDataSetChanged();
        }
    }
}

