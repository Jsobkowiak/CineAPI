package com.cine.demo.entities.cineScape;

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
@Entity(name="sujet")
public class Sujet {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_categorieforum", nullable=false)
    private CategorieForum idCategorieForum;

    @OneToMany(mappedBy = "idSujet")
    private List<Message> messageList;

}
