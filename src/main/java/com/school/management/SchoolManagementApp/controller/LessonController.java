package com.school.management.SchoolManagementApp.controller;

import com.school.management.SchoolManagementApp.model.LessonRequest;
import com.school.management.SchoolManagementApp.model.LessonResponse;
import com.school.management.SchoolManagementApp.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${root.url}/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public LessonResponse saveLesson(@RequestBody LessonRequest request){
        return lessonService.saveLesson(request);
    }

    @GetMapping("/all")
    public List<LessonResponse> getAllLessons(){
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public LessonResponse getLesson(@PathVariable int id){
        return lessonService.getLesson(id);
    }

    @PutMapping("/{id}")
    public LessonResponse updateTeacher(@PathVariable int id, @RequestBody LessonRequest request){
        return lessonService.updateLesson(id,request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLesson(@PathVariable int id){
        lessonService.deleteLesson(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
