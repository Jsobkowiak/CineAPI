package com.cine.demo.repositories;

import com.cine.demo.entities.Sujet;
import com.cine.demo.entities.WishlistTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistTodoRepository extends JpaRepository<WishlistTodo, Long> {
}