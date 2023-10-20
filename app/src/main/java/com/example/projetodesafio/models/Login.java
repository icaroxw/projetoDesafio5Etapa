package com.example.projetodesafio.models;

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
import com.example.projetodesafio.dao.UserDAO;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import java.util.Optional;

public class Login extends AppCompatActivity {

    GoogleSignInClient googleSignInClient;

    private EditText editEmail;
    private EditText editPassword;
    private UserDAO userDao;

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
            }
        });

        Button button;
        button = (Button) findViewById(R.id.buttonLoginReturn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile();
            }
        });


        /////////Criando a validacao do Login///////////

        userDao = new LoginDAO();
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);

        Button buttonSendLogin = findViewById(R.id.buttonSendLogin);
        buttonSendLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();

                Optional<User> user = userDao.getUserByEmail(email);

                if (user.isPresent() && user.get().getSenha().equals(password)) {
                    Toast.makeText(Login.this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Login.this, "Nome de usuário ou senha incorretos. Login falhou.", Toast.LENGTH_SHORT).show();
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

}