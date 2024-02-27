package com.cine.demo.controllers.tmdb;

import com.cine.demo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/tmdb")
public class GenreMediaController {

    @Autowired
    private GenreService genreService;
    @GetMapping(path="/getMovieGenres")
    public @ResponseBody ResponseEntity<String> getMovieGenres(){
        return this.genreService.getAllMovieGenres();
    }

    @GetMapping(path="/getSerieGenres")
    public @ResponseBody ResponseEntity<String> getSerieGenres(){
        return this.genreService.getAllSerieGenres();
    }

}
