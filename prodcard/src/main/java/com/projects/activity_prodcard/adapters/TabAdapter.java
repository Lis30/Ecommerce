package com.projects.activity_prodcard.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.projects.activity_prodcard.R;
import com.projects.activity_prodcard.fragments.CommonFragUnits;
import com.projects.activity_prodcard.fragments.DetailsFragment;
import com.projects.activity_prodcard.fragments.FeaturesFragment;
import com.projects.activity_prodcard.fragments.ShopFragment;

import java.util.HashMap;
import java.util.Map;


public class TabAdapter extends FragmentPagerAdapter {

    private Map<Integer, CommonFragUnits> tabs;
    private Context context;

    public TabAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        this.context = context;
        initTabs(context);
           }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabs(Context context){
        tabs = new HashMap<>();
        tabs.put(0, ShopFragment.getInstance(context));
        tabs.put(1, DetailsFragment.getInstance(context));
        tabs.put(2, FeaturesFragment.getInstance(context));
    }

}
