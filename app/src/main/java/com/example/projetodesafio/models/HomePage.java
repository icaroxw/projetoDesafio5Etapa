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
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.projetodesafio.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomePage extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.menuHome);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menuHome) {
                    return true;
                }
                if (item.getItemId() == R.id.menuEvents) {
                    startActivity(new Intent(getApplicationContext(), Events.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                }
                if (item.getItemId() == R.id.menuProfile) {
                    startActivity(new Intent(getApplicationContext(), Profile.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return true;
                }

                return false;
            }
        });

        //

        LinearLayout LinearLayoutHomePageEvents = findViewById(R.id.LinearLayoutHomePageEvents);

        LinearLayoutHomePageEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEvents();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout LinearLayoutHomeAboutUs = findViewById(R.id.LinearLayoutHomeAboutUs);
        Dialog aboutUsDialog;
        aboutUsDialog = new Dialog(this);

        LinearLayoutHomeAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                aboutUsDialog.setContentView(R.layout.activity_about_popup);

                aboutUsDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                aboutUsDialog.show();
            }
        });

        //

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) LinearLayout LinearLayoutHomeEditUsers = findViewById(R.id.LinearLayoutHomeEditUsers);
        Dialog editUsersDialog;
        editUsersDialog = new Dialog(this);

        LinearLayoutHomeEditUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editUsersDialog.setContentView(R.layout.edit_users_popup);

                editUsersDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                editUsersDialog.show();
            }
        });

        //

        @SuppressLint("WrongViewCast") FrameLayout frameLayoutAthleticNewsWall = findViewById(R.id.frameLayoutAthleticNewsWall);
        Dialog ADialog;
        ADialog = new Dialog(this);

        frameLayoutAthleticNewsWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ADialog.setContentView(R.layout.athletic_newswall_popup);

                ADialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                ADialog.show();
            }
        });

        //

        @SuppressLint("WrongViewCast") FrameLayout frameLayoutUsersNewsWall = findViewById(R.id.frameLayoutUsersNewsWall);
        Dialog UDialog;
        UDialog = new Dialog(this);

        frameLayoutUsersNewsWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UDialog.setContentView(R.layout.users_newswall_popup);

                UDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                UDialog.show();
            }
        });


//        buttonSendAboutApp = (Button) findViewById(R.id.buttonSendAboutApp);
//        mDialog = new Dialog(this);
//
//        buttonSendAboutApp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                mDialog.setContentView(R.layout.activity_about_popup);
//
//                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                mDialog.show();
//            }
//        });
    }

    private void goToEvents() {
        Intent in = new Intent(HomePage.this, Events.class);
        startActivity(in);
    }
}