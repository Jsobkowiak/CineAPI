package com.cine.demo.entities.tmdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Saison {
    private int id;

    private String name;

    private Date release_date;

    private int episode_count;
}
