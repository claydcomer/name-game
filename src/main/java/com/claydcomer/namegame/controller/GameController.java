package com.claydcomer.namegame.controller;

import com.claydcomer.namegame.model.Game;
import com.claydcomer.namegame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start/{type}")
    public ResponseEntity<Game> startGame(@PathVariable("type") String gameType) {
        Game game = gameService.startGame(gameType);

        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }
}
