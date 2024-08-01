package com.app.survey.app_survey.domain.repository;

import org.springframework.data.repository.CrudRepository;
import com.app.survey.app_survey.persistence.entity.Chapter;

public interface ChapterRepository extends CrudRepository<Chapter, Long>  {

}
