package com.example.BoardGameHub.repository;

import com.example.BoardGameHub.model.BoardGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardGameRepository extends JpaRepository<BoardGame, Integer> {
}
