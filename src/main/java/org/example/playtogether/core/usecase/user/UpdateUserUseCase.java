package org.example.playtogether.core.usecase.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.entities.user.UserRepository;
import org.example.playtogether.mapper.UserMapper;
import org.example.playtogether.web.dto.user.UserUpdateRequest;
import org.example.playtogether.web.dto.user.UserUpdateResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UpdateUserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserUpdateResponse updateUser(UUID id, UserUpdateRequest userUpdateRequest) {
        UserEntity updatedUser = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found"));

        updatedUser.setUsername(userUpdateRequest.username());
        updatedUser.setEmail(userUpdateRequest.email());
        updatedUser.setToxicityLevel(userUpdateRequest.toxicityLevel());
        updatedUser.setGender(userUpdateRequest.gender());
        updatedUser.setLanguageWritten(userUpdateRequest.languageWritten());
        updatedUser.setLanguageSpoken(userUpdateRequest.languageSpoken());
        updatedUser.setGamesPlayed(userUpdateRequest.gamesPlayed());

        userRepository.save(updatedUser);

        return userMapper.toUserUpdateResponse(updatedUser);
    }
}
