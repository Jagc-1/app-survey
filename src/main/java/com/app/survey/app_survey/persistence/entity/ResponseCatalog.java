package com.app.survey.app_survey.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "response_catalogs")
public class ResponseCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La opción de respuesta no puede ser nula.")
    private Integer responseOption;

    @NotBlank(message = "El texto de respuesta no puede estar vacío.")
    @Size(max = 255, message = "El texto de respuesta debe tener un máximo de 255 caracteres.")
    private String responseText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "response_id", nullable = false)
    @NotNull(message = "La respuesta asociada no puede ser nula.")
    private Response response;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @NotNull(message = "La pregunta asociada no puede ser nula.")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalog_id", nullable = false)
    @NotNull(message = "El catálogo asociado no puede ser nulo.")
    private Catalog catalog; // Debe coincidir con el 'mappedBy' en Catalog

    // Constructor sin argumentos
    public ResponseCatalog() {
    }

    // Constructor con argumentos
    public ResponseCatalog(Integer responseOption, String responseText, Response response, Question question, Catalog catalog) {
        this.responseOption = responseOption;
        this.responseText = responseText;
        this.response = response;
        this.question = question;
        this.catalog = catalog;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getResponseOption() {
        return responseOption;
    }

    public void setResponseOption(Integer responseOption) {
        this.responseOption = responseOption;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", responseOption=" + responseOption + ", responseText=" + responseText +
               ", response=" + response + ", question=" + question + ", catalog=" + catalog + "}";
    }
}
