package com.dyes.onlinebankingsystem.controller;

import com.dyes.onlinebankingsystem.model.User;
import com.dyes.onlinebankingsystem.service.command.CreateUserCommand;
import com.dyes.onlinebankingsystem.service.command.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserService createUserService;

    @Autowired
    public UserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserCommand command){
        User createduser = createUserService.handle(command);
        return new ResponseEntity<>(createduser, HttpStatus.CREATED);
    }
}
