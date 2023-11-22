package com.school.management.SchoolManagementApp.repository;

import com.school.management.SchoolManagementApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
