package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;

public class VerificationPassword extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_password);

        Button buttonSendVerificationPassword;
        buttonSendVerificationPassword = (Button) findViewById(R.id.buttonSendVerificationPassword);

        buttonSendVerificationPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRedefinePassword();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        //

        Button buttonVerificationPasswordReturn;
        buttonVerificationPasswordReturn = (Button) findViewById(R.id.buttonVerificationPasswordReturn);
        buttonVerificationPasswordReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToForgotPassword();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }

    private void goToRedefinePassword() {
        Intent in = new Intent(VerificationPassword.this, RedefinePassword.class);
        startActivity(in);
    }
    private void goToForgotPassword() {
        Intent in = new Intent(VerificationPassword.this, ForgotPassword.class);
        startActivity(in);
    }
}