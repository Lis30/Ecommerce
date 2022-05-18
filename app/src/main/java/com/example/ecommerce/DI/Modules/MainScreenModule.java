package com.example.ecommerce.DI.Modules;

import com.projects.mainscreen_activity.MainScreen;

import javax.inject.Inject;

import dagger.Module;

@Module
public class MainScreenModule {

    @Inject
    MainScreen mainScreen;

    public MainScreenModule(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }
}
