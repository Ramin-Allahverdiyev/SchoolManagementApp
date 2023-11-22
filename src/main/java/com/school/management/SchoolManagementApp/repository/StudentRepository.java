package com.school.management.SchoolManagementApp.repository;

import com.school.management.SchoolManagementApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
