package com.app.survey.app_survey.domain.service.question;

import com.app.survey.app_survey.persistence.entity.Question;

import java.util.List;
import java.util.Optional;


public interface QuestionService {
    List<Question> findAll();
    Optional<Question> findById(Long id);
    Question save(Question question);
    Optional<Question> update(Long id, Question question);
    Optional<Question> delete(Long id);
   
}