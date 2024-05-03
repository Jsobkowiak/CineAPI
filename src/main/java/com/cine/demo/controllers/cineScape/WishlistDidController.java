package com.cine.demo.controllers.cineScape;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.entities.cineScape.WishlistDid;
import com.cine.demo.repositories.UtilisateurRepository;
import com.cine.demo.repositories.WishlistDidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@Controller
@RequestMapping(path = "/cineScape")
public class WishlistDidController {
    @Autowired
    private WishlistDidRepository repository;

    @Autowired
    private UtilisateurRepository userRepository;

    @PostMapping(path="/getAllWishlistDidByUser")
    public @ResponseBody Iterable<WishlistDid> getAllWishlistDidByUser(@RequestBody Utilisateur user){
        return repository.findByIdUtilisateur(user);
    }

    @PostMapping(path="/postWishlistDid")
    public @ResponseBody ResponseEntity<String> postWishlistDid(@RequestBody Map<String, String> body){
        Long id = Long.parseLong(body.get("id"));
        Long mediaId = Long.parseLong(body.get("id_media"));
        Long userId = Long.parseLong(body.get("id_utilisateur"));
        String nature = body.get("nature");
        Utilisateur user = this.userRepository.findById(userId).get();
        WishlistDid wishlistDid = new WishlistDid(id, user, mediaId, nature);
        repository.save(wishlistDid);
        return ResponseEntity.status(HttpStatus.CREATED).body("WishlistDid created");
    }

    @DeleteMapping(path = "/deleteWishlistDid/{id}")
    public @ResponseBody ResponseEntity<String> deleteWishlistDid(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("WishlistDid deleted");
    }
}
