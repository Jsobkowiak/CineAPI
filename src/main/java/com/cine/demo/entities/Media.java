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
@Entity(name="media")
public class Media {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="releaseDate")
    private String releaseDate;

    @Column(name="urlImage")
    private String urlImage;


    @OneToMany(mappedBy = "idMedia")
    private List<Commentaire> commentaireList;

    @OneToMany(mappedBy = "idMedia")
    private List<Note> noteList;


    @ManyToMany(mappedBy = "mediaList")
    private List<Genre> genreList;

    @ManyToMany(mappedBy = "wishlistTODO")
    private List<Utilisateur> userWishlistTODO;

    @ManyToMany(mappedBy = "wishlistDID")
    private List<Utilisateur> userWishlistDID;

}
