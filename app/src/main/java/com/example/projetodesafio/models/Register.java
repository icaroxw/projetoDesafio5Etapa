package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView textAlreadyHaveAccount = findViewById(R.id.textAlreadyHaveAccount);

        textAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });

        Button button;
        button = (Button) findViewById(R.id.buttonRegisterReturn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });

    }

    private void goToLogin() {
        Intent in = new Intent(Register.this, LoginController.class);
        startActivity(in);
    }
}

