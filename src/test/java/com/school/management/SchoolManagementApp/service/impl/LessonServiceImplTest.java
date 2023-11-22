//package com.school.management.SchoolManagementApp.service.impl;
//
//import com.school.management.SchoolManagementApp.entity.Lesson;
//import com.school.management.SchoolManagementApp.exception.NotFoundException;
//import com.school.management.SchoolManagementApp.model.LessonRequest;
//import com.school.management.SchoolManagementApp.model.LessonResponse;
//import com.school.management.SchoolManagementApp.repository.LessonRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.willDoNothing;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//class LessonServiceImplTest {
//    @Mock
//    private LessonRepository lessonRepository;
//    @InjectMocks
//    private LessonServiceImpl lessonService;
//
//    @DisplayName("According to given id , finding a lesson")
//    @Test
//    public void getLessonTest(){
//        int id=1;
//        var lesson= Lesson.builder().id(id).name("Math").build();
//
//        when(lessonRepository.findById(id)).thenReturn(Optional.of(lesson));
//
//        var lessonResponse = lessonService.getLesson(id);
//
//        assertNotNull(lessonResponse);
//        assertEquals(1, lessonResponse.id());
//        assertEquals("Math", lessonResponse.name());
//
//    }
//
//    @DisplayName("According to given id , finding exception")
//    @Test
//    public void getLessonExceptionTest(){
//
//        given(lessonRepository.findById(anyInt())).willReturn(Optional.empty());
//
//        assertThrows(NotFoundException.class, ()-> lessonService.getLesson(anyInt()));
//
//    }
//
//    @DisplayName("According to given data , save lesson")
//    @Test
//    public void saveLessonTest(){
//
//        var request= new LessonRequest("Math");
//        var lesson = Lesson.builder().name("Math").build();
//
//        when(lessonRepository.save(any(Lesson.class))).thenReturn(lesson);
//
//        var lessonResponse = lessonService.saveLesson(request);
//
//        assertNotNull(lessonResponse);
//
//
//    }
//
//    @DisplayName("According to given id , finding all lessons")
//    @Test
//    public void getAllLessonTest(){
//
//        var lesson1= Lesson.builder().name("Math").build();
//        var lesson2= Lesson.builder().name("Literature").build();
//
//        when(lessonRepository.findAll()).thenReturn(Arrays.asList(lesson1,lesson2));
//
//        var allLessons = lessonService.getAllLessons();
//
//        assertEquals(allLessons.size(),2);
//
//    }
//
//    @DisplayName("According to given id , delete lesson")
//    @Test
//    public void deleteLessonTest(){
//        int id=1;
//        var lesson= Lesson.builder().id(id).name("Math").build();
//        given(lessonRepository.findById(id)).willReturn(Optional.of(lesson));
//        willDoNothing().given(lessonRepository).delete(lesson);
//
//        lessonService.deleteLesson(id);
//
//        verify(lessonRepository,times(1)).delete(lesson);
//        verify(lessonRepository,times(1)).findById(id);
//
//    }
//
//    @Test
//    public void deleteLessonExceptionTest(){
//
//        when(lessonRepository.findById(anyInt())).thenReturn(Optional.empty());
//
//        assertThrows(NotFoundException.class,()-> lessonService.deleteLesson(anyInt()));
//    }
//
//    @DisplayName("According to given id , update the lesson")
//    @Test
//    public void updateLessonTest(){
//
//        int id=1;
//        var lessonRequest=new LessonRequest("Physics");
//        var lesson = Lesson.builder().id(id).name("Math").build();
//        given(lessonRepository.findById(id)).willReturn(Optional.of(lesson));
//        lesson.setName(lessonRequest.name());
//
//        when(lessonRepository.save(any(Lesson.class))).thenReturn(lesson);
//        var lessonResponse = lessonService.updateLesson(id, lessonRequest);
//
//        assertNotNull(lessonResponse);
//
//    }
//
//    @Test
//    public void updateLessonExceptionTest(){
//
//        var request=new LessonRequest("Math");
//        when(lessonRepository.findById(anyInt())).thenReturn(Optional.empty());
//
//        assertThrows(NotFoundException.class,()-> lessonService.updateLesson(anyInt(),request));
//    }
//
//}