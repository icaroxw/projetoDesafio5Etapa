package com.example.projetodesafio.repositories;

public interface ILoginRepositories {
    interface AuthCallback {
        void onSuccess();

        void onFailure(String errorMessage);
    }

    void signInWithEmailAndPassword(String email, String password, AuthCallback callback);
}
