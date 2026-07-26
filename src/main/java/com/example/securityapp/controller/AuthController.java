package com.example.securityapp.controller;

import com.example.securityapp.dto.request.LoginRequest;
import com.example.securityapp.dto.request.RegisterUserRequest;
import com.example.securityapp.dto.response.LoginResponse;
import com.example.securityapp.dto.response.RegisterUserResponse;
import com.example.securityapp.model.Role;
import com.example.securityapp.model.User;
import com.example.securityapp.repository.UserRepository;
import com.example.securityapp.security.SecurityConfig;
import com.example.securityapp.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;

import static com.example.securityapp.model.Role.ROLE_USER;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final SecurityConfig securityConfig;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public AuthController(UserRepository userRepository, AuthenticationManager authenticationManager, SecurityConfig securityConfig, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.securityConfig = securityConfig;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        if (this.userRepository.findUserByEmail(registerUserRequest.email()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email already exists");
        }

        User newUser = new User();

        newUser.setPassword(passwordEncoder.encode(registerUserRequest.password()));
        newUser.setEmail(registerUserRequest.email());
        newUser.setName(registerUserRequest.name());

        if (registerUserRequest.role() != null) {
            newUser.setRole(registerUserRequest.role());
        } else {
            newUser.setRole(Role.ROLE_USER);
        }
        userRepository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse(newUser.getId(), newUser.getName(), newUser.getEmail(), newUser.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password()));

        String token = jwtService.generateToken(loginRequest.email());

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
