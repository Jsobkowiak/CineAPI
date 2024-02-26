package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.Genre;
import com.cine.demo.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class GenreController {
    @Autowired
    private GenreRepository repository;


    @GetMapping(path="/api/getAllGenre")
    public @ResponseBody Iterable<Genre> getAllGenres(){
        return repository.findAll();
    }

    @GetMapping(path="/api/getGenre/{id}")
    public @ResponseBody Optional<Genre> getGenreById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/api/postGenre")
    public @ResponseBody String postGenre(@RequestBody Genre com){
        repository.save(com);
        return "200";
    }
}
