package com.projects.mainscreen_activity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.projects.mainscreen_activity.model.BestSellers;
import com.projects.mainscreen_activity.model.HotSales;

import java.util.ArrayList;
import java.util.List;


public class MainScreenUnite {

    @SerializedName("home_store")
    @Expose
    ArrayList<HotSales> home_store;

    @SerializedName("best_seller")
    @Expose
    ArrayList<BestSellers> best_seller;

    public ArrayList<HotSales> getHome_store() {
        return home_store;
    }
     public ArrayList<BestSellers> getBest_seller() {
        return best_seller;
    }
}
