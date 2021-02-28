package com.example.inucalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.dinuscxj.progressbar.CircleProgressBar;

public class firstFragment extends Fragment {
    int progress;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        double avg = 4.21/4.5;
        progress = (int)(avg*100);
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        CircleProgressBar circleProgressBar = v.findViewById(R.id.first_circleprogressbar);
        circleProgressBar.setProgress(progress);
        return v;
    }
}