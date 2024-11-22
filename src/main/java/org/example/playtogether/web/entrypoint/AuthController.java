package org.example.playtogether.web.entrypoint;

import lombok.AllArgsConstructor;
import org.example.playtogether.config.security.AuthService;
import org.example.playtogether.web.dto.user.LoginRequest;
import org.example.playtogether.web.dto.user.LoginResponse;
import org.example.playtogether.web.dto.user.RegisterRequest;
import org.example.playtogether.web.dto.user.RegisterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest input) {
        return ResponseEntity.ok(authService.login(input));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest input) {
        return ResponseEntity.ok(authService.register(input));
    }
}

