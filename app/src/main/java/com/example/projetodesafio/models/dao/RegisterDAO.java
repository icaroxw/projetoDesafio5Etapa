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

    @Override
    public void registerWithEmailAndPassword(String email, String password, ILoginRepositories.AuthCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            callback.onSuccess();
                        } else {
                            callback.onFailure("Falha ao realizar o cadastro.");
                        }
                    }
                });
    }
}
