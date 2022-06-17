package com.dh.serieservice.service;

import com.dh.serieservice.model.Serie;

import java.util.List;
import java.util.Optional;

public interface ISerieService {


    List<Serie> findAll();

    List<Serie> findByGenre(String genre);


}
