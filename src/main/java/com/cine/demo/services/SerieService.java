package com.cine.demo.services;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
public class SerieService {
    private final String URL = "https://api.themoviedb.org/3/";

    public ResponseEntity<String> getAllSeries(String nbPage) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "tv/popular?language=fr-FR&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }

    public ResponseEntity<String> searchSeries(String name, String nbPage) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(this.URL + "search/movie?query="+name+"&include_adult=false&language=fr-FR&page="+nbPage);
        return restTemplate.exchange(
                this.URL + "search/tv?query="+name+"&include_adult=false&language=fr-FR&page="+nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }

    public ResponseEntity<String> getSerieDetail(int idSerie) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                this.URL + "/tv/"+idSerie+"?language=fr-FR",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                String.class
        );
    }
}
