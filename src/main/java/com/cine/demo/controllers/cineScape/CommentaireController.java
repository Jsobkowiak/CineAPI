package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.Commentaire;
import com.cine.demo.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class CommentaireController {
    @Autowired
    private CommentaireRepository repository;


    @GetMapping(path="/getAllCommentaire")
    public @ResponseBody Iterable<Commentaire> getAllCommentaire(){
        return repository.findAll();
    }

    @GetMapping(path="/getCommentaire/{id}")
    public @ResponseBody Optional<Commentaire> getCommentaireById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/postCommentaire")
    public @ResponseBody String postCommentaire(@RequestBody Commentaire com){
        repository.save(com);
        return "200";
    }
}
