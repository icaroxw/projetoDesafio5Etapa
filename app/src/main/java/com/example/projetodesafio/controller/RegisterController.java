package com.example.projetodesafio.controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetodesafio.R;
import com.example.projetodesafio.models.dao.RegisterDAO;
import com.example.projetodesafio.models.Profile;
import com.example.projetodesafio.models.SuccessNotificationRegister;
import com.example.projetodesafio.repositories.ILoginRepositories;
import com.example.projetodesafio.repositories.IRegisterRepositories;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterController extends AppCompatActivity {

    private RegisterDAO registerDAO;
    private TextInputEditText editTextUsers, editTextEmail, editTextPassword;
    private Button buttonRegister;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //

        TextView textAlreadyHaveAccount = findViewById(R.id.textAlreadyHaveAccount);

        textAlreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        //

        Button buttonRegisterReturn = (Button) findViewById(R.id.buttonRegisterReturn);
        buttonRegisterReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        /////////Criando a validacao do Login///////////


        editTextUsers = findViewById(R.id.editUsernameRegister);
        editTextEmail = findViewById(R.id.editEmailRegister);
        editTextPassword = findViewById(R.id.editPasswordRegister);

        buttonRegister = findViewById(R.id.buttonSendRegister);

        registerDAO = new RegisterDAO();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user, email, password;
                user = String.valueOf(editTextUsers.getText());
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if((!user.isEmpty() && !password.isEmpty()) && user.equals(password)) {
                    Toast.makeText(RegisterController.this, "A senha não pode ser igual ao nome de usuário", Toast.LENGTH_SHORT).show();
                    return;
                } else if(user.isEmpty()) {
                    Toast.makeText(RegisterController.this, "Os campos não podem ser nulos", Toast.LENGTH_SHORT).show();
                    return;
                }

                registerDAO.registerWithEmailAndPassword(email, password, new IRegisterRepositories.AuthCallback() {
                    @Override
                    public void onSuccess() {
                        goToSucessNotificationRegister();
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }

                    @Override
                    public void onFailure(String errorMessage) {
                        Toast.makeText(RegisterController.this, errorMessage,
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void goToLogin() {
        Intent in = new Intent(RegisterController.this, LoginController.class);
        startActivity(in);
    }

    private void goToProfile() {
        Intent in = new Intent(this, Profile.class);
        startActivity(in);
    }

    private void goToSucessNotificationRegister() {
        Intent in = new Intent(RegisterController.this, SuccessNotificationRegister.class);
        startActivity(in);
    }
}
