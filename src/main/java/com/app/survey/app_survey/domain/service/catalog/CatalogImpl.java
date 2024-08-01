package com.app.survey.app_survey.domain.service.catalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.survey.app_survey.domain.repository.CatalogRepository;
import com.app.survey.app_survey.persistence.entity.Catalog;

import jakarta.transaction.Transactional;

@Service
public class CatalogImpl implements CatalogService {

    @Autowired
    private CatalogRepository repository;

    @Transactional
    @Override
    public List<Catalog> findAll() {
        return(List<Catalog>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Catalog> findById(Long id) {
       return repository.findById(id);
    }

    @Transactional
    @Override
    public Catalog save(Catalog catalog) {
        return repository.save(catalog);
    }

    @Transactional
    @Override
    public Optional<Catalog> update(Long id, Catalog catalog) {
       Optional<Catalog> catalogOpt = repository.findById(id);
       if(catalogOpt.isPresent()){
            Catalog catalogItem = catalogOpt.orElseThrow();
            catalogItem.setResponseCatalogs(catalog.getResponseCatalogs());
            return Optional.of(repository.save(catalogItem));
       }
       return catalogOpt;
    }

    @Transactional
    @Override
    public Optional<Catalog> delete(Long id) {
        Optional<Catalog> catalogOpt = repository.findById(id);
        catalogOpt.ifPresent(catalogItem ->{
            repository.delete(catalogItem);
        });
        return catalogOpt;
    }

}
