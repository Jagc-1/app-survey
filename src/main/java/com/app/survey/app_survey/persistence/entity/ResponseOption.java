package com.app.survey.app_survey.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "response_options")
public class ResponseOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El valor de la opción no puede estar vacío.")
    @Size(max = 100, message = "El valor de la opción debe tener un máximo de 100 caracteres.")
    private String optionValue;

    @Size(max = 255, message = "El comentario de respuesta debe tener un máximo de 255 caracteres.")
    private String commentResponse;

    @Size(max = 255, message = "El texto de la opción debe tener un máximo de 255 caracteres.")
    private String optionText;

    private Integer questionParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false) // Nombre de la columna en la tabla de la base de datos
    @NotNull(message = "La pregunta asociada no puede ser nula.")
    private Question question;

    // Constructor sin argumentos
    public ResponseOption() {
    }

    // Constructor con argumentos
    public ResponseOption(String optionValue, String commentResponse, String optionText, Integer questionParent, Question question) {
        this.optionValue = optionValue;
        this.commentResponse = commentResponse;
        this.optionText = optionText;
        this.questionParent = questionParent;
        this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", optionValue=" + optionValue + ", commentResponse=" + commentResponse +
               ", optionText=" + optionText + ", questionParent=" + questionParent + ", question=" + question + "}";
    }
}
