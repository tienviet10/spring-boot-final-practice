package com.viettran.springbootfinalpractice.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtToPrincipalConverter {
    public UserPrincipal convert(DecodedJWT jwt) {
        return UserPrincipal.builder().userId(Long.valueOf(jwt.getSubject())).email(jwt.getClaim("email").asString()).authorities(extractAuthorities(jwt)).build();
    }

    private List<SimpleGrantedAuthority> extractAuthorities(DecodedJWT jwt) {
        var claim = jwt.getClaim("roles");

        if (claim.isNull() || claim.isMissing()) {
            return List.of();
        }
        return claim.asList(SimpleGrantedAuthority.class);
    }
}
