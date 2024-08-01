package com.app.survey.app_survey.domain.dto;

public class ResponseCatalogDTO {

    private Long id;
    private Long catalogId;
    private Long questionId;
    private Long responseId;

    // Constructor sin argumentos
    public ResponseCatalogDTO() {
    }

    // Constructor con argumentos
    public ResponseCatalogDTO(Long id, Long catalogId, Long questionId, Long responseId) {
        this.id = id;
        this.catalogId = catalogId;
        this.questionId = questionId;
        this.responseId = responseId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", catalogId=" + catalogId + ", questionId=" + questionId + ", responseId=" + responseId + "}";
    }
}