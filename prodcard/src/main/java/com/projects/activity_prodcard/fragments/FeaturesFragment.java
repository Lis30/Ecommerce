package com.projects.activity_prodcard.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.activity_prodcard.R;

public class FeaturesFragment extends CommonFragUnits {

    private static final int LAYOUT = R.layout.fragment_features;


    public static FeaturesFragment getInstance(Context context) {
        FeaturesFragment featuresFragment = new FeaturesFragment();
        Bundle args = new Bundle();
        featuresFragment.setArguments(args);
        featuresFragment.setContext(context);
        featuresFragment.setTitle(context.getString(R.string.tab_features));
        return featuresFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(LAYOUT, container, false);
        return view;
    }
}