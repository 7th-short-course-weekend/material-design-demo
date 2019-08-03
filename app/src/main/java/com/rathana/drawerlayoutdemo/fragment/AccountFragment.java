package com.rathana.drawerlayoutdemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rathana.drawerlayoutdemo.R;

public class AccountFragment extends Fragment {

    private static AccountFragment accountFragment;

    public static AccountFragment getInstance(){
        if(accountFragment==null)
            return new AccountFragment();
        return accountFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account,container,false);
    }
}
