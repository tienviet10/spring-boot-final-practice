package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.model.LoginRequest;
import com.viettran.springbootfinalpractice.model.LoginResponse;
import com.viettran.springbootfinalpractice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest requests) {
        return authService.attemptLogin(requests.getEmail(), requests.getPassword());
    }
}
