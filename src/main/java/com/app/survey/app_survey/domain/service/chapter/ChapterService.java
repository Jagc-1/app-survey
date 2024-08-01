package com.app.survey.app_survey.domain.service.chapter;

import com.app.survey.app_survey.persistence.entity.Chapter;
import java.util.List;
import java.util.Optional;


public interface ChapterService {

    List<Chapter> findAll();
    Optional<Chapter> findById(Long id);
    Chapter save(Chapter chapter);
    Optional<Chapter> update(Long id, Chapter chapter);
    Optional<Chapter> delete(Long id);
}