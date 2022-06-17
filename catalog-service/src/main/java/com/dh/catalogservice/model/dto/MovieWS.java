package com.dh.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieWS {

    private String id;
    private String name;
    private String genre;
    private String urlStream;

}
