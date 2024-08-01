package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.response.ResponseService;
import com.app.survey.app_survey.persistence.entity.Response;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseService service;

    @GetMapping
    public List<Response> listResponses() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> view(@PathVariable Long id) {
        Optional<Response> responseOpt = service.findById(id);
        if (responseOpt.isPresent()) {
            return ResponseEntity.ok(responseOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Response response, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(response));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Response response ,BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Response> catalogOpt = service.update(id, response);
        if (catalogOpt.isPresent()) {
            return

            ResponseEntity.status(HttpStatus.CREATED).body(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        Response response = new Response();
        response.setId(id);
        Optional<Response> responseOpt = service.delete(id);
        if (responseOpt.isPresent()) {
            return ResponseEntity.ok(responseOpt.orElseThrow());
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
