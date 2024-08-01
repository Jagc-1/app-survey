package com.app.survey.app_survey.domain.service.responseOption;


import com.app.survey.app_survey.persistence.entity.ResponseOption;
import java.util.List;
import java.util.Optional;


public interface ResponseOptionService {

    List<ResponseOption> findAll();
    Optional<ResponseOption> findById(Long id);
    ResponseOption save(ResponseOption responseOption);
    Optional<ResponseOption> update(Long id, ResponseOption responseOption);
    Optional<ResponseOption> delete(Long id);
}