package com.example.inucalc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;


public class threetwoActivity extends AppCompatActivity {
    String[] List;
    AlertDialog.Builder builder;
    Button btn_page;
    Button btn_return;
    Button btn_plus;
    Button btn_delete;

    int flag1=0;
    int flag2=0;
    int flag3=0;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_plus_3_2);
        btn_plus=findViewById(R.id.button_plus);
        btn_return=findViewById(R.id.button_return);
        btn_delete=findViewById(R.id.button_delete);

        RecyclerView recyclerView = findViewById(R.id.cellRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter2 adapter = new RecyclerAdapter2();
        recyclerView.setAdapter(adapter);

        btn_return.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                finish();
            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){

            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){

            }
        });

    }

}