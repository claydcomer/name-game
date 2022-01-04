package com.claydcomer.namegame.controller;

import com.claydcomer.namegame.model.Profile;
import com.claydcomer.namegame.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Operation(summary = "Retrieve all profiles from WillowTree API")
    @GetMapping("/")
    public ResponseEntity<List<Profile>> getProfiles() {
        List<Profile> profiles = profileService.getProfiles();

        return new ResponseEntity<>(profiles, HttpStatus.OK);
    }
}
