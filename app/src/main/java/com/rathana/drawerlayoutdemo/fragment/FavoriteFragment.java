package com.rathana.drawerlayoutdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rathana.drawerlayoutdemo.R;

public class FavoriteFragment extends Fragment {

    private static FavoriteFragment favoriteFragment;

    public static FavoriteFragment getInstance(){
        if(favoriteFragment==null)
            return new FavoriteFragment();
        return favoriteFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite,container,false);
    }
}
