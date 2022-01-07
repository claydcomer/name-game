package com.claydcomer.namegame.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "Name-Game")
public class Game {

    private String id;

    private String gameType;

    private Integer score;

    private String guessId;

    private List<String> tileIds;

    private List<String> prevIds;

    private boolean gameOver;

    private Long endTime;

    @DynamoDBHashKey(attributeName = "game_id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public String getGuessId() {
        return guessId;
    }

    public void setGuessId(String guessId) {
        this.guessId = guessId;
    }

    @DynamoDBAttribute(attributeName = "tile_ids")
    public List<String> getTileIds() {
        return tileIds;
    }

    public void setTileIds(List<String> tileIds) {
        this.tileIds = tileIds;
    }

    @DynamoDBAttribute(attributeName = "prev_ids")
    public List<String> getPrevIds() {
        return prevIds;
    }

    public void setPrevIds(List<String> prevIds) {
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
