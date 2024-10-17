package org.example.playtogether.web.dto.user;

import org.example.playtogether.core.entities.user.Gender;

public record CreateUserRequest(String username, String email, Gender gender){

}