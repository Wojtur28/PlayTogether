package org.example.playtogether.mapper;

import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.web.dto.user.UserResponse;
import org.example.playtogether.web.dto.user.UserUpdateResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserUpdateResponse toUserUpdateResponse(UserEntity userEntity);

    UserResponse toUserResponse(UserEntity userEntity);

    List<UserResponse> toUserResponse(List<UserEntity> userEntity);
}
