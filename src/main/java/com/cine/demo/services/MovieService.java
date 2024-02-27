package com.cine.demo.services;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class MovieService {
    private final String URL = "https://api.themoviedb.org/3/";

    public ResponseEntity<String> getAllMovies(String nbPage) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "/movie/popular?language=fr-FR&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }

    public ResponseEntity<String> searchFilms(String name, String nbPage) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "search/movie?query="+name+"&include_adult=false&language=fr-FR&page="+nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }

    public ResponseEntity<String> getMovieDetail(int idMovie) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "/movie/"+idMovie+"?language=fr-FR",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }
}
