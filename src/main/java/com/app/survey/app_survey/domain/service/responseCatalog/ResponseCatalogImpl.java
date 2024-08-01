package com.app.survey.app_survey.domain.service.responseCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.survey.app_survey.domain.repository.ResponseCatalogRepository;
import com.app.survey.app_survey.persistence.entity.ResponseCatalog;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseCatalogImpl implements ResponseCatalogService {

    @Autowired
    private ResponseCatalogRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<ResponseCatalog> findAll() {
        return (List<ResponseCatalog>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ResponseCatalog> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ResponseCatalog save(ResponseCatalog responseCatalog) {
        return repository.save(responseCatalog);
    }

    @Transactional
    @Override
    public Optional<ResponseCatalog> update(Long id, ResponseCatalog responseCatalog) {
        Optional<ResponseCatalog> responseCatalogOpt = repository.findById(id);
        
        if (responseCatalogOpt.isPresent()) {
            ResponseCatalog responseCatalogItem = responseCatalogOpt.orElseThrow();
            responseCatalogItem.setResponseOption(responseCatalog.getResponseOption());
            responseCatalogItem.setResponseText(responseCatalog.getResponseText());
            responseCatalogItem.setCatalog(responseCatalog.getCatalog());
            responseCatalogItem.setQuestion(responseCatalog.getQuestion());
            responseCatalogItem.setResponse(responseCatalog.getResponse());
            return Optional.of(repository.save(responseCatalogItem));
        }
        
        return responseCatalogOpt;
    }

    @Transactional
    @Override
    public Optional<ResponseCatalog> delete(Long id) {
        Optional<ResponseCatalog> responseCatalogOpt = repository.findById(id);
        responseCatalogOpt.ifPresent(responseCatalogItem ->{
            repository.delete(responseCatalogItem);
        });
        return responseCatalogOpt;
    }
}
