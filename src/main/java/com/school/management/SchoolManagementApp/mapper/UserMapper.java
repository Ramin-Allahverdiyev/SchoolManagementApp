package com.school.management.SchoolManagementApp.mapper;

import com.school.management.SchoolManagementApp.entity.User;
import com.school.management.SchoolManagementApp.model.StudentResponse;
import com.school.management.SchoolManagementApp.model.UserRequest;
import com.school.management.SchoolManagementApp.model.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class UserMapper {
    public static final UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    @Mapping(target = "status", expression = "java(getStatus())")
    public abstract User modelToEntity(UserRequest request);
    public abstract UserResponse entityToModel(User user);

    @Named("getStatus")
    protected boolean getStatus(){
        return true;
    }


}
