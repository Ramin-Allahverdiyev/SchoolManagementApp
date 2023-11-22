package com.school.management.SchoolManagementApp.service;

import com.school.management.SchoolManagementApp.model.StudentRequest;
import com.school.management.SchoolManagementApp.model.StudentResponse;

import java.util.List;

public interface StudentService {
    StudentResponse saveStudent(StudentRequest request);
    StudentResponse updateStudent(int id,StudentRequest request);
    StudentResponse getStudent(int id);
    List<StudentResponse> getAllStudents();
    void deleteStudent(int id);

}
