package com.school.management.SchoolManagementApp.service.impl;

import com.school.management.SchoolManagementApp.entity.User;
import com.school.management.SchoolManagementApp.exception.NotFoundException;
import com.school.management.SchoolManagementApp.mapper.StudentMapper;
import com.school.management.SchoolManagementApp.mapper.UserMapper;
import com.school.management.SchoolManagementApp.model.LoginRequest;
import com.school.management.SchoolManagementApp.model.LoginResponse;
import com.school.management.SchoolManagementApp.model.UserRequest;
import com.school.management.SchoolManagementApp.model.UserResponse;
import com.school.management.SchoolManagementApp.repository.UserRepository;
import com.school.management.SchoolManagementApp.service.UserService;
import com.school.management.SchoolManagementApp.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public UserResponse saveUser(UserRequest request) {
        logger.info("ActionLog.saveUser.start request: {}",request);
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        var user = UserMapper.INSTANCE.modelToEntity(request);
        var savedUser = userRepository.save(user);
        var response = UserMapper.INSTANCE.entityToModel(savedUser);
        logger.info("ActionLog.saveUser.end response: {}",response);
        return response;
    }

    @Override
    public LoginResponse loginUser(LoginRequest request) {
        logger.info("ActionLog.loginUser.start request: {}",request);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(),
                request.password()));

        var user = userRepository.findByUsername(request.username())
              .orElseThrow(() -> new NotFoundException("Username not found!"));
        var token = jwtService.generateToken(user);

        logger.info("ActionLog.loginUser.end request: {}",request);
        return LoginResponse.builder()
                .token(token)
                .build();
    }

//    @Override
//    public User getUserByUsername(String username) {
//        logger.info("ActionLog.getUserByUsername.start request: {}",request);
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new NotFoundException("Username not found!"));
//
//
//        logger.info("ActionLog.getUserByUsername.end response: {}",response);
//        return response;
//    }

}
