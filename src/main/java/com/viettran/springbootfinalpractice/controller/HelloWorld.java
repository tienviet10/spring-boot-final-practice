package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorld {
    private final HelloWorldService helloWorldService;

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return helloWorldService.helloWorldInternationalized();
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
