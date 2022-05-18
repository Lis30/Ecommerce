package com.projects.activity_basket.network;

import com.projects.activity_basket.model.Basket;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BasketAPI {

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    Call<Basket> getInfo();

}
