package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.CategorieForum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieForumRepository extends JpaRepository<CategorieForum, Long> {
}