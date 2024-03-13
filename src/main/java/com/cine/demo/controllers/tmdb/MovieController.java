package com.cine.demo.controllers.tmdb;

import com.cine.demo.entities.tmdb.Media;
import com.cine.demo.entities.tmdb.Movie;
import com.cine.demo.entities.tmdb.Search;
import com.cine.demo.services.MovieService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path = "/tmdb")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping(value = {"/getPopularMovies", "/getPopularMovies/{nbPage}"})
    public @ResponseBody ResponseEntity<Iterable<Media>> getPopularMovies(@PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return ResponseEntity.ok(this.movieService.getAllMovies(nbPage));
    }

    @GetMapping(value= {"/searchMovies/{name}", "/searchMovies/{name}/{nbPage}"})
    public @ResponseBody ResponseEntity<Search> searchMovies(@PathVariable String name, @PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return ResponseEntity.ok(this.movieService.searchFilms(name, nbPage));
    }

    @GetMapping(path="/getMovieById/{idMovie}")
    public @ResponseBody ResponseEntity<Movie> getMovieById(@PathVariable int idMovie){
        return ResponseEntity.ok(this.movieService.getMovieDetail(idMovie));
    }

}
