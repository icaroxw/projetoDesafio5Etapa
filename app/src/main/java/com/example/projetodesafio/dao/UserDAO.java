package com.example.projetodesafio.dao;

import com.example.projetodesafio.models.User;

import java.util.Optional;

public interface UserDAO {

    Optional<User> getUserByEmail(String email);
}
