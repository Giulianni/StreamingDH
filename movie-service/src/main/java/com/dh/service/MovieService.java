package com.dh.service;

import com.dh.model.Movie;
import java.util.List;

public interface MovieService {

	List<Movie> findAll();
	List<Movie> getListByGenre(String genre);

	Object save(Movie serie);

	//filter by one gender
	List<Movie> findMoviesByGenre(String genre);

}
