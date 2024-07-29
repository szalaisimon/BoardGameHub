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

    public boolean addNewUser(final User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());

        if (userOptional.isPresent()) {
            return false;
        }

        userRepository.save(user);
        return true;
    }
}
