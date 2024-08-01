package com.app.survey.app_survey.domain.service.responseCatalog;


import com.app.survey.app_survey.persistence.entity.ResponseCatalog;

import java.util.List;
import java.util.Optional;


public interface ResponseCatalogService {

    List<ResponseCatalog> findAll();
    Optional<ResponseCatalog> findById(Long id);
    ResponseCatalog save(ResponseCatalog responseCatalog);
    Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog);
    Optional<ResponseCatalog> delete(Long id);
}