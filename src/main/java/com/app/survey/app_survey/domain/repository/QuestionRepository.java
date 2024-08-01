package com.app.survey.app_survey.domain.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.survey.app_survey.persistence.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}