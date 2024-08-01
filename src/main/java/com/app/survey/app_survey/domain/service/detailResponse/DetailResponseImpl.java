package com.app.survey.app_survey.domain.service.detailResponse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.survey.app_survey.domain.repository.DetailResponseRepository;
import com.app.survey.app_survey.persistence.entity.DetailResponse;

import jakarta.transaction.Transactional;

@Service
public class DetailResponseImpl implements DetailResponseService {
    @Autowired
    private DetailResponseRepository repository;

    

    @Transactional
    @Override
    public List<DetailResponse> findAll() {
        return (List<DetailResponse>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<DetailResponse> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public DetailResponse save(DetailResponse detailResponse) {
        return repository.save(detailResponse);
    }

    @Transactional
    @Override
    public Optional<DetailResponse> update(Long id, DetailResponse detailResponse) {
        Optional<DetailResponse> detailResponseOpt = repository.findById(id);
        if (detailResponseOpt.isPresent()) {
            DetailResponse existingDetailResponse = detailResponseOpt.orElseThrow();
            existingDetailResponse.setResponseOption(detailResponse.getResponseOption());
            existingDetailResponse.setResponseText(detailResponse.getResponseText());
            existingDetailResponse.setResponse(detailResponse.getResponse());
            existingDetailResponse.setQuestion(detailResponse.getQuestion());
            return Optional.of(repository.save(existingDetailResponse));
        }
        return detailResponseOpt;
    }

    @Transactional
    @Override
    public Optional<DetailResponse> delete(Long id) {
        Optional<DetailResponse> detailResponseOpt = repository.findById(id);
        detailResponseOpt.ifPresent(detailResponseItem ->{
            repository.delete(detailResponseItem);
        });
        return detailResponseOpt;
    }
}
