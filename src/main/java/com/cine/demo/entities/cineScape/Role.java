package com.cine.demo.entities.cineScape;

import com.cine.demo.entities.ERole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable=false)
    private Utilisateur idUtilisateur;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    // getters and setters
}