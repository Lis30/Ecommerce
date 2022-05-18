package com.projects.mainscreen_activity.network;

import com.projects.mainscreen_activity.MainScreenUnite;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MainScreenAPI {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    Call<MainScreenUnite> getInfo();

}
