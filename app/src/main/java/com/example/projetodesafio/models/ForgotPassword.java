package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;

public class ForgotPassword extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //

        Button buttonSendForgotPassword;
        buttonSendForgotPassword = (Button) findViewById(R.id.buttonSendForgotPassword);

        buttonSendForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVerificationPassword();
            }
        });

        //

        Button buttonForgotPasswordReturn;
        buttonForgotPasswordReturn = (Button) findViewById(R.id.buttonForgotPasswordReturn);
        buttonForgotPasswordReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });


    }

    private void goToVerificationPassword() {
        Intent in = new Intent(this, VerificationPassword.class);
        startActivity(in);
    }

    private void goToLogin() {
        Intent in = new Intent(this, LoginController.class);
        startActivity(in);
    }
}