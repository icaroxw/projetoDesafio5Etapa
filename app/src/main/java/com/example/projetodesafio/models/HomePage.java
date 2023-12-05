package com.example.projetodesafio.models;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.projetodesafio.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class HomePage extends AppCompatActivity {


    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private BottomNavigationView bottomNavigationView;
    private Button buttonSendAddNewsPopup;

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

        @SuppressLint("WrongViewCast") FrameLayout frameLayoutUsersNewsWall = findViewById(R.id.frameLayoutUsersNewsWall);
        Dialog UsersADialog;
        UsersADialog = new Dialog(this);

        frameLayoutUsersNewsWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsersADialog.setContentView(R.layout.users_newswall_popup);

                UsersADialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                UsersADialog.show();
            }
        });

        //

        @SuppressLint("WrongViewCast") FrameLayout frameLayoutAthleticNewsWall = findViewById(R.id.frameLayoutAthleticNewsWall);
        Dialog AthleticADialog;
        AthleticADialog = new Dialog(this);

        frameLayoutAthleticNewsWall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AthleticADialog.setContentView(R.layout.athletic_newswall_popup);

                AthleticADialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                AthleticADialog.show();
            }
        });

        //

        FrameLayout FrameLayoutHomeAddNews = findViewById(R.id.FrameLayoutHomeAddNews);
        Dialog UDialog;
        UDialog = new Dialog(this);

        FrameLayoutHomeAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = LayoutInflater.from(HomePage.this);
                View popupView = inflater.inflate(R.layout.activity_add_news_popup, null);

                TextInputEditText popupTitleEditText = popupView.findViewById(R.id.TextInputEditTexttitlePopupAddNews);
                TextInputEditText popupBodyEditText = popupView.findViewById(R.id.TextInputEditTextBodyPopupAddNews);
                Button popupSendButton = popupView.findViewById(R.id.buttonSendAddNewsPopup);

                popupSendButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String titulo = String.valueOf(popupTitleEditText.getText());
                        String noticia = String.valueOf(popupBodyEditText.getText());

                        if (isValidInput(titulo, noticia)) {
                            enviarDadosAoFirebase(titulo, noticia);
                            UDialog.dismiss();

                        } else {
                            Toast.makeText(HomePage.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                UDialog.setContentView(popupView);
                UDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                UDialog.show();
            }
        });

    }

    private void goToEvents() {
        Intent in = new Intent(HomePage.this, Events.class);
        startActivity(in);
    }

    private void enviarDadosAoFirebase(String titulo, String noticia) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> athleticNews = new HashMap<>();
        athleticNews.put("titulo", titulo);
        athleticNews.put("noticia", noticia);

        db.collection("AthleticNews")
                .document()
                .set(athleticNews)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(HomePage.this, "Notícia Enviada", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(HomePage.this, "Falha ao enviar a Notícia", Toast.LENGTH_SHORT).show();
                });
    }

    private boolean isValidInput(String titulo, String noticia) {
        return !TextUtils.isEmpty(titulo) && !TextUtils.isEmpty(noticia);
    }
}