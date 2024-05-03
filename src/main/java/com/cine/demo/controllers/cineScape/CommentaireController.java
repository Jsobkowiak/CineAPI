package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.DTO.CategorieForumDTO;
import com.cine.demo.entities.DTO.CommentaireDTO;
import com.cine.demo.entities.cineScape.Commentaire;
import com.cine.demo.repositories.CommentaireRepository;
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
public class CommentaireController {
    @Autowired
    private CommentaireRepository repository;

    ModelMapper modelMapper = new ModelMapper();


    @GetMapping(path="/getAllCommentaire")
    public @ResponseBody Iterable<CommentaireDTO> getAllCommentaire(){
        Iterable<Commentaire> comList = repository.findAll();
        ArrayList<CommentaireDTO> comDTOList = new ArrayList<>();
        for(Commentaire c: comList){
            CommentaireDTO comDTO = modelMapper.map(c, CommentaireDTO.class);
            comDTOList.add(comDTO);
        }
        return comDTOList;
    }

    @GetMapping(path="/getCommentaire/{id}")
    public @ResponseBody CommentaireDTO getCommentaireById(@PathVariable Long id){
        return modelMapper.map(repository.findById(id), CommentaireDTO.class);
    }

    @PostMapping(path = "/postCommentaire")
    public @ResponseBody ResponseEntity<String> postCommentaire(@RequestBody Commentaire com){
        repository.save(com);
        return ResponseEntity.status(HttpStatus.CREATED).body("Commentaire created");    }
}
