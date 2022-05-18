package com.example.ecommerce.DI.Modules;

import com.projects.activity_basket.BasketScreen;

import javax.inject.Inject;

import dagger.Module;

@Module
public class BasketScreenModule {

    @Inject
    BasketScreen basketScreen;

    public BasketScreenModule(BasketScreen basketScreen) {
        this.basketScreen = basketScreen;
    }
}
