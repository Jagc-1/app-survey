package com.app.survey.app_survey.domain.service.catalog;


import com.app.survey.app_survey.persistence.entity.Catalog;
import java.util.List;
import java.util.Optional;


public interface CatalogService {

    List<Catalog> findAll();
    Optional<Catalog> findById(Long id);
    Catalog save(Catalog catalog);
    Optional<Catalog> update(Long id, Catalog catalog);
    Optional<Catalog> delete(Long id);
}