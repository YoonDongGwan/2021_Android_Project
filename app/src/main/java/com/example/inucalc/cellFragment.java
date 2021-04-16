package com.example.inucalc;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import com.example.inucalc.oneoneFragment;
import com.example.inucalc.onetwoFragment;
import com.example.inucalc.twooneFragment;
import com.example.inucalc.twotwoFragment;
import com.example.inucalc.threeoneFragment;
import com.example.inucalc.threetwoFragment;
import com.example.inucalc.fouroneFragment;
import com.example.inucalc.fourtwoFragment;

import java.util.ArrayList;
import java.util.List;

public class cellFragment extends Fragment {
    private Context mContext;
    private TabLayout mTablayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cell, container, false);
        ViewPager2 viewPager = v.findViewById(R.id.viewpager3);
        ViewPagerAdapter2 adapter = new ViewPagerAdapter2(getChildFragmentManager(),getLifecycle());
        adapter.addFragment(new oneoneFragment());
        adapter.addFragment(new onetwoFragment());
        adapter.addFragment(new twooneFragment());
        adapter.addFragment(new twotwoFragment());
        adapter.addFragment(new threeoneFragment());
        adapter.addFragment(new threetwoFragment());
        adapter.addFragment(new fouroneFragment());
        adapter.addFragment(new fourtwoFragment());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = v.findViewById(R.id.tablayout2);

        // mTablayout=(TabLayout)v.findViewById(R.id.tablayout2);
        //mTablayout.addTab(mTablayout.newTab().setText("홈"));
        //mTablayout.addTab(mTablayout.newTab().setText("게임"));
        //mTablayout.addTab(mTablayout.newTab().setText("영화"));
        //mTablayout.addTab(mTablayout.newTab().setText("도서서"));

       String[] tabLabel = {"1학년 1학기","1학년 2학기","2학년 1학기","2학년 2학기", "3학년 1학기", "3학년 2학기", "4학년 1학기", "4학년 2학기"};
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                viewPager.setSaveEnabled(false);
                tab.setText(tabLabel[position]);
            }
        }).attach();

        return v;
    }

}