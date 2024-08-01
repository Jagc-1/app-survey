package com.app.survey.app_survey.domain.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.survey.app_survey.persistence.entity.Survey;


public interface SurveyRepository extends CrudRepository<Survey, Long> {
    
}