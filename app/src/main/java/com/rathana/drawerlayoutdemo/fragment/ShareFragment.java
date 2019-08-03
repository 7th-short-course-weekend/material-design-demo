package com.rathana.drawerlayoutdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rathana.drawerlayoutdemo.R;

public class ShareFragment extends Fragment {

    private static ShareFragment shareFragment;

    public static ShareFragment getInstance(){
        if(shareFragment==null)
            return new ShareFragment();
        return shareFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_share,container,false);
    }
}
