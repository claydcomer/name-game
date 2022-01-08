package com.claydcomer.namegame.controller;

import com.claydcomer.namegame.model.Game;
import com.claydcomer.namegame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/start")
    public ResponseEntity<Game> startGame(@RequestParam("type") String gameType) {
        Game game = gameService.startGame(gameType);

        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }
}
