package org.example.playtogether.config.security;

import org.example.playtogether.web.dto.user.LoginRequest;
import org.example.playtogether.web.dto.user.LoginResponse;
import org.example.playtogether.web.dto.user.RegisterRequest;
import org.example.playtogether.web.dto.user.RegisterResponse;

public interface AuthService {

    LoginResponse login (LoginRequest loginRequest);

    RegisterResponse register (RegisterRequest registerRequest);
}
