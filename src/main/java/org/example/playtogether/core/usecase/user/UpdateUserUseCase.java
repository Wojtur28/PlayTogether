package org.example.playtogether.core.usecase.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.entities.user.UserRepository;
import org.example.playtogether.mapper.GameMapper;
import org.example.playtogether.mapper.UserMapper;
import org.example.playtogether.web.dto.user.UserResponse;
import org.example.playtogether.web.dto.user.UserUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final GameMapper gameMapper;

    public UserResponse updateUser(UUID id, UserUpdateRequest userUpdateRequest) {
        UserEntity updatedUser = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found"));

        updatedUser.setUsername(userUpdateRequest.username());
        updatedUser.setEmail(userUpdateRequest.email());
        updatedUser.setToxicityLevel(userUpdateRequest.toxicityLevel());
        updatedUser.setGender(userUpdateRequest.gender());
        updatedUser.setLanguageWritten(userUpdateRequest.languageWritten());
        updatedUser.setLanguageSpoken(userUpdateRequest.languageSpoken());
        updatedUser.setGamesPlayed(gameMapper.toEntity(userUpdateRequest.gamesPlayed()));

        userRepository.save(updatedUser);

        return userMapper.toUserResponse(updatedUser);
    }
}
