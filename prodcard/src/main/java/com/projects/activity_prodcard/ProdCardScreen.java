package com.projects.activity_prodcard;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.projects.activity_prodcard.adapters.PictureAdapter;
import com.projects.activity_prodcard.adapters.TabAdapter;
import com.projects.activity_prodcard.viewModel.ShopData;
import com.projects.activity_prodcard.repository.ApiCaller;
import com.projects.activity_prodcard.repository.ResDescription;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ProdCardScreen extends AppCompatActivity {

    TabLayout tabs;
    ViewPager fragments;
    RecyclerView pictures;
    PictureAdapter pictureAdapter;
    ShopData shopData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_prodcard);

        GetData();
        initTabs();


    }


    public void initTabs(){

        fragments = findViewById(R.id.prod_description);
        TabAdapter adapter = new TabAdapter(this, getSupportFragmentManager());
        fragments.setAdapter(adapter);
        tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(fragments);

    }

    public void GetData(){

        TextView price = findViewById(R.id.prodcard_price);
        AppCompatRatingBar rating = findViewById(R.id.ratingBar);
        ImageView heartIc = findViewById(R.id.heartIc);
        ImageView addToFavor = findViewById(R.id.prodcard_heartBtn);
        TextView title = findViewById(R.id.nameOfModel);

        shopData = new ViewModelProvider(this).get(ShopData.class);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiCaller apiCaller = retrofit.create(ApiCaller.class);

        Call<ResDescription> call = apiCaller.GetInfo();

        call.enqueue(new Callback<ResDescription>() {
            @Override
            public void onResponse(@NonNull Call<ResDescription> call, @NonNull Response<ResDescription> response) {
                if (response.isSuccessful()){
                    ResDescription resDescription = response.body();

                    assert resDescription != null;
                    price.setText("$ " + resDescription.getPrice());
                    rating.setRating(resDescription.getRating());
                    title.setText(resDescription.getTitle());
                    pictureAdapter.addItems(resDescription.getImages());
                    shopData.setData(resDescription);


                    if (resDescription.getIsFavorites()){
                        heartIc.setImageResource(R.drawable.ic_white_heart);
                    }else { heartIc.setImageResource(R.drawable.ic_heart);}

                    addToFavor.setOnClickListener(view -> {
                boolean favor = resDescription.getIsFavorites();
                        if (favor){
                            heartIc.setImageResource(R.drawable.ic_heart);
                            resDescription.setFavorites(false);
                        }else {
                            heartIc.setImageResource(R.drawable.ic_white_heart);
                            resDescription.setFavorites(true);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<ResDescription> call, Throwable t) {
               List <String> photos = new ArrayList<>();
               photos.add("https://clck.ru/frJCu"); //если ссылка не будет доступна, отобразится дефолтное фото

            }
        });
        SetPicSettings();

    }

    public void SetPicSettings() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,
                false);
        pictures = findViewById(R.id.prodcard_itemPic);
        pictures.setLayoutManager(layoutManager);
        pictureAdapter = new PictureAdapter(this);
        pictures.setAdapter(pictureAdapter);
    }


}