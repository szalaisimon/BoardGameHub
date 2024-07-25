package com.example.BoardGameHub.controller;

import com.example.BoardGameHub.model.BoardGame;
import com.example.BoardGameHub.service.BoardGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/boardgames")
public class BoardGameController {

    private final BoardGameService boardGameService;

    @Autowired
    public BoardGameController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }

    @GetMapping
    public List<BoardGame> getBoardGames(){
        return boardGameService.getAllBoardGames();
    }
}
