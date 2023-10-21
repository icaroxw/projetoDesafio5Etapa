package com.example.projetodesafio.repositories;

import com.example.projetodesafio.models.User;

import java.util.Optional;

public interface LoginRepositories {

    Optional<User> getUserByEmail(String email);
}
