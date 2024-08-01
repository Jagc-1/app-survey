package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.question.QuestionService;
import com.app.survey.app_survey.persistence.entity.Question;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService service;

    // List all questions
    @GetMapping
    public List<Question> listQuestions() {
        return service.findAll();
    }

    // Get a specific question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> view(@PathVariable Long id) {
        Optional<Question> questionOpt = service.findById(id);
        if (questionOpt.isPresent()) {
            return ResponseEntity.ok(questionOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new question
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Question question, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(question));
    }

    // Update an existing question
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Question question, BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Question> questionOpt = service.update(id, question);
        if (questionOpt.isPresent()) {
            return ResponseEntity.ok(questionOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Delete a question
    @DeleteMapping("/{id}")
    public ResponseEntity<Question> delete(@PathVariable Long id) {
        Optional<Question> questionOpt = service.delete(id);
        if (questionOpt.isPresent()) {
            return ResponseEntity.ok(questionOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Handle validation errors
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " +
                    err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
