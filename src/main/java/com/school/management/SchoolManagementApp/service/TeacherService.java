package com.school.management.SchoolManagementApp.service;

import com.school.management.SchoolManagementApp.model.TeacherRequest;
import com.school.management.SchoolManagementApp.model.TeacherResponse;

import java.util.List;

public interface TeacherService {
    TeacherResponse saveTeacher(TeacherRequest request);
    TeacherResponse getTeacher(int id);
    List<TeacherResponse> getAllTeacher();
    TeacherResponse updateTeacher(int id,TeacherRequest request);
    void deleteTeacher(int id);
}
