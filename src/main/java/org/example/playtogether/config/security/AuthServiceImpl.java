package org.example.playtogether.config.security;

import lombok.AllArgsConstructor;
import org.example.playtogether.core.entities.user.Role;
import org.example.playtogether.core.entities.user.UserEntity;
import org.example.playtogether.core.entities.user.UserRepository;
import org.example.playtogether.web.dto.user.LoginRequest;
import org.example.playtogether.web.dto.user.LoginResponse;
import org.example.playtogether.web.dto.user.RegisterRequest;
import org.example.playtogether.web.dto.user.RegisterResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByEmail(loginRequest.email())
                .orElseThrow(() -> new IllegalArgumentException("User not found with email: " + loginRequest.email()));

        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return new LoginResponse(jwtTokenProvider.generateToken(user.getEmail()));
    }

    public RegisterResponse register(RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.email()).isPresent()) {
            throw new IllegalArgumentException("User already exists with this email");
        }

        String encodedPassword = passwordEncoder.encode(registerRequest.password());
        UserEntity newUser = new UserEntity();
        newUser.setEmail(registerRequest.email());
        newUser.setPassword(encodedPassword);
        newUser.setGender(registerRequest.gender());
        newUser.setRoles(Collections.singleton(Role.ROLE_USER));
        userRepository.save(newUser);

        return new RegisterResponse(newUser.getEmail());
    }
}
