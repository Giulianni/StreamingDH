package com.dh.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class ChapterWS {

    private String id;
    private String name;
    private Integer number;
    private String urlStream;

}
