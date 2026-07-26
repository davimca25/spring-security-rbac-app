package com.example.securityapp.dto.response;

import com.example.securityapp.model.Role;

import java.util.UUID;

public record RegisterUserResponse(UUID id, String name, String email, Role role) {
}
