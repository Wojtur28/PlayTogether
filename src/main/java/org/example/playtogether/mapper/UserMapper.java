package org.example.playtogether.mapper;

import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.web.dto.user.CreateUserRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity (CreateUserRequest createUserRequest);
}
