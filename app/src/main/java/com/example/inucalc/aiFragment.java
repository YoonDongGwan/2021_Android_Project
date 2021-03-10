package com.example.inucalc;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class aiFragment extends Fragment {
    private ArrayList<Data_ai_recomm> arrayList;
    private Adapter_ai_recomm mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    ImageButton ib_modify;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ai, container, false);

        recyclerView = v.findViewById(R.id.rv);
        ib_modify = v.findViewById(R.id.ib_modify);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        mainAdapter = new Adapter_ai_recomm(arrayList);
        recyclerView.setAdapter(mainAdapter);   // 어댑터로부터 가져온 것을 리사이클러뷰에 셋팅

        for (int i = 0; i < 10; i++) {
            Data_ai_recomm mainData = new Data_ai_recomm(R.drawable.ic_undertry, "3학년 1학기", "전공", "5과목", "교양", "5과목");
            arrayList.add(mainData);
            mainAdapter.notifyDataSetChanged(); // 새로 고침까지 완료
        }

        ib_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CalcuActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}

