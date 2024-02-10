package com.cine.demo.controllers;

import com.cine.demo.entities.Utilisateur;
import com.cine.demo.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository repository;


    @GetMapping(path="/api/utilisateur")
    public @ResponseBody Iterable<Utilisateur> allUtilisateur(){
        return repository.findAll();
    }
}
