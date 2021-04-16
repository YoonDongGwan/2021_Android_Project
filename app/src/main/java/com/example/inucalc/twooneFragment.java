package com.example.inucalc;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dinuscxj.progressbar.CircleProgressBar;

public class twooneFragment extends cellFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2_1, container, false);

        Button btn_0=v.findViewById((R.id.button_));
        RecyclerView recyclerView = v.findViewById(R.id.cellRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        btn_0.setPaintFlags(btn_0.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity a=(MainActivity)getActivity();
                Intent intent = new Intent(a.getApplicationContext(), twooneActivity.class);
                startActivity(intent);
            }
        });
        return v;
    }
}