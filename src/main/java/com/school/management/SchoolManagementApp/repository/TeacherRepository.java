package com.school.management.SchoolManagementApp.repository;

import com.school.management.SchoolManagementApp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
