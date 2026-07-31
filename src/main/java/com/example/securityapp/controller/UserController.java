package com.example.securityapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Operation(summary = "Dashboard para usuários.")
    @GetMapping("/dashboard")
    public  String userDashBoard() {
        return "Usuário autenticado acessa.";
    }
}
