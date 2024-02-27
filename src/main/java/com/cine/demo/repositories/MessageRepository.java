package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}