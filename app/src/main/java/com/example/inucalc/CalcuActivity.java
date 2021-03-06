package com.example.inucalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalcuActivity extends AppCompatActivity {

    String[] List;
    AlertDialog.Builder builder;
    Button btn_page;

    int flag1=0;
    int flag2=0;
    int flag3=0;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);

        EditText et=findViewById(R.id.et1);
        Button btn_s1=findViewById(R.id.btn_selec1);
        Button btn_s2=findViewById(R.id.btn_selec2);
        Button btn_hg=findViewById(R.id.btn_hg);
        ImageButton btn_back=findViewById(R.id.btn_back);
        btn_page=findViewById(R.id.btn_page2);

        et.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode==event.KEYCODE_ENTER)
                {
                    et.setInputType(EditorInfo.TYPE_NULL);
                    try {
                        String str = et.getText().toString().trim();
                        int rt = Integer.parseInt(str);
                        int input=Integer.parseInt(et.getText().toString());//정수값 가져오기
                        flag1=1;
                        flagCheck();

                    } catch(NumberFormatException e){
                        Toast.makeText(getApplicationContext(), "숫자만 입력하세요", Toast.LENGTH_LONG).show();
                        flag1=0;
                    }
                }
                return false;
            }
        });

        btn_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2=1;
                flagCheck();
                btn_s2.setTextColor(Color.parseColor("#CCCCCC"));
                btn_s1.setTextColor(Color.parseColor("#FCAF17"));
            }
        });
        btn_s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag2=1;
                flagCheck();
                btn_s1.setTextColor(Color.parseColor("#CCCCCC"));
                btn_s2.setTextColor(Color.parseColor("#FCAF17"));
            }
        });

        btn_hg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List=getResources().getStringArray(R.array.hope_grade);
                builder = new AlertDialog.Builder(CalcuActivity.this);
                builder.setTitle("희망학점");
                builder.setNegativeButton("닫기",null);
                builder.setItems(List, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn_hg.setText(List[which]);
                        flag3=1;
                        flagCheck();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1)
                {
                   /* aiFragment aiFragment = new aiFragment();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.framelayout, aiFragment).commitAllowingStateLoss();
              */
                }
            }
        });
    }
    public void flagCheck()
    {
        if(flag1==1 && flag2==1 && flag3==1)
        {
            btn_page.setBackgroundColor(Color.parseColor("#FCAF17"));
            flag=1;
        }
    }
}
