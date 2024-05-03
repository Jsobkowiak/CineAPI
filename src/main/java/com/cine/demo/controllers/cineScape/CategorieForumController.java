package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.DTO.CategorieForumDTO;
import com.cine.demo.entities.DTO.UtilisateurDTO;
import com.cine.demo.entities.cineScape.CategorieForum;
import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.CategorieForumRepository;
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
public class CategorieForumController {
    @Autowired
    private CategorieForumRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(path="/getAllCategoriesForum")
    public @ResponseBody Iterable<CategorieForumDTO> getAllCategoriesForum(){
        Iterable<CategorieForum> catList = repository.findAll();
        ArrayList<CategorieForumDTO> catDTOList = new ArrayList<>();
        for(CategorieForum c: catList){
            CategorieForumDTO catDTO = modelMapper.map(c, CategorieForumDTO.class);
            catDTOList.add(catDTO);
        }
        return catDTOList;
    }

    @GetMapping(path="/getCategorieForum/{id}")
    public @ResponseBody CategorieForumDTO getCategorieForumById(@PathVariable Long id){
        return modelMapper.map(repository.findById(id), CategorieForumDTO.class);
    }

    @PostMapping(path = "/postCategorieForum")
    public @ResponseBody ResponseEntity<String> postCategorieForum(@RequestBody CategorieForum com){
        repository.save(com);
        return ResponseEntity.status(HttpStatus.CREATED).body("Categorie forum created");    }
}
