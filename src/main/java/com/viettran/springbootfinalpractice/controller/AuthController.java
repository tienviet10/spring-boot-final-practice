package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.model.HttpResponse;
import com.viettran.springbootfinalpractice.model.LoginRequest;
import com.viettran.springbootfinalpractice.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping("/login")
    public ResponseEntity<HttpResponse> login(@RequestBody @Validated LoginRequest requests) {
        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(Map.of("token", authService.attemptLogin(requests.getEmail(), requests.getPassword())))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .message("Login successfully")
                        .build());
    }
}
