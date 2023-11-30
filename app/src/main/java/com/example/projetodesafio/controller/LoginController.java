package com.example.projetodesafio.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetodesafio.R;
import com.example.projetodesafio.models.dao.LoginDAO;
import com.example.projetodesafio.models.Profile;
import com.example.projetodesafio.repositories.ILoginRepositories;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.textfield.TextInputEditText;

public class LoginController extends AppCompatActivity {

    private LoginDAO loginDAO;
    GoogleSignInClient googleSignInClient;

    private TextInputEditText editTextEmail, editTextPassword;
    private Button buttonLoginReturn;
    private Button buttonLogin;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //

        TextView textCreateAccount = findViewById(R.id.textCreateAccount);

        textCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //

        TextView textForgotPassword = findViewById(R.id.textForgotPassword);

        textForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToForgotPassword();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //

        buttonLoginReturn = (Button) findViewById(R.id.buttonLoginReturn);
        buttonLoginReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
            }
        });


        /////////Criando a validacao do Login///////////

        loginDAO = new LoginDAO();

        editTextEmail = findViewById(R.id.editEmail);
        editTextPassword = findViewById(R.id.editPassword);

        buttonLogin = findViewById(R.id.buttonSendLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                loginDAO.signInWithEmailAndPassword(email, password, new ILoginRepositories.AuthCallback() {
                    @Override
                    public void onSuccess() {
                        goToProfile();
                        overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Toast.makeText(LoginController.this, errorMessage, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void goToRegister() {
        Intent in = new Intent(this, RegisterController.class);
        startActivity(in);
    }

    private void goToProfile() {
        Intent in = new Intent(this, Profile.class);
        startActivity(in);
    }

    private void goToForgotPassword() {
        Intent in = new Intent(this, ForgotPasswordController.class);
        startActivity(in);
    }

}