package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.detailResponse.DetailResponseService;
import com.app.survey.app_survey.persistence.entity.DetailResponse;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/detail-responses")
public class DetailResponseController {

    @Autowired
    private DetailResponseService service;

    @GetMapping
    public List<DetailResponse> listDetailResponses() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailResponse> view(@PathVariable Long id) {
        Optional<DetailResponse> detailResponseOpt = service.findById(id);
        if (detailResponseOpt.isPresent()) {
            return ResponseEntity.ok(detailResponseOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody DetailResponse detailResponse, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(detailResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody DetailResponse detailResponse, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<DetailResponse> detailResponseOpt = service.update(id, detailResponse);
        if (detailResponseOpt.isPresent()) {
            return ResponseEntity.ok(detailResponseOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetailResponse> delete(@PathVariable Long id) {
        Optional<DetailResponse> detailResponseOpt = service.delete(id);
        if (detailResponseOpt.isPresent()) {
            return ResponseEntity.ok(detailResponseOpt.orElseThrow());
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
