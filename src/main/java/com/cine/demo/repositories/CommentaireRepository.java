package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}