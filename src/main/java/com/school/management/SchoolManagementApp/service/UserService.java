package com.school.management.SchoolManagementApp.service;

import com.school.management.SchoolManagementApp.entity.User;
import com.school.management.SchoolManagementApp.model.LoginRequest;
import com.school.management.SchoolManagementApp.model.LoginResponse;
import com.school.management.SchoolManagementApp.model.UserRequest;
import com.school.management.SchoolManagementApp.model.UserResponse;

import java.util.Optional;

public interface UserService {
    UserResponse saveUser(UserRequest request);
    LoginResponse loginUser(LoginRequest request);
}
