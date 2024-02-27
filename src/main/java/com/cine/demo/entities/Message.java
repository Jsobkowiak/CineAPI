package com.cine.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="message")
public class Message {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable=false)
    private Utilisateur idUtilisateur;

    @ManyToOne
    @JoinColumn(name = "id_sujet", nullable=false)
    private Sujet idSujet;
}
