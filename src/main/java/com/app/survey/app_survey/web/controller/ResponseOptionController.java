package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.responseOption.ResponseOptionService;
import com.app.survey.app_survey.persistence.entity.ResponseOption;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/response-options")
public class ResponseOptionController {

    @Autowired
    private ResponseOptionService service;

    // List all ResponseOptions
    @GetMapping
    public List<ResponseOption> listResponseOptions() {
        return service.findAll();
    }

    // Get a specific ResponseOption by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseOption> view(@PathVariable Long id) {
        Optional<ResponseOption> responseOptionOpt = service.findById(id);
        if (responseOptionOpt.isPresent()) {
            return ResponseEntity.ok(responseOptionOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new ResponseOption
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ResponseOption responseOption, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(responseOption));
    }

    // Update an existing ResponseOption
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody  ResponseOption responseOption, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<ResponseOption> catalogOpt = service.update(id, responseOption);
        if (catalogOpt.isPresent()) {
            return

            ResponseEntity.status(HttpStatus.CREATED).body(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a ResponseOption
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseOption> delete(@PathVariable Long id) {
        ResponseOption responseOption = new ResponseOption();
        responseOption.setId(id);
        Optional<ResponseOption> responseOptionOpt = service.delete(id);
        if (responseOptionOpt.isPresent()) {
            return ResponseEntity.ok(responseOptionOpt.orElseThrow());
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
