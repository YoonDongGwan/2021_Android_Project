package com.example.inucalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class cellFragment extends Fragment {

    EditText editName;
    EditText editSort;
    EditText editGrade;
    List<grades> grades;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cell, container, false);
        editName = v.findViewById(R.id.E_N);
        editSort = v.findViewById(R.id.E_S);
        editGrade = v.findViewById(R.id.E_G);
        btn = v.findViewById(R.id.insert_btn);
        AppDatabase db = Room.databaseBuilder(getContext(),AppDatabase.class,"grades")
                .allowMainThreadQueries()
                .build();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.gradesDAO().insert(new grades("1학년 1학기",editName.getText().toString(),editSort.getText().toString(),editGrade.getText().toString(),3));
            }
        });
        grades = db.gradesDAO().getAll();
        RecyclerView recyclerView = v.findViewById(R.id.cellRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapter adapter = new RecyclerAdapter(grades);
        recyclerView.setAdapter(adapter);

        return v;
    }
}