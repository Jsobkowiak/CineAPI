package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}