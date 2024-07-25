package com.example.BoardGameHub.service;

import com.example.BoardGameHub.model.User;
import com.example.BoardGameHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findById(final Integer id) {
        return userRepository.findById(id);
    }

    public void addNewUser(final User user) {
        Optional<User> userOptional = userRepository.findStudentByUserName(user.getUserName());

        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("username taken");
        }

        userRepository.save(user);
    }
}
