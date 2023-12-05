package com.example.projetodesafio.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.TextView;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class Profile extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String userId, password, email, username;

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
        } else {
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

        //

    TextView textPasswordProfile = findViewById(R.id.textPasswordProfile);

        textPasswordProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRedefinePassword();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }


    private void goToLogin() {
        Intent in = new Intent(this, LoginController.class);
        startActivity(in);
    }
    private void goToRedefinePassword() {
        Intent in = new Intent(this, RedefinePassword.class);
        startActivity(in);
    }

    protected void onStart() {
        super.onStart();

        TextView editUsernameProfile, editEmailProfile, editPasswordProfile,
                textUsernameProfile, textEmailProfile, textPasswordProfile;

        editUsernameProfile = findViewById(R.id.editUsernameProfile);
        editEmailProfile = findViewById(R.id.editEmailProfile);
        editPasswordProfile = findViewById(R.id.editPasswordProfile);

        textUsernameProfile = findViewById(R.id.textUsernameProfile);
        textEmailProfile = findViewById(R.id.textEmailProfile);
        textPasswordProfile = findViewById(R.id.textPasswordProfile);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            userId = currentUser.getUid();

            DocumentReference documentReference = db.collection("Users").document(userId);

            documentReference.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                @Override
                public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                    if (documentSnapshot != null) {

                        editUsernameProfile.setVisibility(View.VISIBLE);
                        editEmailProfile.setVisibility(View.VISIBLE);
                        editPasswordProfile.setVisibility(View.VISIBLE);
                        textUsernameProfile.setVisibility(View.VISIBLE);
                        textEmailProfile.setVisibility(View.VISIBLE);
                        textPasswordProfile.setVisibility(View.VISIBLE);

                        username = documentSnapshot.getString("name");
                        editUsernameProfile.setText(username);

                        email = documentSnapshot.getString("email");
                        editEmailProfile.setText(email);

                        password = documentSnapshot.getString("password");
                        StringBuilder hiddenPassword = new StringBuilder();
                        for (int i = 0; i < password.length(); i++) {
                            hiddenPassword.append("*");
                        }
                        editPasswordProfile.setText(hiddenPassword.toString());
                    }
                }
            });
        }
    }

}