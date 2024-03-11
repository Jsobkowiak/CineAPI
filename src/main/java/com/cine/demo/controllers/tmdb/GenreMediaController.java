package com.cine.demo.controllers.tmdb;

import com.cine.demo.entities.tmdb.Genre;
import com.cine.demo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path = "/tmdb")
public class GenreMediaController {

    @Autowired
    private GenreService genreService;
    @GetMapping(path="/getMovieGenres")
    public @ResponseBody ResponseEntity<Iterable<Genre>> getMovieGenres(){
        return ResponseEntity.ok(this.genreService.getAllMovieGenres());
    }

    @GetMapping(path="/getSerieGenres")
    public @ResponseBody ResponseEntity<Iterable<Genre>> getSerieGenres(){
        return  ResponseEntity.ok(this.genreService.getAllSerieGenres());
    }

}
