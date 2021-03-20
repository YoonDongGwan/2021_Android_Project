package com.example.inucalc;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.List;

public class firstFragment extends Fragment {
    double avg = 0;
    int progress;
    int point;
    List<String> score_list = null;
    List<Integer> point_list = null;
    TextView total_score;
    TextView total_point;
    TextView rest_point;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        AppDatabase db = Room.databaseBuilder(getContext(),AppDatabase.class,"grades")
                .allowMainThreadQueries()
                .build();
        score_list = db.gradesDAO().getScore();
        point_list = db.gradesDAO().getPoint();
        for(int i = 0; i< score_list.size(); i++){
            point += point_list.get(i);
            switch (score_list.get(i)){
                case "A+":
                    avg += 4.5;
                    break;
                case "A0":
                    avg += 4.0;
                    break;
                case "B+":
                    avg += 3.5;
                    break;
                case "B0":
                    avg += 3.0;
                    break;
                case "C+":
                    avg += 2.5;
                    break;
                case "C0":
                    avg += 2.0;
                    break;
                case "D+":
                    avg += 1.5;
                    break;
                case "D0":
                    avg += 1.0;
                    break;

            }
        }
        avg = (avg / score_list.size());
        progress = (int)((avg /4.5)*100);
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        total_score = v.findViewById(R.id.total_score);
        total_point = v.findViewById(R.id.total_point);
        rest_point = v.findViewById(R.id.rest_point);
        total_score.setText(avg+"");
        total_point.setText(point+"");
        rest_point.setText(140-point+"");
        CircleProgressBar circleProgressBar = v.findViewById(R.id.first_circleprogressbar);
        circleProgressBar.setProgress(progress);


        return v;
    }
}