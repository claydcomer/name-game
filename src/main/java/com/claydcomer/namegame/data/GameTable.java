package com.claydcomer.namegame.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Set;

@DynamoDBTable(tableName = "Name-Game")
public class GameTable {

    private Integer id;

    private String gameType;

    private Integer score;

    private Integer guessId;

    private Set<Integer> tileIds;

    private Set<Integer> prevIds;

    private boolean gameOver;

    private Long endTime;

    @DynamoDBHashKey
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "game_type")
    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    @DynamoDBAttribute(attributeName = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @DynamoDBAttribute(attributeName = "guess_id")
    public Integer getGuessId() {
        return guessId;
    }

    public void setGuessId(Integer guessId) {
        this.guessId = guessId;
    }

    @DynamoDBAttribute(attributeName = "tile_ids")
    public Set<Integer> getTileIds() {
        return tileIds;
    }

    public void setTileIds(Set<Integer> tileIds) {
        this.tileIds = tileIds;
    }

    @DynamoDBAttribute(attributeName = "prev_ids")
    public Set<Integer> getPrevIds() {
        return prevIds;
    }

    public void setPrevIds(Set<Integer> prevIds) {
        this.prevIds = prevIds;
    }

    @DynamoDBAttribute(attributeName = "game_over")
    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @DynamoDBAttribute(attributeName = "end_time")
    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
