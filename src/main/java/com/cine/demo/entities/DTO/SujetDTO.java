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
public class SujetDTO {

    private Long id;

    private String title;

    private Long idCategorieForum;

    private List<MessageDTO> messageList;

}
