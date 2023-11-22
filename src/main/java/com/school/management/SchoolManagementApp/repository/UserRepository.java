package com.school.management.SchoolManagementApp.repository;

import com.school.management.SchoolManagementApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

}
