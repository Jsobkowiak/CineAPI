package com.cine.demo.controllers.tmdb;

import com.cine.demo.services.MovieService;
import com.cine.demo.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping(path="/getPopularSeries/{nbPage}")
    public @ResponseBody ResponseEntity<String> getPopularSeries(@PathVariable int nbPage){
        return this.serieService.getAllSeries(nbPage);
    }

    @GetMapping(path="/searchSeries/{name}/{nbPage}")
    public @ResponseBody ResponseEntity<String> searchSeries(@PathVariable String name, @PathVariable int nbPage){
        return this.serieService.searchSeries(name, nbPage);
    }

}
