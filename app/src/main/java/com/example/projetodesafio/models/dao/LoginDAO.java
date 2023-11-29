package com.example.projetodesafio.models.dao;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetodesafio.repositories.ILoginRepositories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginDAO implements ILoginRepositories {

    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    public void signInWithEmailAndPassword(String email, String password, AuthCallback callback) {
        try {
            mAuth.signInWithEmailAndPassword(email, password)
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
        } catch(Exception e) {
            callback.onFailure(errorsOptions(e.toString()));
        }
    }

    private String errorsOptions(String response) {
        if(response.contains("The supplied auth credential is incorrect, malformed or has expired") || response.contains("The email address is badly formatted")) {
            return "E-mail e/ou senha inválidos!";
        } else if(response.contains("Given String is empty or null")) {
            return "Os campos não podem ser nulos";
        } else return "";
    }
}
