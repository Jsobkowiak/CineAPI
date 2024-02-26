package com.cine.demo.controllers.tmdb;

import com.cine.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping(path="/getPopularMovies/{nbPage}")
    public @ResponseBody ResponseEntity<String> getPopularMovies(@PathVariable int nbPage){
        return this.movieService.getAllMovies(nbPage);
    }

    @GetMapping(path="/searchMovies/{name}/{nbPage}")
    public @ResponseBody ResponseEntity<String> searchMovies(@PathVariable String name, @PathVariable int nbPage){
        return this.movieService.searchFilms(name, nbPage);
    }

}
