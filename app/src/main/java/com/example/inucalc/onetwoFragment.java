package com.example.inucalc;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class onetwoFragment extends cellFragment {
    protected static volatile int instanceCount;

    public onetwoFragment(){
        //TODO Auto-generated constructor stub
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //double avg = 3.78/4.5;
        //progress = (int)(avg*100);
        View v = inflater.inflate(R.layout.fragment_1_2, container, false);
        //CircleProgressBar circleProgressBar = v.findViewById(R.id.second_circleprogressbar);
        //circleProgressBar.setProgress(progress);

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
                Intent intent = new Intent(a.getApplicationContext(), onetwoActivity.class);
                startActivity(intent);
                //startActivity(intent);
                //FragmentTransaction fragmentTransaction= getChildFragmentManager().beginTransaction();
                //FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                //transaction.add(R.id.framelayout, PlusoneoneFragment).commitAllowingStateLoss();

                // 수정하기가 눌렸을 때
                Toast.makeText(getActivity(),"1번 버튼",Toast.LENGTH_LONG).show();
                //  ((MainActivity)getActivity()).replaceFragment(PlusoneoneFragment.newinstnace());
            }
        });
        return v;
    }

}