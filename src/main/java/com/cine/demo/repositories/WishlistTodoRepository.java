package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.WishlistTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistTodoRepository extends JpaRepository<WishlistTodo, Long> {
}