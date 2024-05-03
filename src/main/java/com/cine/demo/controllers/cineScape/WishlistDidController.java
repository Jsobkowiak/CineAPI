package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.entities.cineScape.WishlistDid;
import com.cine.demo.repositories.WishlistDidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping(path = "/cineScape")
public class WishlistDidController {
    @Autowired
    private WishlistDidRepository repository;


    @PostMapping(path="/getAllWishlistDidByUser")
    public @ResponseBody Iterable<WishlistDid> getAllWishlistDidByUser(@RequestBody Utilisateur user){
        return repository.findByIdUtilisateur(user);
    }

    @PostMapping(path="/postWishlistDid")
    public @ResponseBody ResponseEntity<String> postWishlistDid(@RequestBody WishlistDid wishlistDid){
        repository.save(wishlistDid);
        return ResponseEntity.status(HttpStatus.CREATED).body("WishlistDid created");
    }

    @DeleteMapping(path = "/deleteWishlistDid/{id}")
    public @ResponseBody ResponseEntity<String> deleteWishlistDid(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("WishlistDid deleted");
    }
}
