package com.school.management.SchoolManagementApp.repository;

import com.school.management.SchoolManagementApp.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
