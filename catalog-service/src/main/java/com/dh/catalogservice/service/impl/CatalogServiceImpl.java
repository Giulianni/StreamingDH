package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.controller.CatalogController;
import com.dh.catalogservice.model.dto.CatalogWS;
import com.dh.catalogservice.model.dto.MovieWS;
import com.dh.catalogservice.model.dto.SerieWS;
import com.dh.catalogservice.repository.CatalogRepository;
import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.repository.SeriesRepository;
import com.dh.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CatalogServiceImpl implements CatalogService {

	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	private CatalogRepository catalogRepository;
	private MovieRepository movieRepository;
	private SeriesRepository seriesRepository;


	@Autowired
	public CatalogServiceImpl(MovieRepository movieRepository, SeriesRepository seriesRepository, CatalogRepository catalogRepository) {
		this.movieRepository = movieRepository;
		this.seriesRepository = seriesRepository;
		this.catalogRepository = catalogRepository;
	}


	@CircuitBreaker(name = "movies", fallbackMethod = "moviesListIsEmptyFallback")
	@Retry(name = "movies")
	public List<MovieWS> getMoviesByGenre(String genre) {
		return movieRepository.getMoviesByGenre(genre);
	}

	@CircuitBreaker(name = "series", fallbackMethod = "seriesListIsEmptyFallback")
	@Retry(name = "series")
	public List<SerieWS>getSeriesByGenre(String genre){
		return seriesRepository.getSeriesByGenre(genre);
	}

	@Override
	public CatalogWS buildCatalogByGenre(String genre) {
		CatalogWS catalog = catalogRepository.findByGenre(genre).orElse(CatalogWS.builder().genre(genre).build());
		List<MovieWS> moviesByGenre = getMoviesByGenre(genre);
		List<SerieWS> seriesByGenre = getSeriesByGenre(genre);
		catalog.setMovies(moviesByGenre);
		catalog.setSeries(seriesByGenre);

		return catalogRepository.save(catalog);
	}

	public CatalogWS getCatalogByGenre(String genre) {
		return catalogRepository.findByGenre(genre).orElseThrow();
	}

	private List<MovieWS> moviesListIsEmptyFallback(CallNotPermittedException ex) {
		log.debug("movies CB is working...");
		return new ArrayList<>();
	}

	private List<MovieWS> seriesListIsEmptyFallback(CallNotPermittedException ex) {
		log.debug("series CB is working...");
		return new ArrayList<>();
	}

}
