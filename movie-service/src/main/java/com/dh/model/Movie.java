package com.dh.model;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "movies")
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String name;
	private String genre;
	private String urlStream;

}
