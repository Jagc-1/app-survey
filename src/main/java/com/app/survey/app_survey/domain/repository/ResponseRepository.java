package com.app.survey.app_survey.domain.repository;

import com.app.survey.app_survey.persistence.entity.Response;
import org.springframework.data.repository.CrudRepository;


public interface ResponseRepository extends CrudRepository<Response, Long> {

}