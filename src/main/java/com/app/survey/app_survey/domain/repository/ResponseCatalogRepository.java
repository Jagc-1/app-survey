package com.app.survey.app_survey.domain.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.survey.app_survey.persistence.entity.ResponseCatalog;


public interface ResponseCatalogRepository extends CrudRepository<ResponseCatalog, Long> {

}