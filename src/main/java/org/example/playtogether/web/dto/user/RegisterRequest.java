package org.example.playtogether.web.dto.user;

import org.example.playtogether.core.entities.user.Gender;

public record RegisterRequest(String email,
                              String password,
                              Gender gender) {
}
