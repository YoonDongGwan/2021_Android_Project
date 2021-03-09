package com.example.inucalc;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class cellFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cell, container, false);

        Button btn_0=v.findViewById(R.id.button_0);
        Button btn_1=v.findViewById(R.id.button_1);
        Button btn_2=v.findViewById(R.id.button_2);
        Button btn_3=v.findViewById(R.id.button_3);
        Button btn_4=v.findViewById(R.id.button_4);
        Button btn_5=v.findViewById(R.id.button_5);
        Button btn_6=v.findViewById(R.id.button_6);
        Button btn_7=v.findViewById(R.id.button_7);
        Button btn_8=v.findViewById(R.id.button_8);
        RecyclerView recyclerView = v.findViewById(R.id.cellRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 수정하기가 눌렸을 때
                Toast.makeText(getActivity(),"0번 버튼",Toast.LENGTH_LONG).show();
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1학년 1학기가 눌렸을 때
                Toast.makeText(getActivity(),"1번 버튼", LENGTH_LONG).show();
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1학년 2학기가 눌렸을 때
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 2학년 1학기가 눌렸을 때
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 2학년 2학기가 눌렸을 때
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 3학년 1학기가 눌렸을 때
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 3학년 2학기가 눌렸을 때
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 4학년 1학기가 눌렸을 때
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 4학년 2학기가 눌렸을 때
            }
        });

        return v;
    }

}