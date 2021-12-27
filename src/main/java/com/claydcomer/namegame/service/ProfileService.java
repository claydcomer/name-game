package com.claydcomer.namegame.service;

import com.claydcomer.namegame.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProfileService {

    private final RestTemplate restTemplate;

    @Value( "${willowtree.profiles.url}" )
    private String profileUrl;

    @Autowired
    public ProfileService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Profile> getProfiles() {
        ResponseEntity<List<Profile>> response = restTemplate.exchange(
                profileUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Profile>>() {});

        List<Profile> profiles = response.getBody();

        return profiles;
    }
}
