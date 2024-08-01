package com.app.survey.app_survey.domain.service.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.survey.app_survey.domain.repository.QuestionRepository;
import com.app.survey.app_survey.persistence.entity.Question;


import java.util.List;
import java.util.Optional;

@Service
public class QuestionImpl implements QuestionService {

    @Autowired
    private QuestionRepository repository;


    @Transactional
    @Override
    public List<Question> findAll() {
        return (List<Question>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Question> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Question save(Question question) {
        return repository.save(question);
    }

    @Transactional
    @Override
    public Optional<Question> update(Long id, Question question) {
        Optional<Question> questionOpt = repository.findById(id);

        if (questionOpt.isPresent()) {
            Question existingQuestion = questionOpt.orElseThrow();
            existingQuestion.setChapter(question.getChapter());
            existingQuestion.setParentQuestion(question.getParentQuestion());
            existingQuestion.setResponseOptions(question.getResponseOptions());
            existingQuestion.setSurvey(question.getSurvey());
            existingQuestion.setQuestionNumber(question.getQuestionNumber());
            existingQuestion.setQuestionText(question.getQuestionText());
            existingQuestion.setResponseType(question.getResponseType());
            existingQuestion.setCommentResponse(question.getCommentResponse());
            

            return Optional.of(repository.save(existingQuestion));
        }
        return questionOpt;
    }

    @Transactional
    @Override
    public Optional<Question> delete(Long id) {
        Optional<Question> questionOpt = repository.findById(id);
        questionOpt.ifPresent(questionItem ->{
            repository.delete(questionItem);
        });
        return questionOpt;
    }
}
