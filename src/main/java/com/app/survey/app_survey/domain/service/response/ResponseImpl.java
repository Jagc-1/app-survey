package com.app.survey.app_survey.domain.service.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.survey.app_survey.domain.repository.ResponseRepository;
import com.app.survey.app_survey.persistence.entity.Response;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseImpl implements ResponseService {

    @Autowired
    private ResponseRepository repository;


    @Transactional(readOnly = true)
    @Override
    public List<Response> findAll() {
        return (List<Response>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Response> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Response save(Response response) {
        return repository.save(response);
    }

    @Transactional
    @Override
    public Optional<Response> update(Long id, Response response) {
        Optional<Response> responseOpt = repository.findById(id);

        if (responseOpt.isPresent()) {
            Response existingResponse = responseOpt.orElseThrow();
            existingResponse.setSurvey(response.getSurvey());
            existingResponse.setResponseTime(response.getResponseTime());
            existingResponse.setResponseDate(response.getResponseDate());
            existingResponse.setNameRespondent(response.getNameRespondent());
            existingResponse.setSurvey(response.getSurvey());
            return Optional.of(repository.save(existingResponse));
        }
        return responseOpt;
    }

    @Transactional
    @Override
    public Optional<Response> delete(Long id) {
        Optional<Response> responseOpt = repository.findById(id);
        responseOpt.ifPresent(repositoryItem ->{
            repository.delete(repositoryItem);
        });
        return responseOpt;
    }
}
