package com.school.management.SchoolManagementApp.mapper;

import com.school.management.SchoolManagementApp.entity.Lesson;
import com.school.management.SchoolManagementApp.model.LessonRequest;
import com.school.management.SchoolManagementApp.model.LessonResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
        ,unmappedTargetPolicy = ReportingPolicy.IGNORE
        ,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class LessonMapper {

    public static final LessonMapper INSTANCE= Mappers.getMapper(LessonMapper.class);

    public abstract Lesson modelToEntity(LessonRequest request);
    public abstract void modelToEntity(@MappingTarget Lesson lesson, LessonRequest request);
    public abstract LessonResponse entityToModel(Lesson lesson);

    public abstract List<LessonResponse> entityListToModelList(List<Lesson> lessons);

}
