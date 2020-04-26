package com.example.demo.controllers;

import com.example.demo.Entity.user;
import com.example.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "User Controller class", description = "User object")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private com.example.demo.Repository.userRepository userRepository;

    @RequestMapping(value="", method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ApiOperation(value = "Method to get list of users", response = List.class)
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


    @GetMapping("/create")
    public void createUserByUsernamePassword(String username,
                                             String password) {
        user user = new user();
        user.setPassword(password);
        user.setUsername(username);

        userService.createUser(user);
    }
    @PostMapping("")
    public void createUser(@RequestBody user user){

        System.out.println("UserController.createUser");
        System.out.println("user = " + user);

        userService.createUser(user);
//        return userRepository.saveAndFlush(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody user user) {
        System.out.println("UserController.updateUser");
        System.out.println("id = " + id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }

    @PatchMapping("/{id}")
    public user updateUserAge(@PathVariable Long id,
                              @RequestParam String name){
        user user = userRepository.findById(id).get();
        user.setName(name);
        return userRepository.saveAndFlush(user);
    }



}
