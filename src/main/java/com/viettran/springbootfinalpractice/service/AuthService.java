package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.model.LoginResponse;

public interface AuthService {
    LoginResponse attemptLogin(String email, String password);
}
