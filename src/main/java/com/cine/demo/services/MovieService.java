package com.cine.demo.services;

import com.cine.demo.entities.tmdb.Genre;
import com.cine.demo.entities.tmdb.Movie;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service
@NoArgsConstructor
public class MovieService {
    private final String URL = "https://api.themoviedb.org/3/";

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GenreService genreService;


    public Iterable<Movie> getAllMovies(String nbPage) {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "/movie/popular?language=fr-FR&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );
        return createMovieArray(response);
    }

    public Iterable<Movie> searchFilms(String name, String nbPage) {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "search/movie?query=" + name + "&include_adult=false&language=fr-FR&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );
        return createMovieArray(response);
    }

    public Movie getMovieDetail(int idMovie) {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "/movie/" + idMovie + "?language=fr-FR",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );
        Map body = response.getBody();

        ArrayList<Genre> genresMovies = new ArrayList<>();
        ArrayList genresMovieBrut = (ArrayList) body.get("genres");
        for (Object o : genresMovieBrut) {
            Map g = (Map) o;
            genresMovies.add(new Genre((int) g.get("id"), (String) g.get("name")));
        }

        return createMovie(body, genresMovies);
    }

    private Iterable<Movie> createMovieArray(ResponseEntity<Map> response) {
        // ARRAY DE RETOUR (LISTE DE MOVIE)
        ArrayList<Movie> movies = new ArrayList<>();

        // BODY DU RETOUR DE L'APPEL API
        ArrayList body = (ArrayList) response.getBody().get("results");

        // RECUP DE TOUS LES GENRES POSSIBLES DES MOVIES
        ArrayList<Genre> genres = (ArrayList<Genre>) this.genreService.getAllMovieGenres();

        // PARCOURS DE TOUS LES MOVIES DANS LE BODY
        for (Object value : body) {
            Map movieInfo = (Map) value;

            ArrayList<Genre> genresMovies = new ArrayList<>();
            // RECUP DES IDS DES GENRES DU MOVIE
            ArrayList genresMovieBrut = (ArrayList) movieInfo.get("genre_ids");

            // PARCOURS DE TOUS LES IDS DES GENRES DU MOVIE
            for (Object o : genresMovieBrut) {

                // RECHERCHE DE QUEL GENRE IL S'AGIT PARMIS CEUX DEJA RECUPERE
                for (Genre g : genres) {
                    if (g.getId() == (int) o) {
                        genresMovies.add(g);
                    }
                }
            }

            // CREATION ET AJOUT D'UN MOVIE A L'ARRAY DE RETOUR
            movies.add(createMovie(movieInfo, genresMovies));
        }
        return movies;
    }

    private Movie createMovie(Map body, Iterable<Genre> genres) {
        String title = (String) body.get("title");
        int id = (int) body.get("id");
        String backdrop_path = (String) body.get("backdrop_path");
        String poster_path = (String) body.get("poster_path");
        String desc = (String) body.get("overview");
        Date release_date = null;
        String strDate = (String) body.get("release_date");
        if (!strDate.isEmpty()) {
            try {
                release_date = this.formatter.parse((String) body.get("release_date"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return new Movie(release_date, id, title, backdrop_path, poster_path, desc, genres);
    }

}
