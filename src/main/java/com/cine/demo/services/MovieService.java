package com.cine.demo.services;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {
    private final Dotenv dotenv = Dotenv.load();
    private final String URL = "https://api.themoviedb.org/3/movie/";

    public MovieService() {}

    public ResponseEntity<String> getAllMovies(int nbPage) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", this.dotenv.get("API_ACCESS_TOKEN"));
        headers.set("accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
          this.URL + "popular?language=fr-FR&page="+nbPage,
          HttpMethod.GET,
          entity,
          String.class
        );
    }
}
