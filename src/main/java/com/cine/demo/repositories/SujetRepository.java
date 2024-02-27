package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
}