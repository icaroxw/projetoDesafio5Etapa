package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projetodesafio.R;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView textAlreadyHaveAccount = findViewById(R.id.textAlreadyHaveAccount);

        textAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin(view);
            }
        });
    }

    private void goToLogin(View view) {
        Intent in = new Intent(Register.this, Login.class);
        startActivity(in);
    }
}

