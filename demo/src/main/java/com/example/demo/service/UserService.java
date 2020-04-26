package com.example.demo.service;


import com.example.demo.Entity.user;

import java.util.List;

public interface UserService {

    List<user> getAllUsers();
    void createUser(user user);
    void updateUser(Long id, user user);
}
