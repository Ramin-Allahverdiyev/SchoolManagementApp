package com.school.management.SchoolManagementApp.service;

import com.school.management.SchoolManagementApp.model.LessonRequest;
import com.school.management.SchoolManagementApp.model.LessonResponse;

import java.util.List;

public interface LessonService {
    LessonResponse saveLesson(LessonRequest request);
    List<LessonResponse> getAllLessons();
    LessonResponse getLesson(Integer id);
    LessonResponse updateLesson(int id, LessonRequest request);
    void deleteLesson(int id);
}
