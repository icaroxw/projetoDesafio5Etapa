package com.example.projetodesafio.models;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //


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

        //

        Button buttonSendLoginProfile, buttonSendLogoutProfile;
        buttonSendLoginProfile = (Button) findViewById(R.id.buttonSendLoginProfile);
        buttonSendLogoutProfile = findViewById(R.id.buttonSendLogoutProfile);

        // altera a visibilidade do botao caso o usuario esteja logado

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            buttonSendLogoutProfile.setVisibility(View.VISIBLE);
        }else {
            buttonSendLoginProfile.setVisibility(View.VISIBLE);
        }


        buttonSendLoginProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    goToLogin();
                    overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
                }
            });

        buttonSendLogoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                goToLogin();
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);

            }
        });


        }

        private void goToLogin () {
            Intent in = new Intent(this, LoginController.class);
            startActivity(in);
        }
    }