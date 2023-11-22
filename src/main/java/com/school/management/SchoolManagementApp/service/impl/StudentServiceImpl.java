package com.school.management.SchoolManagementApp.service.impl;

import com.school.management.SchoolManagementApp.entity.Student;
import com.school.management.SchoolManagementApp.exception.NotFoundException;
import com.school.management.SchoolManagementApp.mapper.LessonMapper;
import com.school.management.SchoolManagementApp.mapper.StudentMapper;
import com.school.management.SchoolManagementApp.model.StudentRequest;
import com.school.management.SchoolManagementApp.model.StudentResponse;
import com.school.management.SchoolManagementApp.repository.StudentRepository;
import com.school.management.SchoolManagementApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private static final Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public StudentResponse saveStudent(StudentRequest request) {
        logger.info("ActionLog.saveStudent.start request: {}",request);
        var student = StudentMapper.INSTANCE.modelToEntity(request);
        var savedStudent = studentRepository.save(student);
        var response = StudentMapper.INSTANCE.entityToModel(savedStudent);
        logger.info("ActionLog.saveStudent.end response: {}",response);
        return response;
    }

    @Override
    public StudentResponse updateStudent(int id, StudentRequest request) {
        logger.info("ActionLog.updateStudent.start id: {}",id);
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student Is Not Found For Updating!"));
        StudentMapper.INSTANCE.modelToEntity(student,request);
        var updatedStudent = studentRepository.save(student);
        var response = StudentMapper.INSTANCE.entityToModel(updatedStudent);

        logger.info("ActionLog.updateStudent.end id: {}",id);
        return response;

    }

    @Override
    public StudentResponse getStudent(int id) {
        logger.info("ActionLog.saveStudent.start id: {}",id);
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student is not found!"));
        var response = StudentMapper.INSTANCE.entityToModel(student);
        logger.info("ActionLog.saveStudent.end id: {}",id);
        return response;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        logger.info("ActionLog.getAllStudents.start");

        var students = studentRepository.findAll();
        var responses = StudentMapper.INSTANCE.entityListToModelList(students);

        logger.info("ActionLog.getAllStudents.end students count : {}",responses.size());
        return responses;
    }

    @Override
    public void deleteStudent(int id) {
        logger.info("ActionLog.deleteStudent.start");
        var student = studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found!"));
        studentRepository.delete(student);
        logger.info("ActionLog.deleteStudent.end student deleted");
    }
}
