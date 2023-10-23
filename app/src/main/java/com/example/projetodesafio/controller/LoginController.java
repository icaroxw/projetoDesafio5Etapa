package com.example.projetodesafio.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetodesafio.R;
import com.example.projetodesafio.dao.LoginDAO;
import com.example.projetodesafio.models.ForgotPassword;
import com.example.projetodesafio.models.Profile;
import com.example.projetodesafio.models.Register;
import com.example.projetodesafio.models.User;
import com.example.projetodesafio.repositories.LoginRepositories;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import java.util.Optional;

public class LoginController extends AppCompatActivity {

    GoogleSignInClient googleSignInClient;

    private EditText editEmail;
    private EditText editPassword;
    private LoginRepositories loginRepositories;

    @SuppressLint("MissingInflatedId")
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

        Button buttonLoginReturn;
        buttonLoginReturn = (Button) findViewById(R.id.buttonLoginReturn);
        buttonLoginReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
            }
        });


        /////////Criando a validacao do Login///////////

        loginRepositories = new LoginDAO();
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        Button buttonSendLogin = findViewById(R.id.buttonSendLogin);
        buttonSendLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                Optional<User> user = loginRepositories.getUserByEmail(email);

                if (user.isPresent() && user.get().getSenha().equals(password)) {
                    Toast.makeText(LoginController.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginController.this, "Nome de usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();

                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }
        });

    }

    private void goToRegister() {
        Intent in = new Intent(this, Register.class);
        startActivity(in);
    }

    private void goToProfile() {
        Intent in = new Intent(this, Profile.class);
        startActivity(in);
    }

    private void goToForgotPassword() {
        Intent in = new Intent(this, ForgotPassword.class);
        startActivity(in);
    }

}