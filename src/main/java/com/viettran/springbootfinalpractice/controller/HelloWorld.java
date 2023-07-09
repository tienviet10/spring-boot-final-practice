package com.viettran.springbootfinalpractice.controller;

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
}
