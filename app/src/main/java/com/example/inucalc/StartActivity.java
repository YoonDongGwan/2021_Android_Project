package com.example.inucalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    Button btn_m;
    Button btn_s;
    Button button;
    Button btn_page1;

    AlertDialog.Builder builder;

    String[] List;

    int flag1=0;
    int flag2=0;
    int flag3=0;
    int flag=0;
    String major="";
    String sID;
    String major2="";
    String submajor="복수전공(연계전공)";
    int pressDown=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn_m = findViewById(R.id.btn_major);
        btn_s = findViewById(R.id.btn_sID);
        button = findViewById(R.id.addMajor);
        btn_page1=findViewById(R.id.btn_page1);

        SharedPreferences check = getSharedPreferences("check",MODE_PRIVATE);
        SharedPreferences.Editor editor = check.edit();
        editor.putBoolean("page",false);
        editor.commit();

        // 전공, 학번 선택
        btn_m.setOnClickListener(new View.OnClickListener() {
            int i=0;
            String ti="전공선택";
            @Override
            public void onClick(View v) {
                showDialog(ti,i);
            }
        });
        btn_s.setOnClickListener(new View.OnClickListener() {
            int i=1;
            String ti="학번선택";
            @Override
            public void onClick(View v) {
                showDialog(ti,i);
            }
        });
        // frame 추가
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setVisibility(button.INVISIBLE);
                FrameLayout contentFrame = findViewById(R.id.frame); // 1. 기반이 되는 FrameLayout
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 2. inflater 생성
                inflater.inflate(R.layout.addinfo, contentFrame, true); // 3. (넣을 xml 파일명, 기반 layout 객체, true)
                flag=1;
                btn_check();

                RadioGroup rg=findViewById(R.id.radioGroup);
                RadioButton radio1=findViewById(R.id.radio1);
                RadioButton radio2=findViewById(R.id.radio2);

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==R.id.radio1)
                        {
                            submajor=radio1.getText().toString();
                        }
                        else if( checkedId==R.id.radio2)
                        {
                            submajor=radio2.getText().toString();
                        }
                    }
                });


                // 복수전공 추가
                Button btn_FM = findViewById(R.id.btn_FM);
                btn_FM.setOnClickListener(new View.OnClickListener() {
                    int i=2;
                    String ti="전공선택";
                    @Override
                    public void onClick(View v) {
                        flag=1;
                        showDialog(ti,i);
                        btn_check();
                    }
                });
                // frame cancel button
                ImageButton btn_cancle=findViewById(R.id.btn_cancel);
                btn_cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        contentFrame.removeAllViews();
                        button.setVisibility(button.VISIBLE);
                        flag=0; flag3=0;
                        btn_check();
                    }
                });

            }
        });
        btn_page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pressDown==1) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("major", btn_m.getText().toString());
                    intent.putExtra("sId", btn_s.getText().toString());
                    startActivity(intent);
                    finish();
                }
            }
        });


    }

    //다이얼로그 실행
    public void showDialog(String ti,int i){
        if (i==0 || i==2) List=getResources().getStringArray(R.array.majorList);
        else if(i==1) List=getResources().getStringArray(R.array.sIDList);
        builder=new AlertDialog.Builder(StartActivity.this);
        builder.setTitle(ti);
        builder.setNegativeButton("닫기",null);
        //다이얼로그에 리스트 담기
        builder.setItems(List, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                View view3 = findViewById(R.id.view3);
                TextView textView = findViewById(R.id.textView);
                if(i==0) {
                    btn_m.setTextColor(Color.parseColor("#000000"));
                    btn_m.setText(List[which]);
                    major=List[which];
                    flag1=1;
                    if(flag3==1)
                    {
                        if(major2.equals(major))
                        {
                            view3.setBackgroundColor(Color.parseColor("#FF0000"));
                            textView.setVisibility(textView.VISIBLE);
                            flag1=0;
                        }
                        else
                        {
                            view3.setBackgroundColor(Color.parseColor("#F0F0F0"));
                            textView.setVisibility(textView.INVISIBLE);
                        }
                    }

                }
                else if(i==1) {
                    btn_s.setTextColor(Color.parseColor("#000000"));
                    btn_s.setText(List[which]);
                    sID=List[which];
                    flag2=1;
                }
                else {
                    Button btn_FM = findViewById(R.id.btn_FM);
                    btn_FM.setTextColor(Color.parseColor("#000000"));
                    major2=List[which];
                    btn_FM.setText(major2);
                    flag3=1;
                    if(flag1==1)
                    {
                        if (major.equals(major2)) {
                            view3.setBackgroundColor(Color.parseColor("#FF0000"));
                            textView.setVisibility(textView.VISIBLE);
                            flag3=0;
                        }
                        else
                        {
                            view3.setBackgroundColor(Color.parseColor("#F0F0F0"));
                            textView.setVisibility(textView.INVISIBLE);
                        }
                    }
                }
                btn_check();
            }

        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void btn_check()
    {
        if(flag==0)
        {
            if(flag1==1 && flag2==1)
            {
                btn_page1.setBackgroundColor(Color.parseColor("#FCAF17"));
                pressDown=1;
            }
            else
            {
                btn_page1.setBackgroundColor(Color.parseColor("#E4E4E4"));
                pressDown=0;
            }
        }
        else
        {
            if(flag1==1 && flag2==1 && flag3==1)
            {
                btn_page1.setBackgroundColor(Color.parseColor("#FCAF17"));
                pressDown=1;
            }
            else
            {
                btn_page1.setBackgroundColor(Color.parseColor("#E4E4E4"));
                pressDown=0;
            }
        }
    }
}