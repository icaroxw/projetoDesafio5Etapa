package com.example.projetodesafio.models;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;

public class RedefinePassword extends Activity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefine_password);
        //

        Button button;
        button = (Button) findViewById(R.id.buttonSendRedefinePassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
            }
        });

        //

        Button buttonRedefinePasswordReturn;
        buttonRedefinePasswordReturn = (Button) findViewById(R.id.buttonRedefinePasswordReturn);
        buttonRedefinePasswordReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVerificationPassword();
            }
        });

    }

    private void goToLogin() {
        Intent in = new Intent(this, LoginController.class);
        startActivity(in);
    }

    private void goToVerificationPassword() {
        Intent in = new Intent(this, VerificationPassword.class);
        startActivity(in);
    }
}
