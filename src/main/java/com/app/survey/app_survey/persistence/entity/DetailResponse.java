package com.app.survey.app_survey.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "detail_responses")
public class DetailResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La opción de respuesta no puede ser nula.")
    @Min(value = 1, message = "La opción de respuesta debe ser mayor o igual a 1.")
    private Integer responseOption;

    @Size(min = 1, max = 255, message = "El texto de la respuesta no puede estar vacío y debe tener un máximo de 255 caracteres.")
    private String responseText;

    @ManyToOne(fetch = FetchType.LAZY)  // Usualmente FetchType.LAZY para relaciones ManyToOne
    @JoinColumn(name = "response_id", nullable = false)
    @NotNull(message = "La respuesta asociada no puede ser nula.")
    private Response response;

    @ManyToOne(fetch = FetchType.LAZY)  // Usualmente FetchType.LAZY para relaciones ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    @NotNull(message = "La pregunta asociada no puede ser nula.")
    private Question question;

    // Constructor sin argumentos
    public DetailResponse() {
    }

    // Constructor con argumentos
    public DetailResponse(Integer responseOption, String responseText, Response response, Question question) {
        this.responseOption = responseOption;
        this.responseText = responseText;
        this.response = response;
        this.question = question;
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

    @Override
    public String toString() {
        return "{id=" + id + ", responseOption=" + responseOption + ", responseText=" + responseText + ", response=" + response + ", question=" + question + "}";
    }
}
