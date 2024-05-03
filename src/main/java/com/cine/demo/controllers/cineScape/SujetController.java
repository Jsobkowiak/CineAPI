package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.DTO.SujetDTO;
import com.cine.demo.entities.DTO.UtilisateurDTO;
import com.cine.demo.entities.cineScape.Sujet;
import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.SujetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class SujetController {
    @Autowired
    private SujetRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(path="/getAllSujet")
    public @ResponseBody Iterable<SujetDTO> getAllSujets(){
        Iterable<Sujet> sujets = repository.findAll();
        ArrayList<SujetDTO> sujetsDTO = new ArrayList<>();
        for(Sujet s: sujets){
            SujetDTO sujetDTO = modelMapper.map(s, SujetDTO.class);
            sujetsDTO.add(sujetDTO);
        }
        return sujetsDTO;
    }

    @GetMapping(path="/getSujet/{id}")
    public @ResponseBody SujetDTO getSujetById(@PathVariable Long id){
        return modelMapper.map(repository.findById(id), SujetDTO.class);
    }

    @PostMapping(path = "/postSujet")
    public @ResponseBody ResponseEntity<String> postSujet(@RequestBody Sujet com){
        repository.save(com);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sujet created");    }
}
