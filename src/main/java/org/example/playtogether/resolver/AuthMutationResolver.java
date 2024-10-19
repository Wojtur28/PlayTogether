/*
package org.example.playtogether.resolver;

import graphql.kickstart.annotations.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.example.playtogether.config.security.JwtTokenProvider;
import org.example.playtogether.web.dto.user.LoginResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
@AllArgsConstructor
public class AuthMutationResolver implements GraphQLMutationResolver {

    private AuthenticationManager authenticationManager;

    private JwtTokenProvider tokenProvider;

    public LoginResponse login(String username, String password) {
        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            // Generate JWT token
            String token = tokenProvider.generateToken(authentication.getName());

            // Return authentication data
            return new LoginResponse(token);

        } catch (AuthenticationException ex) {
            // Handle authentication failure
            throw new RuntimeException("Invalid username or password");
        }
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

*/
