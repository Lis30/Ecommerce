package com.projects.activity_prodcard.repository;

import android.content.res.Resources;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCaller {

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    Call<ResDescription> GetInfo() ;

}
