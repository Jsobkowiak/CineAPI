package com.cine.demo.services;

import com.cine.demo.entities.tmdb.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Service
@NoArgsConstructor
public class MovieService {
    private final String URL = "https://api.themoviedb.org/3/";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Iterable<Movie> getAllMovies(String nbPage) {

        Iterable<Movie> movies = null;
        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    this.URL + "/movie/popular?language=fr-FR&page=" + nbPage,
                    HttpMethod.GET,
                    HttpEntityService.createHttpEntity(),
                    Map.class
            );
            //Map<String, Object> map = objectMapper.readValue(response.getBody(), new TypeReference<Map<String, Object>>() {
            //});

            ArrayList arrayList = (ArrayList) response.getBody().get("results");

            for (int i = 0; i < arrayList.size(); i++) {
                Map movieInfo = (Map) arrayList.get(i);
                String title = (String) movieInfo.get("title");
                System.out.println(title);
            }

        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public ResponseEntity<String> searchFilms(String name, String nbPage) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "search/movie?query=" + name + "&include_adult=false&language=fr-FR&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }

    public ResponseEntity<String> getMovieDetail(int idMovie) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "/movie/" + idMovie + "?language=fr-FR",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }
}
