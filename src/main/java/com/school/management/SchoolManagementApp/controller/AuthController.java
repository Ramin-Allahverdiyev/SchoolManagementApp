package com.school.management.SchoolManagementApp.controller;

import com.school.management.SchoolManagementApp.model.*;
import com.school.management.SchoolManagementApp.service.UserService;
import com.school.management.SchoolManagementApp.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/auth")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;
    @PostMapping("/register")
    public UserResponse saveUser(@RequestBody UserRequest request){
        return userService.saveUser(request);
    }
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request){
        return userService.loginUser(request);
    }

}
