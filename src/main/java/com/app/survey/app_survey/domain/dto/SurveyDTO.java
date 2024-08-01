package com.app.survey.app_survey.domain.dto;


public class SurveyDTO {

    private Long id;
    private String description;

    // Constructor sin argumentos
    public SurveyDTO() {
    }

    // Constructor con argumentos
    public SurveyDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", description=" + description + "}";
    }
}