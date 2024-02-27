package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository repository;

    @GetMapping(path="/getAllUtilisateurs")
    public @ResponseBody Iterable<Utilisateur> getAllUtilisateurs(){
        return repository.findAll();
    }

    @GetMapping(path="/getUtilisateur/{id}")
    public @ResponseBody Optional<Utilisateur> getUtilisateurById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/postUtilisateur")
    public @ResponseBody String postUtilisateur(@RequestBody Utilisateur user){
        repository.save(user);
        return "200";
    }
}
