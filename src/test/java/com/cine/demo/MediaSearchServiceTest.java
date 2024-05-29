package com.cine.demo;

import com.cine.demo.entities.tmdb.Genre;
import com.cine.demo.services.GenreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GenreServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private GenreService genreService;

    @BeforeEach
    public void setUp() {
        // Initialize the service with the mock RestTemplate
        genreService = new GenreService();
        genreService.restTemplate = restTemplate;
    }

    @Test
    public void testGetAllMovieGenres() {
        // Given
        Map<String, Object> genreMap = new HashMap<>();
        genreMap.put("id", 28);
        genreMap.put("name", "Action");

        List<Map<String, Object>> genresList = new ArrayList<>();
        genresList.add(genreMap);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("genres", genresList);

        ResponseEntity<Map> responseEntity = ResponseEntity.ok(responseMap);

        when(restTemplate.exchange(
                eq("https://api.themoviedb.org/3/genre/movie/list?language=en-US"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Map.class)
        )).thenReturn(responseEntity);

        // When
        Iterable<Genre> genres = genreService.getAllMovieGenres();

        // Then
        assertNotNull(genres);
        List<Genre> genresListResult = (List<Genre>) genres;
        assertEquals(1, genresListResult.size());
        assertEquals(28, genresListResult.get(0).getId());
        assertEquals("Action", genresListResult.get(0).getName());
    }

    @Test
    public void testGetAllSerieGenres() {
        // Given
        Map<String, Object> genreMap = new HashMap<>();
        genreMap.put("id", 16);
        genreMap.put("name", "Animation");

        List<Map<String, Object>> genresList = new ArrayList<>();
        genresList.add(genreMap);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("genres", genresList);

        ResponseEntity<Map> responseEntity = ResponseEntity.ok(responseMap);

        when(restTemplate.exchange(
                eq("https://api.themoviedb.org/3/genre/tv/list?language=en-US"),
                eq(HttpMethod.GET),
                any(HttpEntity.class),
                eq(Map.class)
        )).thenReturn(responseEntity);

        // When
        Iterable<Genre> genres = genreService.getAllSerieGenres();

        // Then
        assertNotNull(genres);
        List<Genre> genresListResult = (List<Genre>) genres;
        assertEquals(1, genresListResult.size());
        assertEquals(16, genresListResult.get(0).getId());
        assertEquals("Animation", genresListResult.get(0).getName());
    }
}
