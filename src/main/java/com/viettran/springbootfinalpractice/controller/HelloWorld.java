package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal User principal) {

        return "Log in as: " + principal.getEmail() + " User ID: " + principal.getId();
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal User principal) {
        return "Admin " + principal.getId();
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal User principal) {
        return "User " + principal.getId();
    }
}
