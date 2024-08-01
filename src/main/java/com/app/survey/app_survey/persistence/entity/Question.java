package com.app.survey.app_survey.persistence.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")  // La columna en la tabla `questions`
    private Chapter chapter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_question_id")  // La columna en la tabla `questions` (si aplica)
    private Question parentQuestion;

    @NotBlank(message = "El número de la pregunta no puede estar vacío.")
    private String questionNumber;

    @NotBlank(message = "El texto de la pregunta no puede estar vacío.")
    @Size(max = 255, message = "El texto de la pregunta debe tener un máximo de 255 caracteres.")
    private String questionText;

    @NotBlank(message = "El tipo de respuesta no puede estar vacío.")
    private String responseType;

    @Size(max = 255, message = "El comentario de la respuesta debe tener un máximo de 255 caracteres.")
    private String commentResponse;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResponseOption> responseOptions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")  // La columna en la tabla `questions`
    @NotNull(message = "La encuesta asociada no puede ser nula.")
    private Survey survey;

    // Constructor sin argumentos
    public Question() {
    }

    // Constructor con argumentos
    public Question(Chapter chapter, Question parentQuestion, String questionNumber, String questionText, String responseType, String commentResponse, Survey survey) {
        this.chapter = chapter;
        this.parentQuestion = parentQuestion;
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.responseType = responseType;
        this.commentResponse = commentResponse;
        this.survey = survey;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public Question getParentQuestion() {
        return parentQuestion;
    }

    public void setParentQuestion(Question parentQuestion) {
        this.parentQuestion = parentQuestion;
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

    public Set<ResponseOption> getResponseOptions() {
        return responseOptions;
    }

    public void setResponseOptions(Set<ResponseOption> responseOptions) {
        this.responseOptions = responseOptions;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", chapter=" + chapter + ", parentQuestion=" + parentQuestion +
               ", questionNumber=" + questionNumber + ", questionText=" + questionText +
               ", responseType=" + responseType + ", commentResponse=" + commentResponse +
               ", survey=" + survey + "}";
    }
}
