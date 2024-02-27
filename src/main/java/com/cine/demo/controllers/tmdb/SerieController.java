package com.cine.demo.controllers.tmdb;

import com.cine.demo.entities.tmdb.Serie;
import com.cine.demo.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/tmdb")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping(value= {"/getPopularSeries", "/getPopularSeries/{nbPage}"})
    public @ResponseBody ResponseEntity<Iterable<Serie>> getPopularSeries(@PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return ResponseEntity.ok(this.serieService.getAllSeries(nbPage));
    }

    @GetMapping(value= {"/searchSeries/{name}","/searchSeries/{name}/{nbPage}"})
    public @ResponseBody ResponseEntity<Iterable<Serie>> searchSeries(@PathVariable String name, @PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return ResponseEntity.ok(this.serieService.searchSeries(name, nbPage));
    }

    @GetMapping(path="/getSerieById/{idSerie}")
    public @ResponseBody ResponseEntity<Serie> getSerieById(@PathVariable int idSerie){
        return ResponseEntity.ok(this.serieService.getSerieDetail(idSerie));
    }


}
