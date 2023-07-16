package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorld {
    private final MessageSource messageSource;

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
        // LocaleContextHolder is a helper class that provides Locale resolution from header
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
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
