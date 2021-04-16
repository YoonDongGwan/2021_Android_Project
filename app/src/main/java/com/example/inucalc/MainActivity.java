package com.example.inucalc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    FragmentManager fragmentManager = getSupportFragmentManager();
    homeFragment homeFragment = new homeFragment();
    aiFragment aiFragment = new aiFragment();
    cellFragment cellFragment = new cellFragment();
    mypageFragment mypageFragment = new mypageFragment();
    public int check=0;
    public int flag=0;
    public int recyclercount;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String maj = intent.getStringExtra("major");
        String sId = intent.getStringExtra("sId");
        Bundle bundle = new Bundle();
        bundle.putString("major",maj);
        bundle.putString("sId",sId);
        mypageFragment.setArguments(bundle);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, homeFragment).commitAllowingStateLoss();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnavi);
     //   fragmentTransaction.add(R.id.framelayout,PlusoneoneFragment.newinstance()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                switch(item.getItemId()){
                    case R.id.home:
                        transaction.replace(R.id.framelayout, homeFragment).commitAllowingStateLoss();
                        break;

                    case R.id.cell:
                        {
                            transaction.replace(R.id.framelayout, cellFragment).commitAllowingStateLoss();
                        }
                        break;

                    case R.id.ai:
                       /* if(check==1)
                        {
                            transaction.replace(R.id.framelayout, aiFragment).commitAllowingStateLoss();
                        }
                        else
                        {
                            check=1;*/
                            Intent intent = new Intent(getApplicationContext(), CalcuActivity.class);
                            startActivity(intent);
                    /*    }*/
                        break;

                    case R.id.mypage:
                        transaction.replace(R.id.framelayout, mypageFragment).commitAllowingStateLoss();
                        break;
                }

                return true;
            }
        });


    }

    /*
    public void replaceFragment(Fragment fragment){
       FragmentManager fragmentManager =getSupportFragmentManager();
       FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
       fragmentTransaction.replace(R.id.framelayout, fragment).commit();
    }
     */
}
