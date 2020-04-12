package com.example.demo.controllers;

import com.example.demo.Entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private com.example.demo.Repository.userRepository userRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<user> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public user getUserById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<user> getByNameContainingAndSurname(@RequestParam String name,
                                                @RequestParam String surname){
        return userRepository.findAllByNameContainingAndSurname(name, surname);
    }

    @PostMapping("")
    public  user createUser(@RequestBody user user){
        return userRepository.saveAndFlush(user);
    }

    @PutMapping("/{id}")
    public  user updateUser(@PathVariable Long id,
                            @RequestBody user user) {
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }

    @PatchMapping("/{id}")
    public user updateUserAge(@PathVariable Long id,
                              @RequestParam String name){
        user user = userRepository.findById(id).get();
        user.setName(name);
        return userRepository.saveAndFlush(user);
    }


}
