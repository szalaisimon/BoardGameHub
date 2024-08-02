package com.example.BoardGameHub.controller;

import com.example.BoardGameHub.model.BoardGame;
import com.example.BoardGameHub.model.Review;
import com.example.BoardGameHub.model.User;
import com.example.BoardGameHub.service.BoardGameService;
import com.example.BoardGameHub.service.ReviewService;
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
@RequestMapping("/api/boardgames")
public class BoardGameController {

    private final BoardGameService boardGameService;
    private final ReviewService reviewService;

    @Autowired
    public BoardGameController(BoardGameService boardGameService, ReviewService reviewService) {
        this.boardGameService = boardGameService;
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<BoardGame>> getBoardGames() {
        return new ResponseEntity<>(boardGameService.getAllBoardGames(), HttpStatus.OK);
    }

    @GetMapping("/{boardGameId}")
    public ResponseEntity<BoardGame> getBoardGame(
        @PathVariable
        Long boardGameId
    ) {
        Optional<BoardGame> optionalBoardGame = boardGameService.findById(boardGameId);

        if (optionalBoardGame.isPresent()) {
            return new ResponseEntity<>(optionalBoardGame.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public void createNewBoardGame(
        @RequestBody
        BoardGame boardGame
    ) {
        boardGameService.createNewBoardGame(boardGame);
    }

    @PostMapping("/{boardGameId}/reviews")
    public ResponseEntity<Review> createNewReview(
        @PathVariable Long boardGameId,
        @RequestBody Review review) {

        Optional<BoardGame> boardGame = boardGameService.findById(boardGameId);

        if(boardGame.isPresent()){
            review.setBoardGame(boardGame.get());

            Review savedReview = reviewService.createNewReview(review);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedReview);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{boardGameId}/reviews")
    public ResponseEntity<List<Review>> getReviews(
        @PathVariable
        Long boardGameId
    ){
        Optional<BoardGame> boardGame = boardGameService.findById(boardGameId);

        if(boardGame.isPresent()) {
            List<Review> reviews = reviewService.getReviews(boardGameId);
            return ResponseEntity.status(HttpStatus.OK).body(reviews);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
