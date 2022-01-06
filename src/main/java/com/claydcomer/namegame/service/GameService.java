package com.claydcomer.namegame.service;

import com.claydcomer.namegame.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public Game startGame(String gameType) {
        //Retrieve 6 profiles

        //Create Entry in DynamoDB table for our game

        //Select guessId and populate tile ids

        //Build and return game object

            //If game mode is timed add a 2 minute future time in epoch time
        return new Game();
    }

    public boolean validateGuess(Integer guessId, Integer guessedTileId) {
        return guessId.equals(guessedTileId);
    }

    public Game buildNextRound(Game game) {
        //Retrieve DynamoDB game record

        //Retrieve 6 new profiles

        //Add existing guessId and tileIds to the prevIds

        //Add 100 points to score

        //Set new guessId and tile Ids

        //Update DynamoDB

        //Return updated game object
            //Set game over to true if type is timed and allotted time has passed
        return new Game();
    }
}
