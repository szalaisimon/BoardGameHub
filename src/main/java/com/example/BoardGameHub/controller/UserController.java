package com.example.BoardGameHub.controller;

import com.example.BoardGameHub.model.User;
import com.example.BoardGameHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUser(
        @PathVariable
        Integer userId
    ) {
        return userService.findById(userId);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        boolean success = userService.addNewUser(user);

        if (success) {
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User created successfully");
        } else {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Username is already taken");
        }
    }

}