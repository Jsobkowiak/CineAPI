package com.cine.demo.entities.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategorieForumDTO {

    private Long id;

    private String libelle;

    private List<SujetDTO> sujetList;


}
