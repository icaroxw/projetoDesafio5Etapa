package com.example.projetodesafio.repositories;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface IRegisterRepositories {

    interface AuthCallback {
        void onSuccess();

        void onFailure(String errorMessage);
    }

    void registerWithEmailAndPassword(String email, String password, AuthCallback callback);

    void saveUserData(String nome, String email, String password);
}
