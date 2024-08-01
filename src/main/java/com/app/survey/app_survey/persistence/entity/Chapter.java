package com.app.survey.app_survey.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número del capítulo no puede estar vacío.")
    private String chapterNumber;

    @NotBlank(message = "El título del capítulo no puede estar vacío.")
    private String chapterTitle;

    @ManyToOne(fetch = FetchType.LAZY)  // Usualmente FetchType.LAZY para relaciones ManyToOne
    @JoinColumn(name = "survey_id", nullable = false)
    @NotNull(message = "El encuestado no puede ser nulo.")
    private Survey survey;

    // Constructor sin argumentos
    public Chapter() {
    }

    // Constructor con argumentos
    public Chapter(String chapterNumber, String chapterTitle, Survey survey) {
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
        this.survey = survey;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", chapterNumber=" + chapterNumber + ", chapterTitle=" + chapterTitle + ", survey=" + survey + "}";
    }
}
