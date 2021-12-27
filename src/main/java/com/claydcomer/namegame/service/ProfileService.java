package com.claydcomer.namegame.service;

import com.claydcomer.namegame.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

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

        List<Profile> profiles = response.getBody();

        return profiles;
    }
}
