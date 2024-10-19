package org.example.playtogether.config.security;

import org.example.playtogether.web.dto.user.LoginRequest;
import org.example.playtogether.web.dto.user.RegisterRequest;

public interface AuthService {

    String login (LoginRequest loginRequest);

    boolean register (RegisterRequest registerRequest);
}
