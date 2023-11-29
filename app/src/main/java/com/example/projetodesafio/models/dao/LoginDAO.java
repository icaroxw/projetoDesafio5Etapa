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
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            callback.onSuccess();
                        } else {
                            callback.onFailure("Falha no Login.");
                        }
                    }
                });
    }
}
