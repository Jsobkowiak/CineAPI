package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.DTO.CategorieForumDTO;
import com.cine.demo.entities.DTO.MessageDTO;
import com.cine.demo.entities.DTO.NoteDTO;
import com.cine.demo.entities.cineScape.Message;
import com.cine.demo.entities.cineScape.Note;
import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.repositories.NoteRepository;
import com.cine.demo.repositories.UtilisateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class NoteController {
    @Autowired
    private NoteRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UtilisateurRepository userRepository;

    @GetMapping(path="/getAllNote")
    public @ResponseBody Iterable<NoteDTO> getAllNotes(){
        Iterable<Note> noteList = repository.findAll();
        ArrayList<NoteDTO> noteDTOList = new ArrayList<>();
        for(Note n: noteList){
            NoteDTO noteDTO = modelMapper.map(n, NoteDTO.class);
            noteDTOList.add(noteDTO);
        }
        return noteDTOList;
    }

    @GetMapping(path="/getNote/{id}")
    public @ResponseBody NoteDTO getNoteById(@PathVariable Long id){
        return modelMapper.map(repository.findById(id), NoteDTO.class);
    }

    @GetMapping(path="/getNotesByMovieId/{id}&nature={nature}")
    public @ResponseBody List<Note> getNotesByMediaIdAndNature(@PathVariable Long id, @PathVariable String nature){
        return repository.getNotesByIdMediaAndNature(id, nature);
    }

    @PostMapping(path = "/postNote")
    public @ResponseBody ResponseEntity<String> postNote(@RequestBody Map<String, String> body){
        Long id = Long.parseLong(body.get("id"));
        int valeur = Integer.parseInt(body.get("note"));
        Long mediaId = Long.parseLong(body.get("id_media"));
        Long userId = Long.parseLong(body.get("id_utilisateur"));
        String nature = body.get("nature");
        Utilisateur user = this.userRepository.findById(userId).get();
        Note note = new Note(id, valeur, user, mediaId, nature);
        repository.save(note);
        return ResponseEntity.status(HttpStatus.CREATED).body("Note created");
    }
}
