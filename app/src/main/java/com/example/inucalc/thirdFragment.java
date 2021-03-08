package com.example.inucalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.dinuscxj.progressbar.CircleProgressBar;

public class thirdFragment extends Fragment {

    int progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        double avg = 2.50/4.5;
        progress = (int)(avg*100);
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        CircleProgressBar circleProgressBar = v.findViewById(R.id.third_circleprogressbar);
        circleProgressBar.setProgress(progress);
        return v;
    }
}