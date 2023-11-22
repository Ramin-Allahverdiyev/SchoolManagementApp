package com.school.management.SchoolManagementApp.controller;

import com.school.management.SchoolManagementApp.model.TeacherRequest;
import com.school.management.SchoolManagementApp.model.TeacherResponse;
import com.school.management.SchoolManagementApp.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @PostMapping
    public TeacherResponse saveTeacher(@RequestBody TeacherRequest request){

        return teacherService.saveTeacher(request);
    }

    @GetMapping("/{id}")
    public TeacherResponse getTeacher(@PathVariable int id){
        return teacherService.getTeacher(id);
    }

    @GetMapping("/all")
    public List<TeacherResponse> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @PutMapping("/{id}")
    public TeacherResponse updateTeacher(@PathVariable int id,@RequestBody TeacherRequest request){
        return teacherService.updateTeacher(id,request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable int id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
