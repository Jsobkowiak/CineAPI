package com.cine.demo.controllers;

import com.cine.demo.entities.Client;
import com.cine.demo.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class ClientController {
    @Autowired
    private ClientRepository repository;


    @GetMapping(path="/api/client")
    public @ResponseBody Iterable<Client> allClient(){
        return repository.findAll();
    }
}
