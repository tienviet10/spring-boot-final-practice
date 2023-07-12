package com.viettran.springbootfinalpractice.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@WithMockUser(role = "ROLE_ADMIN")
public @interface WithAdminUser {
}
