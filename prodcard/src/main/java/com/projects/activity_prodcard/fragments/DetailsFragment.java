package com.projects.activity_prodcard.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.activity_prodcard.R;


public class DetailsFragment extends CommonFragUnits {

    private static final int LAYOUT = R.layout.fragment_details;

    public static DetailsFragment getInstance(Context context) {
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();
        detailsFragment.setArguments(args);
        detailsFragment.setContext(context);
        detailsFragment.setTitle(context.getString(R.string.tab_details));
        return detailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(LAYOUT, container, false);
        return view;
    }
}