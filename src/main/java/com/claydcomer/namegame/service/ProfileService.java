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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public Set<Profile> pickSixNewProfiles(Set<Integer> previousProfileIds) {
        Set<Profile> profileSet = new HashSet<>();

        //Get list of values that do not contain previously selected ids

        //Shuffle the list

        //Select the first 6 items from the shuffled list

        //Build and return hashset
        return new HashSet<>();
    }

    public Set<String> getIdsFromProfiles(Set<Profile> profileSet) {
        return profileSet.stream().map(Profile::getId).collect(Collectors.toSet());
    }
}
