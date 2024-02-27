package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Note;
import com.cine.demo.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class NoteController {
    @Autowired
    private NoteRepository repository;


    @GetMapping(path="/getAllNote")
    public @ResponseBody Iterable<Note> getAllNotes(){
        return repository.findAll();
    }

    @GetMapping(path="/getNote/{id}")
    public @ResponseBody Optional<Note> getNoteById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/postNote")
    public @ResponseBody String postNote(@RequestBody Note com){
        repository.save(com);
        return "200";
    }
}
