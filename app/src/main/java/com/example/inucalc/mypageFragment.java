package com.example.inucalc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypage, container, false);
        Bundle bundle = getArguments();
        TextView major = v.findViewById(R.id.major);
        TextView stuId = v.findViewById(R.id.sId);
        Button btn_uInfo = v.findViewById(R.id.btn_uInfo);

        SharedPreferences uInfo = getContext().getSharedPreferences("uInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = uInfo.edit();
        major.setText(uInfo.getString("major","전공"));
        stuId.setText(uInfo.getString("sId","전공"));
        if(uInfo.getString("sub","0")!="0")
        {
            major.setText(major.getText()+" /"+uInfo.getString("subname","전공"));
        }
        btn_uInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StartActivity.class);
                startActivity(intent);
                //finish();
            }
        });


        return v;
    }
}