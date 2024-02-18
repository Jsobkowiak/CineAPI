package com.cine.demo.repositories;

import com.cine.demo.entities.Message;
import com.cine.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}