package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin/user/{id}")
    public User getUser(@PathVariable int id) {
        return adminService.getUser(id);
    }
}
