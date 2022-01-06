package com.claydcomer.namegame.model;

import java.time.LocalDateTime;
import java.util.List;

public class Game {

    private Integer id;

    private String gameType;

    private Integer score;

    private Integer guessId;

    private List<Headshot> tileIds;

    private boolean gameOver;

    private LocalDateTime endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGuessId() {
        return guessId;
    }

    public void setGuessId(Integer guessId) {
        this.guessId = guessId;
    }

    public List<Headshot> getTileIds() {
        return tileIds;
    }

    public void setTileIds(List<Headshot> tileIds) {
        this.tileIds = tileIds;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}
