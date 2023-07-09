package com.viettran.springbootfinalpractice.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipleAuthenticationToken extends AbstractAuthenticationToken {
    private final UserPrincipal principal;

    public UserPrincipleAuthenticationToken(UserPrincipal principal) {
        super(principal.getAuthorities());
        this.principal = principal;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public UserPrincipal getPrincipal() {
        return principal;
    }
}
