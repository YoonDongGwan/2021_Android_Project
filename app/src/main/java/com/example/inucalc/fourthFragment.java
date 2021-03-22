package com.example.inucalc;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class fourthFragment extends Fragment {
    List<String> score_list = null;
    List<percent> percentList = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout forx this fragment
        View v = inflater.inflate(R.layout.fragment_fourth, container, false);
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "grades")
                .build();
        db.gradesDAO().getGradesCount().observe(getViewLifecycleOwner(), new Observer<List<percent>>() {
            @Override
            public void onChanged(List<percent> percents) {
                percentList = percents;
                CustomProgressbar customProgressbar = v.findViewById(R.id.fourth_circleprogressbar);
                customProgressbar.drawlist(percentList,new Canvas());
            }
        });
        return v;
    }
}