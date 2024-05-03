package com.cine.demo.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentaireDTO {

    private Long id;

    private String text;

    private Long idUtilisateur;

    private Long idMedia;
}
