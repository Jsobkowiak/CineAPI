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
@Entity(name="genre")
public class Genre {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="libelle")
    private String libelle;

    @ManyToMany
    @JoinTable(name = "type", joinColumns = @JoinColumn(name = "id_media"), inverseJoinColumns = @JoinColumn(name = "id_genre"))
    private List<Media> mediaList;

}
