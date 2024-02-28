package com.cine.demo.entities.cineScape;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Role> roles;

    @Column(name = "datecreation")
    private Date datecreation;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Message> messageList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Note> noteList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idUtilisateur", cascade = CascadeType.ALL)
    private List<Commentaire> commentaireList;

    @OneToMany(mappedBy = "idUtilisateur")
    private List<WishlistDid> wishlistDidList;

    @OneToMany(mappedBy = "idUtilisateur")
    private List<WishlistTodo> wishlistTodoList;
}
