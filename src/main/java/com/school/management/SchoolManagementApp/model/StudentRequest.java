package com.school.management.SchoolManagementApp.model;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String name;
    private String surname;
    private Set<LessonDto> lessons;
    private Set<TeacherDto> teachers;
}
