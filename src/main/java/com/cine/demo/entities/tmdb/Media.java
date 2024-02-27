package com.cine.demo.entities.tmdb;

public abstract class Media {

    private int id;
    private String title;

    private String backgdrop_path;

    private String poster_path;

    private String desc;

    private Iterable<Genre> genres;

    public Media(int id, String title, String backgdrop_path, String poster_path, String desc, Iterable<Genre> genres) {
        this.id = id;
        this.title = title;
        this.backgdrop_path = backgdrop_path;
        this.poster_path = poster_path;
        this.desc = desc;
        this.genres = genres;
    }
}
