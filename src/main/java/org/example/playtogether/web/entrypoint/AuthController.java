package org.example.playtogether.web.entrypoint;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.example.playtogether.config.security.AuthServiceImpl;
import org.example.playtogether.web.dto.user.LoginRequest;
import org.example.playtogether.web.dto.user.LoginResponse;
import org.example.playtogether.web.dto.user.RegisterRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @MutationMapping
    @PreAuthorize("permitAll()")
    public LoginResponse login(@Argument LoginRequest input) {
        String token = authService.login(input);
        return new LoginResponse(token);
    }

    @MutationMapping
    @PreAuthorize("permitAll()")
    public boolean register(@Argument RegisterRequest input) {
        return authService.register(input);
    }

    @GraphQlExceptionHandler
    public GraphQLError handle(@NonNull Exception ex, @NonNull DataFetchingEnvironment environment) {
        return GraphQLError
                .newError()
                .errorType(ErrorType.BAD_REQUEST)
                .message(ex.getMessage())
                .path(environment.getExecutionStepInfo().getPath())
                .location(environment.getField().getSourceLocation())
                .build();
    }
}

