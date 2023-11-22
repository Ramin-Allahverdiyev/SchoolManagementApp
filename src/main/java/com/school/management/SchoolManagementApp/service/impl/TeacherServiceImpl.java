package com.school.management.SchoolManagementApp.service.impl;

import com.school.management.SchoolManagementApp.entity.Teacher;
import com.school.management.SchoolManagementApp.exception.NotFoundException;
import com.school.management.SchoolManagementApp.mapper.LessonMapper;
import com.school.management.SchoolManagementApp.mapper.TeacherMapper;
import com.school.management.SchoolManagementApp.model.TeacherRequest;
import com.school.management.SchoolManagementApp.model.TeacherResponse;
import com.school.management.SchoolManagementApp.repository.TeacherRepository;
import com.school.management.SchoolManagementApp.service.LessonService;
import com.school.management.SchoolManagementApp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger= LoggerFactory.getLogger(TeacherServiceImpl.class);

    private final TeacherRepository teacherRepository;
    private final LessonService lessonService;
    @Override
    public TeacherResponse saveTeacher(TeacherRequest request) {
        logger.info("ActionLog.saveTeacher.start request: {}",request);
        var teacher = TeacherMapper.INSTANCE.modelToEntity(request);
        var savedTeacher = teacherRepository.save(teacher);
        var response = TeacherMapper.INSTANCE.entityToModel(savedTeacher);
        logger.info("ActionLog.saveTeacher.end response: {}",response);
        return response;
    }

    @Override
    public TeacherResponse getTeacher(int id) {
        logger.info("ActionLog.saveTeacher.start getTeacher: {}",id);

        var optionalTeacher = teacherRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Teacher is not found for id "+id));

        var response= TeacherMapper.INSTANCE.entityToModel(optionalTeacher);
        logger.info("ActionLog.saveTeacher.end getTeacher: {}",id);
        return response;
    }

    @Override
    public List<TeacherResponse> getAllTeacher() {
        logger.info("ActionLog.getAllTeacher.start");

        var teachers = teacherRepository.findAll();
        var responses = TeacherMapper.INSTANCE.entityListToModelList(teachers);

        logger.info("ActionLog.getAllTeacher.end teacherDtoList size: {}",responses.size());
        return responses;
    }

    @Override
    public TeacherResponse updateTeacher(int id,TeacherRequest request) {
        logger.info("ActionLog.updateTeacher.start id: {}",id);
        var teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Teacher is not exist for id " + id));
        TeacherMapper.INSTANCE.modelToEntity(teacher, request);
        var updatedTeacher = teacherRepository.save(teacher);
        var response=TeacherMapper.INSTANCE.entityToModel(updatedTeacher);
        logger.info("ActionLog.updateTeacher.end id: {}",id);
        return response;
    }

    @Override
    public void deleteTeacher(int id) {
        logger.info("ActionLog.deleteTeacher.start");
        var teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lesson not found!"));
        teacherRepository.delete(teacher);
        logger.info("ActionLog.deleteTeacher.end teacher deleted");
    }
}
