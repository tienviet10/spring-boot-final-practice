package com.viettran.springbootfinalpractice.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.viettran.springbootfinalpractice.entity.Role;
import com.viettran.springbootfinalpractice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class JwtToPrincipalConverter {
    public User convert(DecodedJWT jwt) {
        return User.builder().id(Long.valueOf(jwt.getSubject())).email(jwt.getClaim("email").asString()).role(extractAuthority(jwt)).build();
    }

    private Role extractAuthority(DecodedJWT jwt) {
        String role = jwt.getClaim("role").asString().toUpperCase();
        return Role.valueOf(role);
    }
}
