package com.app.survey.app_survey.domain.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ResponseDTO {

    private Long id;
    private LocalTime responseTime;
    private LocalDateTime responseDate;
    private String description;
    private String nameRespondent;
    private Long surveyId;
    private Long questionId;
    private Long responseOptionId;

    // Constructor sin argumentos
    public ResponseDTO() {
    }

    // Constructor con argumentos
    public ResponseDTO(Long id, LocalTime responseTime, LocalDateTime responseDate, String description, String nameRespondent, Long surveyId, Long questionId, Long responseOptionId) {
        this.id = id;
        this.responseTime = responseTime;
        this.responseDate = responseDate;
        this.description = description;
        this.nameRespondent = nameRespondent;
        this.surveyId = surveyId;
        this.questionId = questionId;
        this.responseOptionId = responseOptionId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNameRespondent() {
        return nameRespondent;
    }

    public void setNameRespondent(String nameRespondent) {
        this.nameRespondent = nameRespondent;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getResponseOptionId() {
        return responseOptionId;
    }

    public void setResponseOptionId(Long responseOptionId) {
        this.responseOptionId = responseOptionId;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", responseTime=" + responseTime + ", responseDate=" + responseDate +
               ", description=" + description + ", nameRespondent=" + nameRespondent +
               ", surveyId=" + surveyId + ", questionId=" + questionId + ", responseOptionId=" + responseOptionId + "}";
    }
}