package com.example.inucalc;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.List;

public class thirdFragment extends Fragment {
    double avg = 0;
    int progress;
    List<String> score_list = null;
    int point_sum;
    TextView total_score;
    TextView total_point;
    TextView rest_point;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        total_score = v.findViewById(R.id.third_total_score);
        total_point = v.findViewById(R.id.third_total_point);
        rest_point = v.findViewById(R.id.third_rest_point);
        CircleProgressBar circleProgressBar = v.findViewById(R.id.third_circleprogressbar);
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "grades")
                .build();
        db.gradesDAO().getElecScore().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> scores) {
                if (scores != null) {
                    score_list = scores;
                    for (int i = 0; i < score_list.size(); i++) {
                        switch (score_list.get(i)) {
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
                    progress = (int) ((avg / 4.5) * 100);
                    total_score.setText(Math.round(avg * 100) / 100.0 + "");
                    circleProgressBar.setProgress(progress);
                    ValueAnimator animator = ValueAnimator.ofInt(0, progress);
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            int on_progress = (int) animation.getAnimatedValue();
                            circleProgressBar.setProgress(on_progress);
                        }
                    });
                    animator.setDuration(500);
                    animator.start();
                }
            }
        });
        db.gradesDAO().getElecPoint().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer sum_point) {
                if (sum_point != null) {
                    point_sum = sum_point;
                    total_point.setText(point_sum + "");
                    rest_point.setText(55 - point_sum + "학점");
                }
            }
        });



        return v;
    }
}