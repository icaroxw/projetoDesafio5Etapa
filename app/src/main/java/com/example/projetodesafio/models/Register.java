package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;

public class Register extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //

        TextView textAlreadyHaveAccount = findViewById(R.id.textAlreadyHaveAccount);

        textAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //

        Button buttonRegisterReturn;
        buttonRegisterReturn = (Button) findViewById(R.id.buttonRegisterReturn);
        buttonRegisterReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        //

        Button buttonSendRegister;
        buttonSendRegister = (Button) findViewById(R.id.buttonSendRegister);

        buttonSendRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSucessNotificationRegister();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    private void goToLogin() {
        Intent in = new Intent(Register.this, LoginController.class);
        startActivity(in);
    }

    private void goToSucessNotificationRegister() {
        Intent in = new Intent(Register.this, SuccessNotificationRegister.class);
        startActivity(in);
    }
}

