package com.cine.demo.repositories;

import com.cine.demo.entities.Media;
import com.cine.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}