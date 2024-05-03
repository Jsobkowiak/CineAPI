package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.DTO.UtilisateurDTO;
import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.UtilisateurRepository;
import com.cine.demo.services.AuthService;
import com.google.common.hash.Hashing;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class UtilisateurController {
    @Autowired
    private UtilisateurRepository repository;

    @Autowired
    private AuthService authService;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(path = "/getAllUtilisateurs")
    public @ResponseBody Iterable<UtilisateurDTO> getAllUtilisateurs() {
        Iterable<Utilisateur> users = repository.findAll();
        ArrayList<UtilisateurDTO> usersDTO = new ArrayList<>();
        for(Utilisateur u: users){
            UtilisateurDTO utilisateurDTO = modelMapper.map(u, UtilisateurDTO.class);
            usersDTO.add(utilisateurDTO);
        }
        return usersDTO;
    }

    @GetMapping(path = "/getUtilisateur/{id}")
    public @ResponseBody UtilisateurDTO getUtilisateurById(@PathVariable Long id) {
        return modelMapper.map(repository.findById(id), UtilisateurDTO.class);
    }

    @PostMapping(path = "/postUtilisateur")
    public @ResponseBody ResponseEntity<String> postUtilisateur(@RequestBody Utilisateur user) {
        user.setPassword(Hashing.sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString());
        user.setDatecreation(new Date());
        Optional<Utilisateur> userExist = repository.findByEmail(user.getEmail());
        if (userExist.isEmpty()) {
            repository.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("email already exists");
        }
    }

    @PostMapping(path = "/authUtilisateur")
    public @ResponseBody ResponseEntity<Map<String, Object>> authUtilisateur(@RequestBody Map<String, String> json) {
        return this.authService.authenticate(json.get("email"), json.get("password"));
    }
}
