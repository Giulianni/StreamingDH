package com.dh.serieservice.controller;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.service.SerieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/series")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService serieService;

    @PostMapping("/save")
    public void save(@RequestBody Serie serie){
        serieService.save(serie);
    }

    @GetMapping
    public List<Serie> findAll(){
        return serieService.findAll();
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSeriesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.findByGenre(genre));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        serieService.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Serie serie){
        serieService.save(serie);
    }

}