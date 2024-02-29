package com.cine.demo.services;

import com.cine.demo.entities.tmdb.Media;
import com.cine.demo.entities.tmdb.Movie;
import com.cine.demo.entities.tmdb.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MediaService {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SerieService serieService;

    public Iterable<Media> searchMedias(String search, String page){
        ArrayList<Movie> movies =  (ArrayList<Movie>) this.movieService.searchFilms(search, "1");
        ArrayList<Serie> series = (ArrayList<Serie>) this.serieService.searchSeries(search, "1");
        ArrayList<Media> result = new ArrayList<>();
        result.addAll(movies);
        result.addAll(series);
        return result;
    }
}
