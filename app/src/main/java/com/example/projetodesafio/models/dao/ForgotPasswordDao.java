package com.example.projetodesafio.models.dao;

import androidx.annotation.NonNull;

import com.example.projetodesafio.repositories.IForgotPasswordRepositories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordDao implements IForgotPasswordRepositories {

    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public void sendPasswordResetEmail(String email, AuthCallback callback) {
        try {
            mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        callback.onSuccess();
                    } else {
                        String response = task.getException().toString();
                        callback.onFailure(errorsOptions(response));
                    }
                }
            });

        } catch (Exception e) {
            callback.onFailure(errorsOptions(e.toString()));
        }

    }

    private String errorsOptions(String response) {
        if (response.contains("The email address is badly formatted")) {
            return "Insira um e-mail válido";
        } else if (response.contains("Password should be at least 6 characters")) {
            return "A senha precisa conter no mínimo 6 caracteres";
        } else if (response.contains("Given String is empty or null")) {
            return "Os campos não podem ser nulos";
        } else if (response.contains("The email address is already in use by another account")) {
            return "O e-mail informado já está sendo utilizado por outra conta";
        } else return "";
    }


}

