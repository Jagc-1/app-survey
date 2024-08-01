package com.app.survey.app_survey.domain.dto;

public class CatalogDTO {

    private Long id;
    private String name;

    // Constructor sin argumentos
    public CatalogDTO() {
    }

    // Constructor con argumentos
    public CatalogDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", name=" + name + "}";
    }
}