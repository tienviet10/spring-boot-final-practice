package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin/user/{id}")
    public User getUser(@PathVariable int id) {
        return adminService.getUser(id);
    }

    @PostMapping("/admin/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = adminService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
