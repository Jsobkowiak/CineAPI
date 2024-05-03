package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.entities.cineScape.WishlistDid;
import com.cine.demo.entities.cineScape.WishlistTodo;
import com.cine.demo.repositories.UtilisateurRepository;
import com.cine.demo.repositories.WishlistTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping(path = "/cineScape")
public class WishlistTodoController {
    @Autowired
    private WishlistTodoRepository repository;

    @Autowired
    private UtilisateurRepository userRepository;

    @PostMapping(path="/getAllWishlistTodoByUser")
    public @ResponseBody Iterable<WishlistTodo> getAllWishlistTodoByUser(@RequestBody Utilisateur user){
        return repository.findByIdUtilisateur(user);
    }

    @PostMapping(path="/postWishlistTodo")
    public @ResponseBody ResponseEntity<String> postWishlistTodo(@RequestBody Map<String, String> body){
        Long id = Long.parseLong(body.get("id"));
        Long mediaId = Long.parseLong(body.get("id_media"));
        Long userId = Long.parseLong(body.get("id_utilisateur"));
        String nature = body.get("nature");
        Utilisateur user = this.userRepository.findById(userId).get();
        WishlistTodo wishlistTodo = new WishlistTodo(id, user, mediaId, nature);
        repository.save(wishlistTodo);
        return ResponseEntity.status(HttpStatus.CREATED).body("WishlistTodo created");
    }

    @DeleteMapping(path = "/deleteWishlistTodo/{id}")
    public @ResponseBody ResponseEntity<String> deleteWishlistTodo(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("WishlistTodo deleted");
    }
}
