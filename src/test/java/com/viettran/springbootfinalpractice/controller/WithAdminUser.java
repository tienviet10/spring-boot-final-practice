package com.viettran.springbootfinalpractice.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(roles = {"ROLE_ADMIN", "ROLE_USER"})
public @interface WithAdminUser {
}
