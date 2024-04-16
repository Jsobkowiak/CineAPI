package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.entities.cineScape.WishlistTodo;
import com.cine.demo.repositories.WishlistTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI;


@Controller
@RequestMapping(path = "/cineScape")
public class WishlistTodoController {
    @Autowired
    private WishlistTodoRepository repository;


    @GetMapping(path="/getAllWishlistTodoByUser")
    public @ResponseBody Iterable<WishlistTodo> getAllWishlistTodoByUser(@RequestBody Utilisateur user){
        return repository.findByIdUtilisateur(user);
    }

    @PostMapping(path="/postWishlistTodo")
    public @ResponseBody ResponseEntity<String> postWishlistTodo(@RequestBody WishlistTodo wishlistTodo){
        repository.save(wishlistTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body("WishlistTodo created");
    }
}
