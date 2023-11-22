package com.school.management.SchoolManagementApp.mapper;

import com.school.management.SchoolManagementApp.entity.Student;
import com.school.management.SchoolManagementApp.model.StudentRequest;
import com.school.management.SchoolManagementApp.model.StudentResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class StudentMapper {
    public static final StudentMapper INSTANCE= Mappers.getMapper(StudentMapper.class);

    public abstract Student modelToEntity(StudentRequest request);
    public abstract StudentResponse entityToModel(Student student);

    public abstract void modelToEntity(@MappingTarget Student student,StudentRequest request);
    public abstract List<StudentResponse> entityListToModelList(List<Student> students);

}
