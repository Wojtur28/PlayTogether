package org.example.playtogether.core.usecase.user;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class DeleteUserUseCase {

    private final UserRepository userRepository;

    //TODO: Maybe return object with message and status operation?
    public boolean deleteUser(UUID id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }
}
