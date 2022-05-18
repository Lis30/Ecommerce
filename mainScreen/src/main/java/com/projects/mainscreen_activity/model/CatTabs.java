package com.projects.mainscreen_activity.model;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.projects.mainscreen_activity.R;

import java.util.ArrayList;
import java.util.List;

public class CatTabs extends TabLayout {

  private List<Integer> icons;
    private List<String> titles;

    public CatTabs(@NonNull Context context) {
        super(context);
        init();
    }

    public CatTabs(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CatTabs(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

  private void init(){
        icons = new ArrayList<>();
        titles = new ArrayList<>();

      this.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

          @Override
          public void onTabSelected(Tab tab) {



              if (tab!= null && tab.getCustomView() != null){
                  TextView catName = tab.getCustomView().findViewById(R.id.categoryName);
                  TextView catBack = tab.getCustomView().findViewById(R.id.categoryBack);
                  catName.setTextColor(getResources().getColor(R.color.orange));
                  catBack.setBackgroundResource(R.drawable.z_orange_circle);
              }
          }

          @Override
          public void onTabUnselected(Tab tab) {

              if (tab != null && tab.getCustomView() != null){
                  TextView catName = tab.getCustomView().findViewById(R.id.categoryName);
                  TextView catBack = tab.getCustomView().findViewById(R.id.categoryBack);
                  catName.setTextColor(getResources().getColor(R.color.blue));
                  catBack.setBackgroundResource(R.drawable.z_white_rounded);
              }

          }

          @Override
          public void onTabReselected(Tab tab) {

          }
          });

  }

    public void setCats(List<Integer> icons, List<String> titles) {
        this.icons = icons;
        this.titles = titles;

        for (String title : this.titles) {
            Tab tab = newTab();
            tab.setCustomView(R.layout.tab_view_category);
            if(tab.getCustomView() != null){
                TextView name = tab.getCustomView().findViewById(R.id.categoryName);
                ImageView ic = tab.getCustomView().findViewById(R.id.categoryPic);

                name.setText(title);
                ic.setImageResource(icons.get(titles.indexOf(title)));
            }
            this.addTab(tab);
        }

    }

}
