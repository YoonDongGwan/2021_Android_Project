package com.example.inucalc;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.content.Context.MODE_PRIVATE;

public class mypageFragment extends Fragment {
    SharedPreferences uInfo;
    SharedPreferences.Editor editor;
    TextView major;
    TextView stuId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypage, container, false);
        Bundle bundle = getArguments();
        major = v.findViewById(R.id.major);
        stuId = v.findViewById(R.id.sId);
        Button btn_uInfo = v.findViewById(R.id.btn_uInfo);
        Button btn1 = v.findViewById(R.id.mypage_btn1);
        Button btn3 = v.findViewById(R.id.mypage_btn3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),webviewActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext())
                        .setMessage("ver 1.0.0").show();
            }
        });
        uInfo = getContext().getSharedPreferences("uInfo",MODE_PRIVATE);
        editor = uInfo.edit();
        major.setText(uInfo.getString("major","전공"));
        stuId.setText(uInfo.getString("sId","전공"));
        if(uInfo.getString("sub","0")!="0")
        {
            major.setText(major.getText()+" /"+uInfo.getString("subname","전공"));
        }
        btn_uInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditMajorActivity.class);
                startActivityForResult(intent,0);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==-1){
            major.setText(uInfo.getString("major","전공"));
            stuId.setText(uInfo.getString("sId","전공"));
            if(uInfo.getString("sub","0")!="0")
            {
                major.setText(major.getText()+" /"+uInfo.getString("subname","전공"));
            }
        }
    }
}