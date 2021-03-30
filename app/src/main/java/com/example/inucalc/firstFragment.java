package com.example.inucalc;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class firstFragment extends Fragment {
    double avg = 0;
    int progress;
    List<String> score_list = null;
    int point_sum;
    TextView total_score;
    TextView total_point;
    TextView rest_point;
    SharedPreferences uInfo;
    SharedPreferences.Editor editor;
    int need_point = 135;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        total_score = v.findViewById(R.id.first_total_score);
        total_point = v.findViewById(R.id.first_total_point);
        rest_point = v.findViewById(R.id.first_rest_point);
        uInfo = getContext().getSharedPreferences("uInfo",MODE_PRIVATE);
        editor = uInfo.edit();
        switch (uInfo.getString("major","전공")){
            case "사회복지학과": case "경제학과": case "무역학부": case "경영학부": case "세무회계학과": case "조형예술학부": case "한국화전공":  case "서양화전공": case "디자인학부": case "공연예술학과": case "체육학부":
                need_point = 130;
                break;
            case "전기공학과": case "신소재공학과": case "안전공학과": case "에너지화학공학과": case "메카트로닉스공학과": case "컴퓨터공학부": case "정보통신공학과": case "임베디드시스템공학과": case "도시환경공학부": case "건설환경공학전공": case "환경공학전공": case "도시공학과": case "": case "도시건축학전공": case "생명공학전공": case "나노바이오전공": case "생명공학부":
                need_point = 140;
                break;
        }
        CircleProgressBar circleProgressBar = v.findViewById(R.id.first_circleprogressbar);
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "grades")
                .build();
        db.gradesDAO().getScore().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> scores) {
                if(scores != null){
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
                total_score.setText(Math.round(avg*100)/100.0 + "");
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
        db.gradesDAO().getPoint().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer sum_point) {
                if(sum_point != null){
                point_sum = sum_point;
                total_point.setText(point_sum + "");
                rest_point.setText(need_point - point_sum + "학점");
            }
            }
        });



        return v;
    }
}