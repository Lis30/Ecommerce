package com.example.ecommerce.DI.Component;

import android.app.Activity;
import android.app.Application;

import com.example.ecommerce.DI.Modules.BasketScreenModule;
import com.example.ecommerce.DI.Modules.MainScreenModule;
import com.example.ecommerce.DI.Modules.ProdCardScreenModule;
import com.projects.activity_basket.BasketScreen;
import com.projects.activity_prodcard.ProdCardScreen;
import com.projects.mainscreen_activity.MainScreen;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;



@Component (modules = {MainScreenModule.class, BasketScreenModule.class, ProdCardScreenModule.class})
@Singleton
public interface AppComponent {

//    @Component.Builder
//            interface Builder{
//
//        @BindsInstance
//        Builder application (Application application);
//
//        AppComponent build();
//    }

    MainScreen mainscreen = new MainScreen();
    BasketScreen basket = new BasketScreen();
    ProdCardScreen prodCard = new ProdCardScreen();


}
