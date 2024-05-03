package com.cine.demo.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {

    private Long id;

    private int note;

    private Long idUtilisateur;

    private Long idMedia;

    private String nature;
}
