package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projetodesafio.R;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

public class Login extends AppCompatActivity {

    GoogleSignInClient googleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //

        TextView textCreateAccount = findViewById(R.id.textCreateAccount);

        textCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister(view);
            }
        });

    }

    private void goToRegister(View view) {
        Intent in = new Intent(Login.this, HomePage.class);
        startActivity(in);
    }

}