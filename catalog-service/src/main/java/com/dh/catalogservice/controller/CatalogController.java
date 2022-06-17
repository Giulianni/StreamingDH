package com.dh.catalogservice.controller;

import com.ctc.wstx.util.StringUtil;
import com.dh.catalogservice.model.dto.CatalogWS;
import com.dh.catalogservice.model.dto.MovieWS;
import com.dh.catalogservice.service.CatalogService;
import com.dh.catalogservice.service.impl.CatalogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class CatalogController {

	private static final Logger logger = LoggerFactory.getLogger(CatalogController.class);
	private CatalogServiceImpl catalogService;

	@Autowired
	public CatalogController(CatalogServiceImpl catalogService) {
		this.catalogService = catalogService;
	}

	@GetMapping("/{genre}")
	ResponseEntity<CatalogWS> getByGenre(@PathVariable String genre) {
		return ResponseEntity.ok().body(catalogService.getCatalogByGenre(genre));
	}

//	@PostMapping("/create")
//	public ResponseEntity<CatalogWS> createCatalog(@RequestBody CatalogWS catalog) {
//		return ResponseEntity.ok().body(catalogService.buildCatalogByGenre(StringUtils.isBlank(catalog.getGenre()) ? "dummyGenre" : catalog.getGenre()));
//	}

}
