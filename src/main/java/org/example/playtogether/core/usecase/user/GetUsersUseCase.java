package org.example.playtogether.core.usecase.user;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserRepository;
import org.example.playtogether.mapper.UserMapper;
import org.example.playtogether.web.dto.user.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetUsersUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserResponse> getUsers() {
        return userMapper.toUserResponse(userRepository.findAll());
    }
}
