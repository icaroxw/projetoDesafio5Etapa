package com.example.projetodesafio.controller;

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
import com.example.projetodesafio.models.VerificationPassword;
import com.example.projetodesafio.models.dao.ForgotPasswordDao;
import com.example.projetodesafio.repositories.IForgotPasswordRepositories;
import com.example.projetodesafio.repositories.IRegisterRepositories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordController extends AppCompatActivity {


    private Button buttonSendForgotPassword;
    private TextInputEditText editTextEmail;

    private ForgotPasswordDao forgotPasswordDao;


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

        forgotPasswordDao = new ForgotPasswordDao();

        buttonSendForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = String.valueOf(editTextEmail.getText());
                if (TextUtils.isEmpty(email)) {
                    editTextEmail.setError("Informe o e-mail");
                    return;
                } else {
                    //o Firebase Authentication envia automaticamente um e-mail de redefinição de senha padrão para o usuário com um link de redefinição incorporado. O conteúdo do e-mail é gerado pelo Firebase e não pode ser personalizado
                    forgotPasswordDao.sendPasswordResetEmail(email, new IForgotPasswordRepositories.AuthCallback() {
                        @Override
                        public void onSuccess() {
                            goToLogin();
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        }

                        @Override
                        public void onFailure(String errorMessage) {
                            Toast.makeText(ForgotPasswordController.this, errorMessage,
                                    Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void goToLogin() {
        Intent in = new Intent(this, LoginController.class);
        startActivity(in);
    }

}