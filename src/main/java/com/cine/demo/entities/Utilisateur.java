package com.cine.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "utilisateur")
public class Utilisateur {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "datecreation")
    private Date datecreation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Message> messageList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Note> noteList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Commentaire> commentaireList;

    @ManyToMany
    @JoinTable(name = "wishlist_todo", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_media"))
    private List<Media> wishlistTODO;

    @ManyToMany
    @JoinTable(name = "wishlist_did", joinColumns = @JoinColumn(name = "id_utilisateur"), inverseJoinColumns = @JoinColumn(name = "id_media"))
    private List<Media> wishlistDID;
}
