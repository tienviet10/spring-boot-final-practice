package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.Role;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.security.UserPrincipleAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

public class WithMockUserSecurityContextFactory implements WithSecurityContextFactory<WithMockUser> {
    @Override
    public SecurityContext createSecurityContext(WithMockUser annotation) {
        var authority = Role.valueOf(annotation.role());

        var principal = User.builder()
                .id(annotation.userId())
                .email("test@test.com")
                .role(authority)
                .build();

        var context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new UserPrincipleAuthenticationToken(principal));
        return context;
    }
}
