package com.cine.demo.entities.tmdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Serie extends Media{
    private Iterable<Saison> seasons;

    private int numberEpisodes;

    private int numberSaisons;

    public Serie(Iterable<Saison> seasons, int numberEpisodes, int numberSaisons, int id, String title, String backdrop_path, String poster_path, String desc, Iterable<Genre> genres) {
        super(id, title, backdrop_path, poster_path, desc, genres);
        this.seasons = seasons;
        this.numberEpisodes = numberEpisodes;
        this.numberSaisons = numberSaisons;
    }
}
