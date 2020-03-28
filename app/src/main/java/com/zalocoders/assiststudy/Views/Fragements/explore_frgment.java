package com.zalocoders.assiststudy.Views.Fragements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zalocoders.assiststudy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class explore_frgment extends Fragment {

    public explore_frgment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore_frgment, container, false);
    }
}
