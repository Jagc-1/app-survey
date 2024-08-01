package com.app.survey.app_survey.domain.service.survey;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.survey.app_survey.domain.repository.SurveyRepository;
import com.app.survey.app_survey.persistence.entity.Survey;

import jakarta.transaction.Transactional;

@Service
public class SurveyImpl implements SurveyService {

    @Autowired
    private SurveyRepository repository;

    @Transactional
    @Override
    public List<Survey> findAll() {
        return (List<Survey>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Survey> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Survey save(Survey survey) {
        return repository.save(survey);
    }

    @Transactional
    @Override
    public Optional<Survey> update(Long id, Survey survey) {
        Optional<Survey> surveyOpt = repository.findById(id);
       if(surveyOpt.isPresent()){
            Survey surveyItem = surveyOpt.orElseThrow();
            surveyItem.setSurveyName(survey.getSurveyName());
            surveyItem.setChapters(survey.getChapters());
            return Optional.of(repository.save(surveyItem));
       }
       return surveyOpt;
    }

    @Transactional
    @Override
    public Optional<Survey> delete(Long id) {
        Optional<Survey> surveyOpt = repository.findById(id);

        surveyOpt.ifPresent(surveyItem ->{
            repository.delete(surveyItem);
        });
        return surveyOpt;
    }
}