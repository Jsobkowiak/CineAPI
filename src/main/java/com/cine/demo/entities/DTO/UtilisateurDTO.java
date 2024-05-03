package com.cine.demo.entities.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UtilisateurDTO {

    private Long id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Date datecreation;

    private List<MessageDTO> messageList;

    private List<NoteDTO> noteList;

    private List<CommentaireDTO> commentaireList;

    private List<WishlistDidDTO> wishlistDidList;

    private List<WishlistTodoDTO> wishlistTodoList;
}
