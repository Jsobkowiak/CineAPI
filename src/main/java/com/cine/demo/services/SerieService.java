package com.cine.demo.services;

import com.cine.demo.entities.tmdb.*;

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
public class SerieService {
    private final String URL = "https://api.themoviedb.org/3/";

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GenreService genreService;

    public Iterable<Media> getAllSeries(String nbPage) {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "tv/popular?language=en-US&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );
        return createSerieArray(response);
    }

    public Search searchSeries(String name, String nbPage) {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "search/tv?query=" + name + "&include_adult=false&language=en-US&page=" + nbPage,
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );

        return new Search((int) response.getBody().get("total_pages"),(int) response.getBody().get("total_results"), createSerieArray(response));
    }

    public Serie getSerieDetail(int idSerie) {
        ResponseEntity<Map> response = restTemplate.exchange(
                this.URL + "/tv/" + idSerie + "?language=en-US",
                HttpMethod.GET,
                HttpEntityService.createHttpEntity(),
                Map.class
        );

        Map body = response.getBody();

        ArrayList<Genre> genresSerie = new ArrayList<>();
        ArrayList<Saison> saisonsSerie = new ArrayList<>();

        ArrayList genresSerieBrut = (ArrayList) body.get("genres");
        ArrayList saisonsBrut = (ArrayList) body.get("seasons");

        for (Object o : genresSerieBrut) {
            Map g = (Map) o;
            genresSerie.add(new Genre((int) g.get("id"), (String) g.get("name")));
        }
        for (Object o : saisonsBrut) {
            Map s = (Map) o;
            Date release_date = null;
            String strDate = (String) s.get("air_date");
            if (!strDate.isEmpty()) {
                try {
                    release_date = this.formatter.parse(strDate);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            saisonsSerie.add(new Saison((int) s.get("id"), (String) s.get("name"), release_date, (int) s.get("episode_count"), (String) s.get("overview"), (String) s.get("poster_path")));
        }
        return createSerie(body, genresSerie, saisonsSerie, (int) body.get("number_of_episodes"), (int) body.get("number_of_seasons"));
    }

    private Iterable<Media> createSerieArray(ResponseEntity<Map> response) {
        // ARRAY DE RETOUR (LISTE DE SERIES)
        ArrayList<Media> medias = new ArrayList<>();

        // BODY DU RETOUR DE L'APPEL API
        ArrayList body = (ArrayList) response.getBody().get("results");

        // RECUP DE TOUS LES GENRES POSSIBLES DES SERIES
        ArrayList<Genre> genres = (ArrayList<Genre>) this.genreService.getAllSerieGenres();
        for (Object value : body) {
            Map serieInfo = (Map) value;

            ArrayList<Genre> genresSeries = new ArrayList<>();
            // RECUP DES IDS DES GENRES DU SERIES
            ArrayList genresSerieBrut = (ArrayList) serieInfo.get("genre_ids");

            // PARCOURS DE TOUS LES IDS DES GENRES DE LA SERIE
            for (Object o : genresSerieBrut) {

                // RECHERCHE DE QUEL GENRE IL S'AGIT PARMIS CEUX DEJA RECUPERE
                for (Genre g : genres) {
                    if (g.getId() == (int) o) {
                        genresSeries.add(g);
                    }
                }
            }
            Serie serie = createSerie(serieInfo, genresSeries, null, 0, 0);
            Media media = (Media) serie;
            // CREATION ET AJOUT D'UNE SERIE A L'ARRAY DE RETOUR
            medias.add(media);
        }
        return medias;
    }

    private Serie createSerie(Map body, Iterable<Genre> genres, Iterable<Saison> saisons, int numberEpisodes, int numberSaisons) {
        String title = (String) body.get("name");
        int id = (int) body.get("id");
        String backdrop_path = (String) body.get("backdrop_path");
        String poster_path = (String) body.get("poster_path");
        String desc = (String) body.get("overview");
        return new Serie(saisons, numberEpisodes, numberSaisons, id, title, backdrop_path, poster_path, desc, genres);
    }
}
