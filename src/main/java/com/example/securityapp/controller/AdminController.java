package com.example.securityapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Operation(summary = "Painel para administradores.")
    @GetMapping("/panel")
    public String adminPanel() {
        return "Admin autenticado acessa.";
    }
}
