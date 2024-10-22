package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.usecase.user.DeleteUserUseCase;
import org.example.playtogether.core.usecase.user.GetUserUseCase;
import org.example.playtogether.core.usecase.user.GetUsersUseCase;
import org.example.playtogether.core.usecase.user.UpdateUserUseCase;
import org.example.playtogether.web.dto.user.UserResponse;
import org.example.playtogether.web.dto.user.UserUpdateRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
public class UserController {

    private final GetUsersUseCase getUsersUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;


    @QueryMapping
    public UserResponse getUser(@Argument UUID id) {
        return getUserUseCase.getUser(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @QueryMapping
    public List<UserResponse> getUsers() {
        return getUsersUseCase.getUsers();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @MutationMapping
    public UserResponse updateUser(@Argument UUID id, @Argument("input") UserUpdateRequest userUpdateRequest) {
        return updateUserUseCase.updateUser(id, userUpdateRequest);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @MutationMapping
    public boolean deleteUser(@Argument UUID id) {
        return deleteUserUseCase.deleteUser(id);
    }
}
