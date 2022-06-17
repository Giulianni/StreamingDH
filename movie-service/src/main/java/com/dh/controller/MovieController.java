package com.dh.controller;

import com.dh.model.Movie;
import com.dh.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{genre}")
	public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(movieService.getListByGenre(genre));
	}


}
