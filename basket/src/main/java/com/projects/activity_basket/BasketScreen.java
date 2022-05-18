package com.projects.activity_basket;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.projects.activity_basket.adapters.ProdInBasketAdapter;
import com.projects.activity_basket.model.Basket;
import com.projects.activity_basket.network.BasketAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BasketScreen extends AppCompatActivity {

    RecyclerView PIBRecycler;
    ProdInBasketAdapter pibAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_basket);

        GetData();

    }




public void GetData(){

    TextView totalPrice = findViewById(R.id.totalPrice);
    TextView deliveryPrice = findViewById(R.id.deliveryPrice);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    BasketAPI basketAPI = retrofit.create(BasketAPI.class);

    Call<Basket> call = basketAPI.getInfo();

    call.enqueue(new Callback<Basket>() {
        @Override
        public void onResponse(Call<Basket> call, Response<Basket> response) {
            if (response.isSuccessful()){
                Basket basket = response.body();

                pibAdapter.addItems(basket.getBasket());
                totalPrice.setText(basket.getTotal()) ;
                deliveryPrice.setText(basket.getDelivery());

            }
        }

        @Override
        public void onFailure(Call<Basket> call, Throwable t) {

        }
    });


    SetPIBSettings();

}

    public void SetPIBSettings(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        PIBRecycler = findViewById(R.id.orderlist);
        PIBRecycler.setLayoutManager(layoutManager);
        pibAdapter = new ProdInBasketAdapter(this);
        PIBRecycler.setAdapter(pibAdapter);
    }


}