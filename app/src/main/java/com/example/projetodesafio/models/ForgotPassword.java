package com.example.projetodesafio.models;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetodesafio.R;
import com.example.projetodesafio.controller.LoginController;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class ForgotPassword extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private Button buttonSendForgotPassword;
    private TextInputEditText editTextEmail;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //

        Button buttonForgotPasswordReturn;
        buttonForgotPasswordReturn = (Button) findViewById(R.id.buttonForgotPasswordReturn);
        buttonForgotPasswordReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        //


        buttonSendForgotPassword = (Button) findViewById(R.id.buttonSendForgotPassword);
        editTextEmail = findViewById(R.id.editTextPassword);
        mAuth = FirebaseAuth.getInstance();


        buttonSendForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = String.valueOf(editTextEmail.getText());
                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError("Coloque o email");
                } else {
                    //o Firebase Authentication envia automaticamente um e-mail de redefinição de senha padrão para o usuário com um link de redefinição incorporado. O conteúdo do e-mail é gerado pelo Firebase e não pode ser personalizado
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            goToLogin();
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ForgotPassword.this, "Erro", Toast.LENGTH_SHORT).show();

                        }

                    });
                }
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