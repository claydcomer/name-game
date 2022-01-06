package com.claydcomer.namegame.service;

import com.claydcomer.namegame.data.GameTable;
import com.claydcomer.namegame.model.Game;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DynamoService {

    public void saveGameToTable(Game game) {
        GameTable gameTable = new GameTable();
    }

    public Set<Integer> getPreviousGameIds(Integer gameId) {

        return new HashSet<>();
    }

    public void mapDynamoDataToGame(GameTable gameTable, Game game) {

    }
}
