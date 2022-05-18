package com.projects.activity_prodcard.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlendMode;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;

import com.projects.activity_prodcard.R;
import com.projects.activity_prodcard.viewModel.ShopData;

import at.markushi.ui.CircleButton;


public class ShopFragment extends CommonFragUnits {

    private static final int LAYOUT = R.layout.fragment_shop;


    public static ShopFragment getInstance(Context context) {
        ShopFragment shopFragment = new ShopFragment();
        shopFragment.setContext(context);
        shopFragment.setTitle(context.getString(R.string.tab_shop));
        return shopFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(LAYOUT, container, false);
         return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TextView chipTxt = view.findViewById(R.id.chipTxt);
        TextView  cameratxt = view.findViewById(R.id.cameratxt);
        TextView  memoryTxt = view.findViewById(R.id.memoryTxt);
        TextView  sdCardXtx = view.findViewById(R.id.sdCardTxt);
        CircleButton colorBtn1 = view.findViewById(R.id.button);
        CircleButton colorBtn2 = view.findViewById(R.id.button2);
        TextView  capacity1 = view.findViewById(R.id.first_cap);
        TextView  capacity2 = view.findViewById(R.id.second_cap);

        ShopData shopData = new ViewModelProvider(requireActivity()).get(ShopData.class);
        shopData.getData().observe(getViewLifecycleOwner(), resDescription -> {
            chipTxt.setText(resDescription.getCPU());
            cameratxt.setText(resDescription.getCamera());
            memoryTxt.setText(resDescription.getSsd());
            sdCardXtx.setText(resDescription.getSd());
            capacity1.setText(resDescription.getCapacity().get(0) + "  GB");
            capacity2.setText(resDescription.getCapacity().get(1) + "  GB");
            colorBtn1.setColor(Color.parseColor(resDescription.getColor().get(0)));
            colorBtn2.setColor(Color.parseColor(resDescription.getColor().get(1)));
        });

    View.OnClickListener click = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.button){
                    colorBtn1.setImageResource(R.drawable.ic_v);
                    colorBtn2.setImageResource(0);}

            else if (view.getId() == R.id.button2){
                    colorBtn1.setImageResource(0);
                    colorBtn2.setImageResource(R.drawable.ic_v);
                    }
            else if (view.getId() == R.id.first_cap) {

                capacity1.setBackgroundResource(R.drawable.z_orange_rounded);
                capacity1.setTextColor(Color.parseColor("#FFFFFFFF"));
                capacity2.setBackgroundResource(0);
                capacity2.setTextColor(Color.parseColor("#8D8D8D"));
            }
            else if (view.getId() == R.id.second_cap) {

                    capacity1.setBackgroundResource(0);
                    capacity1.setTextColor(Color.parseColor("#8D8D8D"));
                    capacity2.setBackgroundResource(R.drawable.z_orange_rounded);
                    capacity2.setTextColor(Color.parseColor("#FFFFFFFF"));

            }
        }
    };

    colorBtn1.setOnClickListener(click);
    colorBtn2.setOnClickListener(click);
    capacity1.setOnClickListener(click);
    capacity2.setOnClickListener(click);

    }


}