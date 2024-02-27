package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.Message;
import com.cine.demo.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/cineScape")
public class MessageController {
    @Autowired
    private MessageRepository repository;


    @GetMapping(path="/getAllMessage")
    public @ResponseBody Iterable<Message> getAllMessages(){
        return repository.findAll();
    }

    @GetMapping(path="/getMessage/{id}")
    public @ResponseBody Optional<Message> getMessageById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping(path = "/postMessage")
    public @ResponseBody String postMessage(@RequestBody Message com){
        repository.save(com);
        return "200";
    }
}
