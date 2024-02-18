package com.cine.demo.controllers;

import com.cine.demo.entities.Media;
import com.cine.demo.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class MediaController {
    @Autowired
    private MediaRepository repository;


    @GetMapping(path="/api/getAllMedia")
    public @ResponseBody Iterable<Media> getAllMedias(){
        return repository.findAll();
    }

    @GetMapping(path="/api/getMedia/{id}")
    public @ResponseBody Optional<Media> getMediaById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/api/postMedia")
    public @ResponseBody String postMedia(@RequestBody Media com){
        repository.save(com);
        return "200";
    }
}
