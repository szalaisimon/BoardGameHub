package com.example.BoardGameHub.controller;

import com.example.BoardGameHub.model.BoardGame;
import com.example.BoardGameHub.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boardgames")
public class BoardGameController {

    private final BoardGameService boardGameService;

    @Autowired
    public BoardGameController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }

    @GetMapping
    public ResponseEntity<List<BoardGame>> getBoardGames() {
        return new ResponseEntity<>(boardGameService.getAllBoardGames(), HttpStatus.OK);
    }

    @GetMapping("/{boardGameId}")
    public ResponseEntity<BoardGame> getBoardGame(
        @PathVariable
        int boardGameId
    ) {
        Optional<BoardGame> optionalBoardGame = boardGameService.findById(boardGameId);

        if (optionalBoardGame.isPresent()) {
            return new ResponseEntity<>(optionalBoardGame.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
