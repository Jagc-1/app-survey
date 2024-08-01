package com.app.survey.app_survey.domain.service.response;


import com.app.survey.app_survey.persistence.entity.Response;
import java.util.List;
import java.util.Optional;


public interface ResponseService {

    List<Response> findAll();
    Optional<Response> findById(Long id);
    Response save(Response response);
    Optional<Response> update(Long id, Response response);
    Optional<Response> delete(Long id);
}