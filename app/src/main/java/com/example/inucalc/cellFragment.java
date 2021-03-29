package com.example.inucalc;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class cellFragment extends Fragment {
    EditText editName;
    EditText editSort;
    EditText editGrade;
    Button btn;
    List<grades> grades_list = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cell, container, false);
        editName = v.findViewById(R.id.E_N);
        editSort = v.findViewById(R.id.E_S);
        editGrade = v.findViewById(R.id.E_G);
        btn = v.findViewById(R.id.insert_btn);
        AppDatabase db = Room.databaseBuilder(getContext(),AppDatabase.class,"grades")
                .build();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new InsertAsyncTask(db.gradesDAO()).execute(new grades("1학년 1학기",editName.getText().toString(),editSort.getText().toString(),editGrade.getText().toString(),3));
            }
        });
        RecyclerView recyclerView = v.findViewById(R.id.cellRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        db.gradesDAO().getAll().observe(getViewLifecycleOwner(), new Observer<List<grades>>() {
            @Override
            public void onChanged(List<grades> grades) {
                grades_list = grades;
                RecyclerAdapter adapter = new RecyclerAdapter(grades_list);
                recyclerView.setAdapter(adapter);
            }
        });

        return v;
    }
    public static class InsertAsyncTask extends AsyncTask<grades, Void, Void> {
        private gradesDAO mgradesDao;

        public  InsertAsyncTask(gradesDAO mgradesDao){
            this.mgradesDao = mgradesDao;
        }

        @Override //백그라운드작업(메인스레드 X)
        protected Void doInBackground(grades... grades) {
            mgradesDao.insert(grades[0]);
            return null;
        }
    }
}