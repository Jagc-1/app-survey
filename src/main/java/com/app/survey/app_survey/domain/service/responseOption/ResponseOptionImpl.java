package com.app.survey.app_survey.domain.service.responseOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.survey.app_survey.domain.repository.ResponseOptionRepository;
import com.app.survey.app_survey.persistence.entity.ResponseOption;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseOptionImpl implements ResponseOptionService {

    @Autowired
    private ResponseOptionRepository repository;

    @Transactional
    @Override
    public List<ResponseOption> findAll() {
        return (List<ResponseOption>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<ResponseOption> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ResponseOption save(ResponseOption responseOption) {
        return repository.save(responseOption);
    }

    @Transactional
    @Override
    public Optional<ResponseOption> update(Long id, ResponseOption responseOption) {
        Optional<ResponseOption> responseOptionOpt = repository.findById(id);
        
        if (responseOptionOpt.isPresent()) {
            ResponseOption responseOptionItem = responseOptionOpt.orElseThrow();
            responseOptionItem.setOptionValue(responseOption.getOptionValue());
            responseOptionItem.setCommentResponse(responseOption.getCommentResponse());
            responseOptionItem.setOptionText(responseOption.getCommentResponse());
            responseOptionItem.setQuestionParent(responseOption.getQuestionParent());
            responseOptionItem.setQuestion(responseOption.getQuestion());
            return Optional.of(repository.save(responseOptionItem));
        }
        return responseOptionOpt;
    }
    
    @Transactional
    @Override
    public Optional<ResponseOption> delete(Long id) {
        Optional<ResponseOption> responseOptionOpt = repository.findById(id);
        responseOptionOpt.ifPresent(responseOptionItem ->{
            repository.delete(responseOptionItem);
        });
        return responseOptionOpt;
    }
}
