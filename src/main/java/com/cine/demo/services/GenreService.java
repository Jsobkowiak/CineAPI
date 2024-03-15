package com.cine.demo.services;

import com.cine.demo.entities.tmdb.Genre;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Map;

@Service
@NoArgsConstructor
public class GenreService {
    private final String URL = "https://api.themoviedb.org/3/genre/";

    @Autowired
    private RestTemplate restTemplate;

    public Iterable<Genre> getAllMovieGenres() {
        ResponseEntity<Map> response = this.restTemplate.exchange(
                this.URL + "movie/list?language=en-US",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );
        return createGenreArray(response);
    }

    public Iterable<Genre> getAllSerieGenres() {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "tv/list?language=en-US",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );
        if (response.getBody() != null) {
            return createGenreArray(response);
        } else {
            return new ArrayList<>();
        }
    }

    private Iterable<Genre> createGenreArray(ResponseEntity<Map> response) {
        ArrayList<Genre> genres = new ArrayList<>();
        ArrayList arrayList = (ArrayList) response.getBody().get("genres");
        for (int i = 0; i < arrayList.size(); i++) {
            Map genreList = (Map) arrayList.get(i);
            int id = (int) genreList.get("id");
            String name = (String) genreList.get("name");
            genres.add(new Genre(id, name));
        }
        return genres;
    }

}
