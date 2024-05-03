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
@Entity(name="wishlistDid")
public class WishlistDid {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable=false)
    private Utilisateur idUtilisateur;

    @Column(name="id_media")
    private Long idMedia;

    @Column(name="nature")
    private String nature;
}
