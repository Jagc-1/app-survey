package com.app.survey.app_survey.domain.dto;

public class DetailResponseDTO {

    private Long id;
    private Long responseOptionId;
    private Long questionId;
    private Long responseId;
    private String responseText;
    private String nameRespondent;

    // Constructor sin argumentos
    public DetailResponseDTO() {
    }

    // Constructor con argumentos
    public DetailResponseDTO(Long id, Long responseOptionId, Long questionId, Long responseId, String responseText, String nameRespondent) {
        this.id = id;
        this.responseOptionId = responseOptionId;
        this.questionId = questionId;
        this.responseId = responseId;
        this.responseText = responseText;
        this.nameRespondent = nameRespondent;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResponseOptionId() {
        return responseOptionId;
    }

    public void setResponseOptionId(Long responseOptionId) {
        this.responseOptionId = responseOptionId;
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

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getNameRespondent() {
        return nameRespondent;
    }

    public void setNameRespondent(String nameRespondent) {
        this.nameRespondent = nameRespondent;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", responseOptionId=" + responseOptionId + ", questionId=" + questionId +
               ", responseId=" + responseId + ", responseText=" + responseText + ", nameRespondent=" + nameRespondent + "}";
    }
}
