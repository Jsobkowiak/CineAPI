package com.cine.demo.entities.tmdb;

import java.util.Date;

public class Movie extends Media{

    private Date release_date;

    public Movie(Date release_date, int id, String title, String backgdrop_path, String poster_path, String desc, Iterable<Genre> genres) {
        super(id, title, backgdrop_path, poster_path, desc, genres);
        this.release_date = release_date;
    }
}
