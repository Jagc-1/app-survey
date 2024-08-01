package com.app.survey.app_survey.persistence.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime responseTime;

    @NotNull(message = "La fecha de la respuesta no puede ser nula.")
    private LocalDateTime responseDate;

    @NotBlank(message = "La descripción no puede estar vacía.")
    @Size(max = 255, message = "La descripción debe tener un máximo de 255 caracteres.")
    private String description;

    @NotBlank(message = "El nombre del encuestado no puede estar vacío.")
    @Size(max = 255, message = "El nombre del encuestado debe tener un máximo de 255 caracteres.")
    private String nameRespondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")  // Asegúrate de que esta columna esté en la tabla `responses`
    @NotNull(message = "La encuesta asociada no puede ser nula.")
    private Survey survey;

    // Constructor sin argumentos
    public Response() {
    }

    // Constructor con argumentos
    public Response(String description, String nameRespondent, LocalTime responseTime, LocalDateTime responseDate, Survey survey) {
        this.description = description;
        this.nameRespondent = nameRespondent;
        this.responseTime = responseTime;
        this.responseDate = responseDate;
        this.survey = survey;
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

    public LocalTime getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(LocalTime responseTime) {
        this.responseTime = responseTime;
    }

    public LocalDateTime getResponseDate() {
        return responseDate;
    }

    public void setResponseDate(LocalDateTime responseDate) {
        this.responseDate = responseDate;
    }

    public String getNameRespondent() {
        return nameRespondent;
    }

    public void setNameRespondent(String nameRespondent) {
        this.nameRespondent = nameRespondent;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", description=" + description + ", nameRespondent=" + nameRespondent + 
               ", responseTime=" + responseTime + ", responseDate=" + responseDate + ", survey=" + survey + "}";
    }
}
