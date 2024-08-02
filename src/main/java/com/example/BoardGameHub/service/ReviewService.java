package com.example.BoardGameHub.service;

import com.example.BoardGameHub.model.Review;
import com.example.BoardGameHub.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Review createNewReview(Review review) {
        return this.repository.save(review);
    }

    public List<Review> getReviews(final Long boardGameId) {
        return this.repository.findByBoardGameId(boardGameId);
    }
}
