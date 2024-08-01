package com.app.survey.app_survey.persistence.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.util.Set;

@Entity
@Table(name = "catalogs")
public class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotEmpty(message = "{NotEmpty.catalog.name}")
    private String name;

    @Embedded
    Audit audit = new Audit();

    @OneToMany(mappedBy = "catalog", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResponseCatalog> responseCatalogs;

    // Constructor sin argumentos
    public Catalog() {
    }

    // Constructor con argumentos
    public Catalog(String name) {
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

    public Set<ResponseCatalog> getResponseCatalogs() {
        return responseCatalogs;
    }

    public void setResponseCatalogs(Set<ResponseCatalog> responseCatalogs) {
        this.responseCatalogs = responseCatalogs;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", name=" + name + "}";
    }
}
