package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.catalog.CatalogService;
import com.app.survey.app_survey.persistence.entity.Catalog;

import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogController {

    @Autowired
    private CatalogService service;

    @GetMapping
    public List<Catalog> listCatalog() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> view(@PathVariable Long id) {
        Optional<Catalog> catalogOpt = service.findById(id);
        if (catalogOpt.isPresent()) {
            return ResponseEntity.ok(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Catalog catalog,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(catalog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Catalog catalog, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Catalog> catalogOpt = service.update(id, catalog);
        if (catalogOpt.isPresent()) {
            return

            ResponseEntity.status(HttpStatus.CREATED).body(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Catalog> delete(@PathVariable Long id) {
        Catalog catalog = new Catalog();
        catalog.setId(id);
        Optional<Catalog> catalogOpt = service.delete(id);
        if (catalogOpt.isPresent()) {
            return ResponseEntity.ok(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " +

                    err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
