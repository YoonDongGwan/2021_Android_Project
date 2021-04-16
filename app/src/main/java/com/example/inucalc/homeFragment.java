package com.example.inucalc;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;


public class homeFragment extends Fragment {
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ViewPager2 viewPager = v.findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager(),getLifecycle());

        adapter.addFragment(new firstFragment());
        adapter.addFragment(new secondFragment());
        adapter.addFragment(new thirdFragment());
        adapter.addFragment(new fourthFragment());
        adapter.addFragment(new oneoneFragment());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = v.findViewById(R.id.tablayout1);
        //tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("홈")));
        //tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("게임")));
        //tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("영화")));
        //tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("도서")));
        String[] tabLabel = {"전체","교양별","전굥별", "전체"};
        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
              viewPager.setSaveEnabled(false);
                tab.setText(tabLabel[position]);
            }
        }).attach();
        return v;
    }
    private View createTabView(String tabName)
    {
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
        txt_name.setText(tabName);
        return tabView;
    }

}