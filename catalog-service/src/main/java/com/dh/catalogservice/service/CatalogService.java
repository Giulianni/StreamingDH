package com.dh.catalogservice.service;

import com.dh.catalogservice.model.dto.CatalogWS;



public interface CatalogService {

    CatalogWS getCatalogByGenre(String genre);
    CatalogWS buildCatalogByGenre(String genre);

}
