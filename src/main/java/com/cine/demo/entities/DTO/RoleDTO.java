package com.cine.demo.entities.DTO;

import com.cine.demo.entities.ERole;

public class RoleDTO {

    private Integer id;

    private ERole name;
    private UtilisateurDTO idUtilisateur;

    public RoleDTO() {

    }

    public RoleDTO(ERole name) {
        this.name = name;
    }

    // getters and setters
}