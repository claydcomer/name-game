package com.claydcomer.namegame.service;

import com.claydcomer.namegame.model.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Value( "${willowtree.profiles.url}" )
    private String profileUrl;

    public List<Profile> getProfiles() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN));

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(converter);

        ResponseEntity<List<Profile>> response = restTemplate.exchange(
                profileUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Profile>>() {});

        return response.getBody();
    }

    public Profile getProfileById(String id) {
        List<Profile> profiles = getProfiles();

        return profiles.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Profile> pickSixNewProfiles() {
        return pickSixNewProfiles(null);
    }

    public List<Profile> pickSixNewProfiles(List<String> previousProfileIds) {
        List<Profile> profiles = getProfiles();
        List<Profile> filteredProfiles = new ArrayList<>();

        //Get list of values that do not contain previously selected ids
        if(previousProfileIds != null) {
            filteredProfiles.addAll(profiles.stream()
                    .filter(p -> !previousProfileIds.contains(p.getId()))
                    .collect(Collectors.toSet()));
        } else {
            filteredProfiles.addAll(profiles);
        }

        //Shuffle the list
        Collections.shuffle(filteredProfiles);

        //Select the first 6 items from the shuffled list and return
        return filteredProfiles.subList(0, 6);
    }

    public List<String> getIdsFromProfiles(List<Profile> profileSet) {
        return profileSet.stream().map(Profile::getId).collect(Collectors.toList());
    }
}
