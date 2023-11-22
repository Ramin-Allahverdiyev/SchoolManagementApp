package com.school.management.SchoolManagementApp.service.impl;


import com.school.management.SchoolManagementApp.entity.Lesson;
import com.school.management.SchoolManagementApp.exception.NotFoundException;
import com.school.management.SchoolManagementApp.mapper.LessonMapper;
import com.school.management.SchoolManagementApp.model.LessonRequest;
import com.school.management.SchoolManagementApp.model.LessonResponse;
import com.school.management.SchoolManagementApp.repository.LessonRepository;
import com.school.management.SchoolManagementApp.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private static final Logger logger= LoggerFactory.getLogger(LessonServiceImpl.class);

    private final LessonRepository lessonRepository;
    @Override
    public LessonResponse saveLesson(LessonRequest request) {
        logger.info("ActionLog.saveLesson.start request: {}",request);
        var lesson = LessonMapper.INSTANCE.modelToEntity(request);
        var savedLesson = lessonRepository.save(lesson);
        var savedLessonDto = LessonMapper.INSTANCE.entityToModel(savedLesson);
        logger.info("ActionLog.saveLesson.stop response: {}",savedLessonDto);
        return savedLessonDto;
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        logger.info("ActionLog.getAllLessons.start");

        var lessons = lessonRepository.findAll();
        var responses =LessonMapper.INSTANCE.entityListToModelList(lessons);

        logger.info("ActionLog.getAllLessons.end lesson count : {}",responses.size());
        return responses;
    }

    @Override
    public LessonResponse getLesson(Integer id) {
        logger.info("ActionLog.getLesson.start id:{}",id);

        var lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson is not found for id "+id));
        var response=LessonMapper.INSTANCE.entityToModel(lesson);

        logger.info("ActionLog.getLesson.end id:{}",id);
        return response;

    }

    @Override
    public LessonResponse updateLesson(int id, LessonRequest request) {
        logger.info("ActionLog.updateLesson.start id: {}",id);
        var lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson is not found for id: " + id));
        LessonMapper.INSTANCE.modelToEntity(lesson,request);
        var updatedLesson = lessonRepository.save(lesson);
        var response=LessonMapper.INSTANCE.entityToModel(updatedLesson);
        logger.info("ActionLog.updateLesson.end id: {}",id);
        return response;
    }

    @Override
    public void deleteLesson(int id) {
        logger.info("ActionLog.deleteLesson.start");
        var lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson not found!"));
        lessonRepository.delete(lesson);
        logger.info("ActionLog.deleteLesson.end student deleted");
    }
}
