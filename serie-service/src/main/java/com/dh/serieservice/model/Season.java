package com.dh.serieservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;

@Document(collection = "Seasons")
@Data
@NoArgsConstructor
public class Season {

    @Id
    private String id;
    private Integer seasonNumber;
    private ArrayList<Chapter> chapters;

    public Season(Integer seasonNumber, ArrayList<Chapter> urlStream) {
        this.seasonNumber = seasonNumber;
        this.chapters = urlStream;
    }
}
