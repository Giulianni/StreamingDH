package com.dh.catalogservice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonWS {

    private String id;
    private Integer seasonNumber;
    private ArrayList<ChapterWS> urlStream;

}
