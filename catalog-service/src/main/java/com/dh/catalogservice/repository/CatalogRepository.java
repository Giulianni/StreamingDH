package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.dto.CatalogWS;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatalogRepository extends MongoRepository<CatalogWS, Integer> {
    Optional<CatalogWS> findByGenre(String genre);
}
