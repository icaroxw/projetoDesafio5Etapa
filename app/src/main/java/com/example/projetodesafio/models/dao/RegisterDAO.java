package com.example.projetodesafio.models.dao;

import androidx.annotation.NonNull;

import com.example.projetodesafio.repositories.ILoginRepositories;
import com.example.projetodesafio.repositories.IRegisterRepositories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterDAO implements IRegisterRepositories {

    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();


    public void registerWithEmailAndPassword(String email, String password, AuthCallback callback) {
        try {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
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
