package com.cine.demo.entities.tmdb;

import java.util.Date;

public class Saison {
    private int id;

    private String name;

    private Date release_date;

    private int episode_count;

    public Saison(int id, String name, Date release_date, int episode_count) {
        this.id = id;
        this.name = name;
        this.release_date = release_date;
        this.episode_count = episode_count;
    }
}
