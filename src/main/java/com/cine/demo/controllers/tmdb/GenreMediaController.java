package com.cine.demo.controllers.tmdb;

import com.cine.demo.services.GenreService;
import com.cine.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class GenreMediaController {

    @Autowired
    private GenreService genreService;
    @GetMapping(path="/getMovieGenres/")
    public @ResponseBody ResponseEntity<String> getMovieGenres(){
        return this.genreService.getAllMovieGenres();
    }

    @GetMapping(path="/searchMovies/{name}/{nbPage}")
    public @ResponseBody ResponseEntity<String> getSerieGenres(){
        return this.genreService.getAllSerieGenres();
    }

}