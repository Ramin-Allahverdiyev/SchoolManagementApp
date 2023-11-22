package com.school.management.SchoolManagementApp.controller;

import com.school.management.SchoolManagementApp.model.StudentRequest;
import com.school.management.SchoolManagementApp.model.StudentResponse;
import com.school.management.SchoolManagementApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${root.url}/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public StudentResponse saveStudent(@RequestBody StudentRequest request){
        return studentService.saveStudent(request);
    }

    @PutMapping("/{id}")
    public StudentResponse updateStudent(@RequestBody StudentRequest request,@PathVariable int id){
        return studentService.updateStudent(id,request);
    }

    @GetMapping("/{id}")
    public StudentResponse getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return studentService.getAllStudents();
    }


}
