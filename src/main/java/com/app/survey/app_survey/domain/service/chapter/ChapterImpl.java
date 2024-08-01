package com.app.survey.app_survey.domain.service.chapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.survey.app_survey.domain.repository.ChapterRepository;
import com.app.survey.app_survey.persistence.entity.Chapter;

import jakarta.transaction.Transactional;

@Service
public class ChapterImpl implements ChapterService {

    @Autowired
    private ChapterRepository repository;

   

    @Transactional
    @Override
    public List<Chapter> findAll() {
        return (List<Chapter>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<Chapter> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Chapter save(Chapter chapter) {
        return repository.save(chapter);
    }

    @Transactional
    @Override
    public Optional<Chapter> update(Long id, Chapter chapter) {
        Optional<Chapter> chapterOpt = repository.findById(id);

        if (chapterOpt.isPresent()) {
            Chapter existingChapter = chapterOpt.orElseThrow();
            existingChapter.setSurvey(chapter.getSurvey());
            existingChapter.setChapterNumber(chapter.getChapterNumber());
            existingChapter.setChapterTitle(chapter.getChapterTitle());
            return Optional.of(repository.save(existingChapter));
        }

        return chapterOpt;
    }

    @Transactional
    @Override
    public Optional<Chapter> delete(Long id) {
        Optional<Chapter> chapterOpt = repository.findById(id);
        chapterOpt.ifPresent(chapterItem ->{
            repository.delete(chapterItem);
        });
        return chapterOpt;
    }
}
