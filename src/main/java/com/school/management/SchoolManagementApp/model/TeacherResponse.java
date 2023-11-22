package com.school.management.SchoolManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherResponse {
    private int id;
    private String name;
    private String surname;
    private int lessonId;
}
