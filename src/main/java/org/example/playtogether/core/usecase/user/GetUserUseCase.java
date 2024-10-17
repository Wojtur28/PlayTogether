package org.example.playtogether.core.usecase.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.entities.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GetUserUseCase {

    private final UserRepository userRepository;

    public UserEntity getUser(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userId));
    }
}
