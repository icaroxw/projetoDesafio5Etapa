package com.example.projetodesafio.models;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;

public class RedefinePassword extends Activity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redefine_password);
        //

        Button buttonSendRedefinePassword;
        buttonSendRedefinePassword = (Button) findViewById(R.id.buttonSendRedefinePassword);

        buttonSendRedefinePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSucessNotification();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //

        Button buttonRedefinePasswordReturn;
        buttonRedefinePasswordReturn = (Button) findViewById(R.id.buttonRedefinePasswordReturn);
        buttonRedefinePasswordReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToVerificationPassword();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

    }

    private void goToSucessNotification() {
        Intent in = new Intent(this, SuccessNotificationRedefinePassword.class);
        startActivity(in);
    }

    private void goToVerificationPassword() {
        Intent in = new Intent(this, VerificationPassword.class);
        startActivity(in);
    }
}
