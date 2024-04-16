package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> getNotesByIdMediaAndNature(Long idMedia, String nature);
}