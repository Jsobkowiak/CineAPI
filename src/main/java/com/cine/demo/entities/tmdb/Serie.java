package com.cine.demo.entities.tmdb;

public class Serie extends Media{
    private Iterable<Saison> seasons;

    private int numberEpisodes;

    private int numberSaisons;

    public Serie(Iterable<Saison> seasons, int numberEpisodes, int numberSaisons, int id, String title, String backgdrop_path, String poster_path, String desc, Iterable<Genre> genres) {
        super(id, title, backgdrop_path, poster_path, desc, genres);
        this.seasons = seasons;
        this.numberEpisodes = numberEpisodes;
        this.numberSaisons = numberSaisons;
    }
}
