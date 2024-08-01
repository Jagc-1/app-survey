package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.survey.SurveyService;
import com.app.survey.app_survey.persistence.entity.Survey;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService service;


    @GetMapping
    public List<Survey> listSurveys() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survey> view(@PathVariable Long id) {
        Optional<Survey> surveyOpt = service.findById(id);
        if (surveyOpt.isPresent()) {
            return ResponseEntity.ok(surveyOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Survey survey, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(survey));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Survey survey, BindingResult result, @PathVariable Long id) {
       if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Survey> catalogOpt = service.update(id, survey);
        if (catalogOpt.isPresent()) {
            return

            ResponseEntity.status(HttpStatus.CREATED).body(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Survey> delete(@PathVariable Long id) {
        Survey survey = new Survey();
        survey.setId(id);
        Optional<Survey> surveyOpt = service.delete(id);
        if (surveyOpt.isPresent()) {
            return ResponseEntity.ok(surveyOpt.orElseThrow());
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
