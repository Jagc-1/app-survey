package com.app.survey.app_survey.domain.service.detailResponse;

import com.app.survey.app_survey.persistence.entity.DetailResponse;
import java.util.List;
import java.util.Optional;



public interface DetailResponseService {

     List<DetailResponse> findAll();
    Optional<DetailResponse> findById(Long id);
    DetailResponse save(DetailResponse detailResponse);
    Optional<DetailResponse> update(Long id, DetailResponse detailResponse);
    Optional<DetailResponse> delete(Long id);
}