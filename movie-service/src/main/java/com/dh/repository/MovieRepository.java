package com.dh.repository;

import com.dh.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

	List<Movie> findAllByGenre(String genre);
	List<Movie> findByGenre(String genre);


}
