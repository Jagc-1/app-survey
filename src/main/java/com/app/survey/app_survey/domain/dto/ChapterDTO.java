package com.app.survey.app_survey.domain.dto;

public class ChapterDTO {

    private Long id;
    private Long surveyId;
    private String chapterNumber;
    private String chapterTitle;

    // Constructor sin argumentos
    public ChapterDTO() {
    }

    // Constructor con argumentos
    public ChapterDTO(Long id, Long surveyId, String chapterNumber, String chapterTitle) {
        this.id = id;
        this.surveyId = surveyId;
        this.chapterNumber = chapterNumber;
        this.chapterTitle = chapterTitle;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Long surveyId) {
        this.surveyId = surveyId;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", surveyId=" + surveyId + ", chapterNumber=" + chapterNumber +
               ", chapterTitle=" + chapterTitle + "}";
    }
}
