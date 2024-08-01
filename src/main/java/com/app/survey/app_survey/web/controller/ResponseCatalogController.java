package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.responseCatalog.ResponseCatalogService;
import com.app.survey.app_survey.persistence.entity.ResponseCatalog;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/response-catalogs")
public class ResponseCatalogController {

    @Autowired
    private ResponseCatalogService service;


    @GetMapping
    public List<ResponseCatalog> listResponseCatalogs() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCatalog> view(@PathVariable Long id) {
        Optional<ResponseCatalog> responseCatalogOpt = service.findById(id);
        if (responseCatalogOpt.isPresent()) {
            return ResponseEntity.ok(responseCatalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

 @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ResponseCatalog responseCatalog, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(responseCatalog));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody ResponseCatalog responseCatalog,BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<ResponseCatalog> responseCatalogOpt = service.update(id, responseCatalog);
        if (responseCatalogOpt.isPresent()) {
            return

            ResponseEntity.status(HttpStatus.CREATED).body(responseCatalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCatalog> delete(@PathVariable Long id) {
        ResponseCatalog responseCatalog = new ResponseCatalog();
        responseCatalog.setId(id);
        Optional<ResponseCatalog> responseCatalogOpt = service.delete(id);
        if (responseCatalogOpt.isPresent()) {
            return ResponseEntity.ok(responseCatalogOpt.orElseThrow());
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
