package com.dh.service;

import com.dh.model.Movie;
import com.dh.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepository;

	@Autowired
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}


	@Override
	public Movie save(Movie movie){
		movieRepository.save(movie);
        return null;
    }


	@Override
	public List<Movie> getListByGenre(String genre) {
		return movieRepository.findAllByGenre(genre);
	}


	@Override
	public List<Movie> findMoviesByGenre(String genre){
		return movieRepository.findByGenre(genre);
	}

}
