package com.example.BoardGameHub.repository;

import com.example.BoardGameHub.model.Review;
import com.example.BoardGameHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByUserId(Long userId);
    List<Review> findByBoardGameId(Long boardGameId);
}
