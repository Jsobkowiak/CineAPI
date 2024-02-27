package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}