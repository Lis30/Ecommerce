package com.projects.mainscreen_activity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.projects.mainscreen_activity.adapters.BSAdapter;
import com.projects.mainscreen_activity.adapters.HSAdapter;
import com.projects.mainscreen_activity.model.BestSellers;
import com.projects.mainscreen_activity.model.CatTabs;
import com.projects.mainscreen_activity.model.HotSales;
import com.projects.mainscreen_activity.network.MainScreenAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainScreen extends AppCompatActivity {

    RecyclerView HSRecycler, BSRecycler;
    HSAdapter HS_Adapter;
    BSAdapter BS_Adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetCat();
        GetData();
        GetFilter();

    }


private void SetCat(){

    List<Integer> icons = Arrays.asList(
            R.drawable.ic_phone,
            R.drawable.ic_computer,
            R.drawable.ic_health,
            R.drawable.ic_books,
            R.drawable.ic_food);

    List<String> names = Arrays.asList(
            "Phones",
            "Computers",
            "Health",
            "Books",
            "Food");

    CatTabs categories = findViewById(R.id.categories);
    categories.setCats(icons, names);

}






    public void GetData() {

          Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MainScreenAPI msAPI = retrofit.create(MainScreenAPI.class);

        Call<MainScreenUnite> call = msAPI.getInfo();

        call.enqueue(new Callback<MainScreenUnite>() {
            @Override
            public void onResponse(Call<MainScreenUnite> call, Response<MainScreenUnite> response) {
                if (response.isSuccessful()) {

                    MainScreenUnite MSUnite = response.body();

                    HS_Adapter.addItems(MSUnite.getHome_store());
                    BS_Adapter.addItems(MSUnite.getBest_seller());

                }

            }

            @Override
            public void onFailure(Call<MainScreenUnite> call, Throwable t) {

                // если ссылка не будет доступна, на странице будет показываться дефолтный товар. нужно при условии,
                // что могут быть сбои в работе сервера или у покупателя. Можно заменить на что-то ещё

                List<HotSales> hotSales = new ArrayList<>();
                List<BestSellers> bestSellers = new ArrayList<>();

                hotSales.add(new HotSales(1, true, "Iphone 12", "Súper. Mega. Rápido.",
                        "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg", true));
                bestSellers.add(new BestSellers(111, true, "Samsung Galaxy s20 Ultra", "1047",
                        "1500", "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg"));


                HS_Adapter.addItems(hotSales);
                BS_Adapter.addItems(bestSellers);

            }
        });

        SetHSSettings();
        SetBSSettings();

    }



    public void SetHSSettings() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,
                false);
        HSRecycler = findViewById(R.id.commercial);
        HSRecycler.setLayoutManager(layoutManager);
        HS_Adapter = new HSAdapter(this);
        HSRecycler.setAdapter(HS_Adapter);
    }

    public void SetBSSettings() {
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        BSRecycler = findViewById(R.id.catalog);
        BSRecycler.setLayoutManager(layoutManager);
        BS_Adapter = new BSAdapter(this);
        BSRecycler.setAdapter(BS_Adapter);
    }

    public void GetFilter(){
        ImageView ic_filter = findViewById(R.id.ic_filter);

        ic_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        MainScreen.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(R.layout.fragment_search, findViewById(R.id.bottomSheetContainer));


                bottomSheetView.findViewById(R.id.back_cross).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                //тут надо будет дописать работу самого фильтра. Т.к. в задании этого не было, это не реализовано

                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }

public void SetFilterSettings(){

    setContentView(R.layout.fragment_search);

        Spinner brands = findViewById(R.id.brands);
ArrayAdapter<CharSequence> brandsAdapter = ArrayAdapter.createFromResource(this, R.array.tmArr,
        android.R.layout.simple_spinner_item);
brandsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
brands.setAdapter(brandsAdapter);

        Spinner prices = findViewById(R.id.prices);
    ArrayAdapter<CharSequence> pricesAdapter = ArrayAdapter.createFromResource(this, R.array.priceArr,
            android.R.layout.simple_spinner_item);
    pricesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    prices.setAdapter(pricesAdapter);

        Spinner sizes = findViewById(R.id.sizes);
    ArrayAdapter<CharSequence> sizesAdapter = ArrayAdapter.createFromResource(this, R.array.sizeArr,
            android.R.layout.simple_spinner_item);
    sizesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    sizes.setAdapter(sizesAdapter);

}
}