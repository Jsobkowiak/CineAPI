package com.cine.demo.services;

import com.cine.demo.entities.tmdb.Media;
import com.cine.demo.entities.tmdb.Movie;
import com.cine.demo.entities.tmdb.Search;
import com.cine.demo.entities.tmdb.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MediaService {

    @Autowired
    private MovieService movieService;

    @Autowired
    private SerieService serieService;

    public Search searchMedias(String search, String page){
        Search movies = this.movieService.searchFilms(search, "1");
        Search series = this.serieService.searchSeries(search, "1");
        ArrayList<Media> result = new ArrayList<>();
        int total_pages = movies.getTotal_pages() + series.getTotal_pages();
        int total_results = movies.getTotal_results() + series.getTotal_results();
        result.addAll((ArrayList<Media>) movies.getMedias());
        result.addAll((ArrayList<Media>) series.getMedias());

        return new Search(total_pages, total_results, result);
    }
}
