package com.rathana.drawerlayoutdemo;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.rathana.drawerlayoutdemo.fragment.AccountFragment;
import com.rathana.drawerlayoutdemo.fragment.FavoriteFragment;
import com.rathana.drawerlayoutdemo.fragment.HomeFragment;
import com.rathana.drawerlayoutdemo.fragment.SettingFragment;
import com.rathana.drawerlayoutdemo.fragment.ShareFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init view
        toolbar=findViewById(R.id.toolbar);
        mDrawer=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.nav);

        //add toolbar to activity
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");

        toggle=setupDrawerToggle();
        mDrawer.addDrawerListener(toggle);

        //setNavigation View Listener
        setupNavigationViewListener(navigationView);
        //add home fragment
        //replaceFragment("Home",HomeFragment.getInstance(),R.id.container);
        FragmentTransaction t= getSupportFragmentManager().beginTransaction();
        t.add(R.id.container,HomeFragment.getInstance());
        t.commit();
    }

    private void setupNavigationViewListener(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case  R.id.home:
                        replaceFragment("Home",HomeFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.favorite:
                        replaceFragment("Favorite",FavoriteFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.account:
                        replaceFragment("Account",AccountFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.share:
                        replaceFragment("Share",ShareFragment.getInstance(),R.id.container);
                        return true;
                    case R.id.setting:
                        replaceFragment("Setting",SettingFragment.getInstance(),R.id.container);
                        return true;
                }

                return false;
            }
        });


    }

    private ActionBarDrawerToggle setupDrawerToggle(){
        return new ActionBarDrawerToggle(
                this,
                mDrawer,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }


    private void replaceFragment(String title,Fragment fragment, @IdRes int container){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();

        Fragment f=fragmentManager.findFragmentById(container);
        if(f==null || !f.getClass().getName().equals(fragment.getClass().getName())){
            transaction.replace(container,fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        toolbar.setTitle(title);
        mDrawer.closeDrawers();
    }

}
