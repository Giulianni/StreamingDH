package com.dh.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SerieWS {

    private String id;
    private String name;
    private String genre;
    private List<SeasonWS> seasons;

}
