package com.example.BoardGameHub.repository;

import com.example.BoardGameHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

