package com.dh.catalogservice.model.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data @Builder
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "catalog")
public class CatalogWS {
	@Id
	private String id;
	private String genre;
	private List<MovieWS> movies;
	private List<SerieWS> series;

	public CatalogWS(String genre, List<MovieWS> movies, List<SerieWS> series) {
		this.genre = genre;
		this.movies = movies;
		this.series = series;
	}
}
