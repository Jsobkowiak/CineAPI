package com.cine.demo.controllers;

import com.cine.demo.entities.Message;
import com.cine.demo.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class MessageController {
    @Autowired
    private MessageRepository repository;


    @GetMapping(path="/api/getAllMessage")
    public @ResponseBody Iterable<Message> getAllMessages(){
        return repository.findAll();
    }

    @GetMapping(path="/api/getMessage/{id}")
    public @ResponseBody Optional<Message> getMessageById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/api/postMessage")
    public @ResponseBody String postMessage(@RequestBody Message com){
        repository.save(com);
        return "200";
    }
}
