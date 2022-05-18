package com.projects.activity_prodcard.fragments;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;

public class CommonFragUnits extends Fragment {
    private String title;

    private Context context;
    private View view;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
