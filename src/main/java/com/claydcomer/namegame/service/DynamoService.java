package com.claydcomer.namegame.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.claydcomer.namegame.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamoService {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public DynamoService(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void saveGameToTable(Game game) {
        dynamoDBMapper.save(game);
    }
}
