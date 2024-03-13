package com.cine.demo.entities.tmdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Search {
    private int total_pages;

    private int total_results;

    private Iterable<Media> medias;
}
