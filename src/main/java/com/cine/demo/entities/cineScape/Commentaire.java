package com.cine.demo.entities.cineScape;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="commentaire")
public class Commentaire {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable=false)
    private Utilisateur idUtilisateur;

    @Column(name="id_media")
    private Long idMedia;
}
