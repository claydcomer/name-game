package com.claydcomer.namegame.service;

import com.claydcomer.namegame.model.Game;
import com.claydcomer.namegame.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;

@Service
public class GameService {

    private final ProfileService profileService;

    private final DynamoService dynamoService;

    @Autowired
    public GameService(ProfileService profileService, DynamoService dynamoService) {
        this.profileService = profileService;
        this.dynamoService = dynamoService;
    }

    public Game startGame(String gameType) {
        Game game = new Game();
        //Retrieve 6 profiles
        List<Profile> profiles = profileService.pickSixNewProfiles();

        //Build game object
        List<String> profileIds = profileService.getIdsFromProfiles(profiles);
        Random rand = new Random();
        Integer randomIndex = rand.nextInt(profileIds.size());

        game.setGameType(gameType);
        game.setGuessId(profileIds.get(randomIndex));
        game.setTileIds(profileIds);
        game.setScore(0);
        game.setGameOver(false);

        //If game mode is timed add a two-minute future time in epoch time
        if(gameType.equals("timed")){
            LocalDateTime endTime = LocalDateTime.now().plusMinutes(3L);
            ZoneId zoneId = ZoneId.systemDefault();
            long epochTime = endTime.atZone(zoneId).toEpochSecond();

            game.setEndTime(epochTime);
        }

        //Create Entry in DynamoDB table for our game
        dynamoService.saveGameToTable(game);

        return game;
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
