package com.example.BoardGameHub.service;

import com.example.BoardGameHub.model.User;
import com.example.BoardGameHub.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public @NonNull List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public @NonNull Optional<User> findById(final Long id) {
        return userRepository.findById(id);
    }
}
