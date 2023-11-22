package com.school.management.SchoolManagementApp.mapper;

import com.school.management.SchoolManagementApp.entity.Teacher;
import com.school.management.SchoolManagementApp.model.TeacherRequest;
import com.school.management.SchoolManagementApp.model.TeacherResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class TeacherMapper {

    public static final TeacherMapper INSTANCE= Mappers.getMapper(TeacherMapper.class);
    @Mapping(target = "lesson.id", source = "lessonId")
    public abstract Teacher modelToEntity(TeacherRequest request);
    @Mapping(target = "lessonId", source = "lesson.id")
    public abstract TeacherResponse entityToModel(Teacher teacher);
    public abstract List<TeacherResponse> entityListToModelList(List<Teacher> teachers);
    @Mapping(target = "lesson.id",source = "lessonId")
    public abstract void modelToEntity(@MappingTarget Teacher teacher, TeacherRequest request);

}
