package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.DTO.CommentaireDTO;
import com.cine.demo.entities.DTO.MessageDTO;
import com.cine.demo.entities.cineScape.Commentaire;
import com.cine.demo.entities.cineScape.Message;
import com.cine.demo.repositories.MessageRepository;
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
public class MessageController {
    @Autowired
    private MessageRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    @GetMapping(path="/getAllMessage")
    public @ResponseBody Iterable<MessageDTO> getAllMessages(){
        Iterable<Message> messList = repository.findAll();
        ArrayList<MessageDTO> messDTOList = new ArrayList<>();
        for(Message m: messList){
            MessageDTO messDTO = modelMapper.map(m, MessageDTO.class);
            messDTOList.add(messDTO);
        }
        return messDTOList;
    }

    @GetMapping(path="/getMessage/{id}")
    public @ResponseBody MessageDTO getMessageById(@PathVariable Long id){
        return modelMapper.map(repository.findById(id), MessageDTO.class);
    }

    @PostMapping(path = "/postMessage")
    public @ResponseBody ResponseEntity<String> postMessage(@RequestBody Message com){
        repository.save(com);
        return ResponseEntity.status(HttpStatus.CREATED).body("Message created");    }
}
