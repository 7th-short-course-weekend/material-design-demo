package com.rathana.drawerlayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.rathana.drawerlayoutdemo.adapter.ViewPagerAdapter;
import com.rathana.drawerlayoutdemo.fragment.AccountFragment;
import com.rathana.drawerlayoutdemo.fragment.FavoriteFragment;
import com.rathana.drawerlayoutdemo.fragment.HomeFragment;
import com.rathana.drawerlayoutdemo.fragment.SettingFragment;
import com.rathana.drawerlayoutdemo.fragment.ShareFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TablayoutActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);

        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        fragments.add(HomeFragment.getInstance());
        fragments.add(FavoriteFragment.getInstance());
        fragments.add(ShareFragment.getInstance());
        fragments.add(SettingFragment.getInstance());
        fragments.add(AccountFragment.getInstance());

        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                
            }

            @Override
            public void onPageSelected(int i) {
                Log.e(TAG, "onPageSelected: "+i );
                setScreenTitle(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private static final String TAG = "TablayoutActivity";
    private void setScreenTitle(int i){
        if(i==0)
            toolbar.setTitle("Home");
        else if(i==1)
            toolbar.setTitle("Favorite");
        else if(i==2)
            toolbar.setTitle("Share");
        else if(i==3)
            toolbar.setTitle("Setting");
        else
            toolbar.setTitle("Account");
    }
}
