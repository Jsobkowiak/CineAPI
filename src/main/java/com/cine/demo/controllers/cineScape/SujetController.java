package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Sujet;
import com.cine.demo.repositories.SujetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class SujetController {
    @Autowired
    private SujetRepository repository;


    @GetMapping(path="/getAllSujet")
    public @ResponseBody Iterable<Sujet> getAllSujets(){
        return repository.findAll();
    }

    @GetMapping(path="/getSujet/{id}")
    public @ResponseBody Optional<Sujet> getSujetById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/postSujet")
    public @ResponseBody String postSujet(@RequestBody Sujet com){
        repository.save(com);
        return "200";
    }
}
