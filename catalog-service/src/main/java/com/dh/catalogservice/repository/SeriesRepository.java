package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.dto.SerieWS;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "serie-service")
public interface SeriesRepository {

    @GetMapping("/series/{genre}")
    List<SerieWS> getSeriesByGenre(@PathVariable String genre);

}
