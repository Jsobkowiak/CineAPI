package com.cine.demo.controllers;

import com.cine.demo.services.MovieService;
import jakarta.websocket.server.PathParam;
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
    public @ResponseBody ResponseEntity<String> getPopularMovies(@PathParam("nbPage") int nbPage){
        return this.movieService.getAllMovies(nbPage);
    }
}
