package com.example.projetodesafio.models;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.projetodesafio.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //

        BottomNavigationView bottomNavigationView = findViewById(R.id.NavigationBottomBar);
        bottomNavigationView.setSelectedItemId(R.id.buttonHomePageHome);

        bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.buttonHomePageHome){
                return true;
            }
            if (item.getItemId() == R.id.buttonHomePageEvents) {
                startActivity(new Intent(getApplicationContext(), Events.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            if (item.getItemId() == R.id.buttonHomePageProfile) {
                startActivity(new Intent(getApplicationContext(), Profile.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }
            return false;
        });
    }
}