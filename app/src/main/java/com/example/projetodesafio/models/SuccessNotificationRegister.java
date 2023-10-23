package com.example.projetodesafio.models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;

public class SuccessNotificationRegister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_notification_register);
        //

        Button buttonSendReturnHome;
        buttonSendReturnHome = (Button) findViewById(R.id.buttonSendReturnHome);
        buttonSendReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHome();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
    }

    private void goToHome() {
        Intent in = new Intent(SuccessNotificationRegister.this, HomePage.class);
        startActivity(in);
    }
}