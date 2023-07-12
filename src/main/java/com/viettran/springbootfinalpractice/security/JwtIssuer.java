package com.viettran.springbootfinalpractice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
    private final JwtProperties properties;

    public String issue(long userId, String email, String role) {
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
                .withClaim("email", email)
                .withClaim("role", role)
                .sign(Algorithm.HMAC256(properties.getSecretKey()));
    }
}
