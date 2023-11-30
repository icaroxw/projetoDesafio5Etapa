package com.example.projetodesafio.repositories;

public interface IForgotPasswordRepositories {

    interface AuthCallback {
        void onSuccess();

        void onFailure(String errorMessage);
    }

    void sendPasswordResetEmail(String email, AuthCallback callback);
}
