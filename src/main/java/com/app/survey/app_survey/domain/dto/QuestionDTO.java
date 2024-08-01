package com.app.survey.app_survey.domain.dto;

public class QuestionDTO {

    private Long id;
    private Long chapterId;
    private Long parentQuestionId;
    private Long surveyId;
    private String questionNumber;
    private String questionText;
    private String responseType;
    private String commentResponse;

    // Constructor sin argumentos
    public QuestionDTO() {
    }

    // Constructor con argumentos
    public QuestionDTO(Long id, Long chapterId, Long parentQuestionId, Long surveyId, String questionNumber, String questionText, String responseType, String commentResponse) {
        this.id = id;
        this.chapterId = chapterId;
        this.parentQuestionId = parentQuestionId;
        this.surveyId = surveyId;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.responseType = responseType;
        this.commentResponse = commentResponse;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChapterId() {
        return chapterId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public Long getParentQuestionId() {
        return parentQuestionId;
    }

    public void setParentQuestionId(Long parentQuestionId) {
        this.parentQuestionId = parentQuestionId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(String commentResponse) {
        this.commentResponse = commentResponse;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", chapterId=" + chapterId + ", parentQuestionId=" + parentQuestionId +
               ", surveyId=" + surveyId + ", questionNumber=" + questionNumber + ", questionText=" + questionText +
               ", responseType=" + responseType + ", commentResponse=" + commentResponse + "}";
    }
}