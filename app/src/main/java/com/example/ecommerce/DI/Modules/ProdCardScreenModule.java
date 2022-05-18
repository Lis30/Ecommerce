package com.example.ecommerce.DI.Modules;

import com.projects.activity_prodcard.ProdCardScreen;

import javax.inject.Inject;

import dagger.Module;

@Module
public class ProdCardScreenModule {

    @Inject
    ProdCardScreen prodCardScreen;

    public ProdCardScreenModule(ProdCardScreen prodCardScreen) {
        this.prodCardScreen = prodCardScreen;
    }
}
