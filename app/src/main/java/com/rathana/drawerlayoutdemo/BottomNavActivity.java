package com.rathana.drawerlayoutdemo;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rathana.drawerlayoutdemo.fragment.AccountFragment;
import com.rathana.drawerlayoutdemo.fragment.FavoriteFragment;
import com.rathana.drawerlayoutdemo.fragment.HomeFragment;
import com.rathana.drawerlayoutdemo.fragment.SettingFragment;
import com.rathana.drawerlayoutdemo.fragment.ShareFragment;

public class BottomNavActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottomNav);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        //default acreen
        FragmentTransaction t= getSupportFragmentManager().beginTransaction();
        t.add(R.id.container, HomeFragment.getInstance());
        t.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case  R.id.home:
                        replaceFragment("Home",HomeFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.favorite:
                        replaceFragment("Favorite", FavoriteFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.account:
                        replaceFragment("Account", AccountFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.share:
                        replaceFragment("Share", ShareFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.setting:
                        replaceFragment("Setting", SettingFragment.getInstance(),R.id.container);
                        return true;
                }


                return false;
            }
        });


    }

    private void replaceFragment(String title, Fragment fragment, @IdRes int container){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        Fragment f=fragmentManager.findFragmentById(container);
        if(f==null || !f.getClass().getName().equals(fragment.getClass().getName())){
            transaction.replace(container,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        toolbar.setTitle(title);
    }
}
