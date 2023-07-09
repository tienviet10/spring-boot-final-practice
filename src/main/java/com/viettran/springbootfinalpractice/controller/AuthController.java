package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.model.LoginRequest;
import com.viettran.springbootfinalpractice.model.LoginResponse;
import com.viettran.springbootfinalpractice.security.JwtIssuer;
import com.viettran.springbootfinalpractice.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest requests) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requests.getEmail(), requests.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        var principal = (UserPrincipal) authentication.getPrincipal();
        var roles = principal.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        var token = jwtIssuer.issue(principal.getUserId(), principal.getEmail(), roles);
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
