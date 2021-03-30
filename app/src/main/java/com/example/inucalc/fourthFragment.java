package com.example.inucalc;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.List;

public class fourthFragment extends Fragment {
    List<percent> percentList = null;
    TextView most_grade, most_percent;
    View[] colorviews = new View[6];
    TextView[] colorview_text = new TextView[6];
    TextView[] colorview_percent = new TextView[6];
    float count= 0;
    int index = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout forx this fragment
        View v = inflater.inflate(R.layout.fragment_fourth, container, false);
        AppDatabase db = Room.databaseBuilder(getContext(), AppDatabase.class, "grades")
                .build();
        for( int i=0; i<6; i++){
            colorviews[i] = v.findViewById(getResources().getIdentifier("colorview"+(i+1), "id", "com.example.inucalc"));
            colorview_text[i] = v.findViewById(getResources().getIdentifier("colorview_text"+(i+1), "id", "com.example.inucalc"));
            colorview_percent[i] = v.findViewById(getResources().getIdentifier("colorview_percent"+(i+1), "id", "com.example.inucalc"));
        }
        most_grade = v.findViewById(R.id.most_grade);
        most_percent = v.findViewById(R.id.most_percent);
        db.gradesDAO().getGradesCount().observe(getViewLifecycleOwner(), new Observer<List<percent>>() {
            @Override
            public void onChanged(List<percent> percents) {
            if(percents.size() != 0) {
                percentList = percents;
                for (int i = 0; i < percentList.size(); i++) {
                    count += percentList.get(i).percent;
                }

                float temp_percent = percentList.get(0).percent;
                CustomProgressbar customProgressbar = v.findViewById(R.id.fourth_circleprogressbar);
                customProgressbar.putList(percentList);
                customProgressbar.invalidate();
                for (int i = 0; i < percents.size(); i++) {
                    switch (percents.get(i).grade) {
                        case "A+":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(255, 114, 114));
                            colorview_text[i].setText("A+");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "A0":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(252, 175, 23));
                            colorview_text[i].setText("A0");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "B+":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(186, 234, 0));
                            colorview_text[i].setText("B+");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "B0":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(94, 172, 250));
                            colorview_text[i].setText("B0");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "C+":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(221, 140, 226));
                            colorview_text[i].setText("C+");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "C0":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(0, 234, 164));
                            colorview_text[i].setText("C0");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "D+":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(255, 109, 182));
                            colorview_text[i].setText("D+");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                        case "D0":
                            colorviews[i].setVisibility(View.VISIBLE);
                            colorview_text[i].setVisibility(View.VISIBLE);
                            colorview_percent[i].setVisibility(View.VISIBLE);
                            colorviews[i].setBackgroundColor(Color.rgb(123, 227, 243));
                            colorview_text[i].setText("D0");
                            colorview_percent[i].setText((int) ((percents.get(i).percent / count) * 100) + "%");
                            break;
                    }
                    if (temp_percent < percentList.get(i).percent) {
                        temp_percent = percentList.get(i).percent;
                        index = i;
                    }
                }
                most_grade.setText(percentList.get(index).grade);
                most_percent.setText("/" + (int) ((percentList.get(index).percent / count) * 100) + "%");
            }
            }
        });
        return v;
    }
}
