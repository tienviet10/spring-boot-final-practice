package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.service.AdminService;
import com.viettran.springbootfinalpractice.utils.JacksonValueUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/admin/user/{id}")
    public ResponseEntity<MappingJacksonValue> getUser(@PathVariable int id) {
        // dynamic filtering, only filter out values for this endpoint only
        // Always use with JacksonValueUtil.getMappingJacksonValue()
        User user = adminService.getUser(id);

        return new ResponseEntity<>(JacksonValueUtil.getMappingJacksonValue(user), HttpStatus.OK);
    }

    @GetMapping("/admin/users")
    public ResponseEntity<MappingJacksonValue> getAllUsers() {
        List<User> users = adminService.getUsers();

        return new ResponseEntity<>(JacksonValueUtil.getMappingJacksonValue(users), HttpStatus.OK);
    }

    @PostMapping("/admin/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = adminService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
