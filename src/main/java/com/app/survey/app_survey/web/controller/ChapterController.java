package com.app.survey.app_survey.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.app.survey.app_survey.domain.service.chapter.ChapterService;
import com.app.survey.app_survey.persistence.entity.Chapter;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    @Autowired
    private ChapterService service;

    @GetMapping
    public List<Chapter> listChapters() {
        return service.findAll();
    }

    // Get a specific chapter by ID
    @GetMapping("/{id}")
    public ResponseEntity<Chapter> view(@PathVariable Long id) {
        Optional<Chapter> chapterOpt = service.findById(id);
        if (chapterOpt.isPresent()) {
            return ResponseEntity.ok(chapterOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Create a new chapter
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Chapter chapter, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(chapter));
    }

    // Update an existing chapter
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Chapter chapter ,BindingResult result, @PathVariable Long id) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        Optional<Chapter> catalogOpt = service.update(id, chapter);
        if (catalogOpt.isPresent()) {
            return

            ResponseEntity.status(HttpStatus.CREATED).body(catalogOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Chapter> delete(@PathVariable Long id) {
        Chapter chapter  = new Chapter();
        chapter.setId(id);
        Optional<Chapter> chapterOpt = service.delete(id);
        if (chapterOpt.isPresent()) {
            return ResponseEntity.ok(chapterOpt.orElseThrow());
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

