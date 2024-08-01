package com.app.survey.app_survey.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la encuesta no puede estar vacío.")
    @Size(max = 255, message = "El nombre de la encuesta debe tener un máximo de 255 caracteres.")
    private String surveyName;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Chapter> chapters;

    // Constructor sin argumentos
    public Survey() {
    }

    // Constructor con argumentos
    public Survey(String surveyName) {
        this.surveyName = surveyName;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Set<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(Set<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", surveyName=" + surveyName + "}";
    }
}
