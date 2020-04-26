package com.example.demo.service.impl;

import com.example.demo.Entity.user;
import com.example.demo.Repository.userRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<user> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public void createUser(user user) {
//
//    }
//
//    @Override
//    public void updateUser(Long id, user user) {
//
//    }

    @Override
    public void createUser(user user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
    }

    @Override
    public void updateUser(Long id, user user) {
        user userDb = userRepository.findById(id).orElse(null);

        if (userDb != null) {
            userDb.setUsername(user.getUsername());
            userDb.setPassword(user.getPassword()); // plaintext password

            userRepository.saveAndFlush(userDb);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User: " + username + " not found!");
        }
        return user;
    }
}
