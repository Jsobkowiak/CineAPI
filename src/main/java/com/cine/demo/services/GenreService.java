package com.cine.demo.services;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class GenreService {
    private final String URL = "https://api.themoviedb.org/3/genre/";

    public ResponseEntity<String> getAllMovieGenres() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "movie/list?language=fr",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }

    public ResponseEntity<String> getAllSerieGenres() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "tv/list?language=fr",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }
}
