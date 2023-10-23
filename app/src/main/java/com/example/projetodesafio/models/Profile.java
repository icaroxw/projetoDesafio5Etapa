package com.example.projetodesafio.models;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.menuProfile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.menuHome) {
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                if (item.getItemId() == R.id.menuEvents) {
                    startActivity(new Intent(getApplicationContext(), Events.class));
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
                if (item.getItemId() == R.id.menuProfile) {
                    return true;
                }

                return false;
            }
        });

        Button buttonSendLoginProfile;
        buttonSendLoginProfile = (Button) findViewById(R.id.buttonSendLoginProfile);

        buttonSendLoginProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
            }
        });

    }

    private void goToLogin() {
        Intent in = new Intent(this, LoginController.class);
        startActivity(in);
    }
}