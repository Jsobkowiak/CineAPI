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
public class Movie extends Media{

    private Date release_date;

    public Movie(Date release_date, int id, String title, String backdrop_path,
                 String poster_path, String desc, Iterable<Genre> genres) {
        super(id, title, backdrop_path, poster_path, desc, genres);
        this.release_date = release_date;
    }
}
