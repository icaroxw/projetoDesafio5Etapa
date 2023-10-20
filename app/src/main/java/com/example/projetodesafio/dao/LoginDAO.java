package com.example.projetodesafio.dao;


import com.example.projetodesafio.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginDAO implements UserDAO {

    private List<User> users;

    public LoginDAO() {
        users = new ArrayList<>();
        users.add(new User("email@email", "123456"));
        users.add(new User("email1@email1", "123456"));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
}
