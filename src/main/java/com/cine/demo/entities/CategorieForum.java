package com.cine.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="categorie_forum")
public class CategorieForum {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="libelle")
    private String libelle;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idCategorieForum", cascade = CascadeType.ALL)
    private List<Sujet> sujetList;


}
