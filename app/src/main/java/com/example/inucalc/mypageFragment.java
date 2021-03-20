package com.example.inucalc;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class mypageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mypage, container, false);
        Bundle bundle = getArguments();
        TextView major = v.findViewById(R.id.major);
        TextView stuId = v.findViewById(R.id.sId);
        String submajor = bundle.getString("subMajor");
        if(submajor != null){
        major.setText(bundle.getString("major")+" / "+submajor);
        }
        else{
            major.setText(bundle.getString("major"));
        }
        stuId.setText(bundle.getString("sId"));

        return v;
    }
}