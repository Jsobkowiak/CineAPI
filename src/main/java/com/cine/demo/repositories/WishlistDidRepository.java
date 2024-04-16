package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Utilisateur;
import com.cine.demo.entities.cineScape.WishlistDid;
import com.cine.demo.entities.cineScape.WishlistTodo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistDidRepository extends JpaRepository<WishlistDid, Long> {
    List<WishlistDid> findByIdUtilisateur(Utilisateur utilisateur);

}