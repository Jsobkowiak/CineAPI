package com.cine.demo.entities.tmdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Media {

    private int id;
    private String title;

    private String backdrop_path;

    private String poster_path;

    private String desc;

    private Iterable<Genre> genres;

}
