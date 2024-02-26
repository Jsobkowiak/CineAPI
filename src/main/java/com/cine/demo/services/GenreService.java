package com.cine.demo.services;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class MovieService {
    private final Dotenv dotenv = Dotenv.load();
    private final String URL = "https://api.themoviedb.org/3/";

    public ResponseEntity<String> getAllMovies(int nbPage) {
        HttpEntity<String> entity = new HttpEntity<>(createHeaders());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "popular?language=fr-FR&page=" + nbPage,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    public ResponseEntity<String> searchFilms(String name, int nbPage) {
        HttpEntity<String> entity = new HttpEntity<>(createHeaders());
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(this.URL + "search/movie?query="+name+"&include_adult=false&language=fr-FR&page="+nbPage);
        return restTemplate.exchange(
                this.URL + "search/movie?query="+name+"&include_adult=false&language=fr-FR&page="+nbPage,
                HttpMethod.GET,
                entity,
                String.class
        );
    }

    private HttpHeaders createHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", this.dotenv.get("API_ACCESS_TOKEN"));
        headers.set("accept", "application/json");
        return headers;
    }
}
