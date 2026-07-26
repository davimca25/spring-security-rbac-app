package com.example.securityapp.dto.request;

import com.example.securityapp.model.Role;
import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Nome é obrigatório") String name,
                                  @NotEmpty(message = "E-mail é obrigatório") String email,
                                  @NotEmpty(message = "Senha é obrigatória") String password,
                                  Role role) {
}
