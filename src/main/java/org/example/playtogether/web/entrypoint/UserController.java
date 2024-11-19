package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.usecase.user.DeleteUserUseCase;
import org.example.playtogether.core.usecase.user.GetUserUseCase;
import org.example.playtogether.core.usecase.user.GetUsersUseCase;
import org.example.playtogether.core.usecase.user.UpdateUserUseCase;
import org.example.playtogether.web.dto.user.UserResponse;
import org.example.playtogether.web.dto.user.UserUpdateRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final GetUsersUseCase getUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;


    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable UUID id) {
        return getUserUseCase.getUser(id);
    }

    @GetMapping
    public List<UserResponse> getUsers() {
        return getUsersUseCase.getUsers();
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable UUID id, @RequestBody UserUpdateRequest userUpdateRequest) {
        return updateUserUseCase.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable UUID id) {
        return deleteUserUseCase.deleteUser(id);
    }
}
