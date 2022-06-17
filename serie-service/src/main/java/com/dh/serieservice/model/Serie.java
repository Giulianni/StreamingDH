package com.dh.serieservice.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Document(collection = "Series")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    @Id
    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;

    public Serie(String name, String genre, List<Season> seasons) {
        this.name = name;
        this.genre = genre;
        this.seasons = seasons;
    }
}
