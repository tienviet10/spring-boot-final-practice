package com.viettran.springbootfinalpractice.security;

import com.viettran.springbootfinalpractice.entity.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipleAuthenticationToken extends AbstractAuthenticationToken {
    private final User principal;

    public UserPrincipleAuthenticationToken(User principal) {
        super(principal.getAuthorities());
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public User getPrincipal() {
        return principal;
    }
}
