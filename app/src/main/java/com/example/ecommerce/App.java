package com.example.ecommerce;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import com.example.ecommerce.DI.Component.AppComponent;
import com.example.ecommerce.DI.Component.DaggerAppComponent;
import com.google.android.material.snackbar.Snackbar;

public class App extends AppCompatActivity {

    private AppComponent component;
    ConstraintLayout splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

splash = findViewById(R.id.splash);

        init();

  //      NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);


        splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
setContentView(com.projects.mainscreen_activity.R.layout.activity_main);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, R.id.)
//                || super.onSupportNavigateUp();
//    }

    private void init(){
        component = DaggerAppComponent.builder().build();
    }
}