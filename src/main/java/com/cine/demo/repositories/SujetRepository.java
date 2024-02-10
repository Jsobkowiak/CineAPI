package com.cine.demo.repositories;

import com.cine.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Utilisateur, Long> {
}