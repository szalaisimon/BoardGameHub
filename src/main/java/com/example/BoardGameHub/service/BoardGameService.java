package com.example.BoardGameHub.service;

import com.example.BoardGameHub.model.BoardGame;
import com.example.BoardGameHub.repository.BoardGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardGameService {
    private final BoardGameRepository repository;

    @Autowired
    public BoardGameService(BoardGameRepository repository) {
        this.repository = repository;
    }

    public List<BoardGame> getAllBoardGames() {
        return repository.findAll();
    }

    public Optional<BoardGame> findById(final int boardGameId) {
        return repository.findById(boardGameId);
    }
}
