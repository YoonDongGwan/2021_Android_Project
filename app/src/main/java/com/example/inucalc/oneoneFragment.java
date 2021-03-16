package com.example.inucalc;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dinuscxj.progressbar.CircleProgressBar;

public class oneoneFragment extends Fragment {
    int progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //double avg = 4.21/4.5;
        //progress = (int)(avg*100);
        View v = inflater.inflate(R.layout.fragment_1_1, container, false);
        //CircleProgressBar circleProgressBar = v.findViewById(R.id.first_circleprogressbar);
        //circleProgressBar.setProgress(progress);

        Button btn_0=v.findViewById((R.id.button_));
        btn_0.setPaintFlags(btn_0.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 수정하기가 눌렸을 때
                Toast.makeText(getActivity(),"0번 버튼",Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}