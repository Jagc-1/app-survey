package com.app.survey.app_survey.domain.service.survey;

import com.app.survey.app_survey.persistence.entity.Survey;
import java.util.List;
import java.util.Optional;


public interface SurveyService {

    List<Survey> findAll();
    Optional<Survey> findById(Long id);
    Survey save(Survey survey);
    Optional<Survey> update(Long id, Survey survey);
    Optional<Survey> delete(Long id);
}