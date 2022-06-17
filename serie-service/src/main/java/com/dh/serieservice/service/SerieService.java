package com.dh.serieservice.service;

import com.dh.serieservice.model.Serie;
import com.dh.serieservice.repository.ISerieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SerieService implements ISerieService{

    private final ISerieRepository serieRepository;


    public Serie save(Serie serie){
        return serieRepository.save(serie);
    }


    @Override
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }


    public Optional<Serie> finByName(String name){
        return serieRepository.findByName(name);
    }


    public void deleteById(String id){
        serieRepository.deleteById(id);
    }


    @Override
    public List<Serie> findByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

}
