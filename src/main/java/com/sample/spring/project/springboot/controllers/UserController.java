package com.sample.spring.project.springboot.controllers;

import com.sample.spring.project.springboot.domain.User;
import com.sample.spring.project.springboot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/customers";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getAllUser(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){ return userService.findUserById(id);  }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
