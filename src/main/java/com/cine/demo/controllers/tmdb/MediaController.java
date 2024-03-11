package com.cine.demo.controllers.tmdb;

import com.cine.demo.entities.tmdb.Media;
import com.cine.demo.services.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping(path = "/tmdb")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping(value= {"/searchMedia/{name}", "/searchMedia/{name}/{nbPage}"})
    public @ResponseBody ResponseEntity<Iterable<Media>> searchMedia(@PathVariable String name, @PathVariable(required = false) String nbPage){
        if(nbPage == null){
            nbPage = "1";
        }
        return ResponseEntity.ok(this.mediaService.searchMedias(name, nbPage));
    }
}
