package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.usecase.user.CreateUserUseCase;
import org.example.playtogether.core.usecase.user.GetUserUseCase;
import org.example.playtogether.core.usecase.user.GetUsersUseCase;
import org.example.playtogether.web.dto.user.CreateUserRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUsersUseCase getUsersUseCase;
    private final GetUserUseCase getUserUseCase;

    @QueryMapping
    public UserEntity getUser(@Argument UUID id) {
        return getUserUseCase.getUser(id);
    }

    @MutationMapping
    public UserEntity createUser(@Argument("input") CreateUserRequest createUserRequest) {
        return createUserUseCase.createUser(createUserRequest);
    }
}
