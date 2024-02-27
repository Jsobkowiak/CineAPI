package com.cine.demo.controllers.tmdb;

import com.cine.demo.entities.tmdb.Movie;
import com.cine.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/tmdb")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping(value = {"/getPopularMovies", "/getPopularMovies/{nbPage}"})
    public @ResponseBody Iterable<Movie> getPopularMovies(@PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return this.movieService.getAllMovies(nbPage);
    }

    @GetMapping(value= {"/searchMovies/{name}", "/searchMovies/{name}/{nbPage}"})
    public @ResponseBody ResponseEntity<String> searchMovies(@PathVariable String name, @PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return this.movieService.searchFilms(name, nbPage);
    }

    @GetMapping(path="/getMovieById/{idMovie}")
    public @ResponseBody ResponseEntity<String> getMovieById(@PathVariable int idMovie){
        return this.movieService.getMovieDetail(idMovie);
    }

}
