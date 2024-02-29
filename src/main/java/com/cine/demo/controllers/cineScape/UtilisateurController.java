package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.UtilisateurRepository;
import com.cine.demo.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository repository;

    @Autowired
    private AuthService authService;

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

    @GetMapping(path = "/authUtilisateur")
    public @ResponseBody ResponseEntity<Map<String, Object>> authUtilisateur(){
        return this.authService.authenticate("", "");
    }
}
