package com.app.survey.app_survey.domain.dto;

public class ResponseOptionDTO {

    private Long id;
    private String optionValue;
    private String commentResponse;
    private String optionText;
    private Integer questionParent;

    // Constructor sin argumentos
    public ResponseOptionDTO() {
    }

    // Constructor con argumentos
    public ResponseOptionDTO(Long id, String optionValue, String commentResponse, String optionText, Integer questionParent) {
        this.id = id;
        this.optionValue = optionValue;
        this.commentResponse = commentResponse;
        this.optionText = optionText;
        this.questionParent = questionParent;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(String commentResponse) {
        this.commentResponse = commentResponse;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Integer getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(Integer questionParent) {
        this.questionParent = questionParent;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", optionValue=" + optionValue + ", commentResponse=" + commentResponse +
               ", optionText=" + optionText + ", questionParent=" + questionParent + "}";
    }
}