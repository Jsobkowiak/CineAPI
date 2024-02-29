package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.CategorieForum;
import com.cine.demo.repositories.CategorieForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class CategorieForumController {
    @Autowired
    private CategorieForumRepository repository;


    @GetMapping(path="/getAllCategoriesForum")
    public @ResponseBody Iterable<CategorieForum> getAllCategoriesForum(){
        return repository.findAll();
    }

    @GetMapping(path="/getCategorieForum/{id}")
    public @ResponseBody Optional<CategorieForum> getCategorieForumById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/postCategorieForum")
    public @ResponseBody ResponseEntity<String> postCategorieForum(@RequestBody CategorieForum com){
        repository.save(com);
        return ResponseEntity.ok("categorie forum created");
    }
}
