package com.cine.demo.controllers;

import com.cine.demo.entities.CategorieForum;
import com.cine.demo.repositories.CategorieForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class CategorieForumController {
    @Autowired
    private CategorieForumRepository repository;


    @GetMapping(path="/api/getAllCategoriesForum")
    public @ResponseBody Iterable<CategorieForum> getAllCategoriesForum(){
        return repository.findAll();
    }

    @GetMapping(path="/api/getCategorieForum/{id}")
    public @ResponseBody Optional<CategorieForum> getCategorieForumById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/api/postCategorieForum")
    public @ResponseBody String postCategorieForum(@RequestBody CategorieForum com){
        repository.save(com);
        return "200";
    }
}
