package com.dh.serieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document(collection = "Capitulos")
@Data
@NoArgsConstructor
public class Chapter {

    @Id
    private String id;
    private String name;
    private Integer number;
    private String urlStream;

    public Chapter(String name, Integer number, String urlStream) {
        this.name = name;
        this.number = number;
        this.urlStream = urlStream;
    }
}