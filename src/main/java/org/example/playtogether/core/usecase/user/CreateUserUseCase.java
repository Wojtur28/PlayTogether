package org.example.playtogether.core.usecase.user;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.entities.user.UserRepository;
import org.example.playtogether.mapper.UserMapper;
import org.example.playtogether.web.dto.user.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserEntity createUser(CreateUserRequest createUserRequest) {
        return userRepository.save(userMapper.toEntity(createUserRequest));
    }

}
