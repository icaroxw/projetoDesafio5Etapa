package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;

public class SuccessNotificationRedefinePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_notification_redefine_password);
        //

        Button buttonSendReturnLogin;
        buttonSendReturnLogin = (Button) findViewById(R.id.buttonSendReturnLogin);
        buttonSendReturnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    private void goToProfile() {
        Intent in = new Intent(SuccessNotificationRedefinePassword.this, Profile.class);
        startActivity(in);
    }
}