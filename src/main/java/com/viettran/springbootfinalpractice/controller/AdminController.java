package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.UserDTO;
import com.viettran.springbootfinalpractice.service.impl.AdminServiceImpl;
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
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;

    @GetMapping("/user/{id}")
    public ResponseEntity<MappingJacksonValue> getUser(@PathVariable int id) {
        // dynamic filtering, only filter out values for this endpoint only
        // Always use with JacksonValueUtil.getMappingJacksonValue()
        User user = adminService.getUser(id);

        return new ResponseEntity<>(JacksonValueUtil.getMappingJacksonValue(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<MappingJacksonValue> getAllUsers() {
        List<User> users = adminService.getUsers();

        return new ResponseEntity<>(JacksonValueUtil.getMappingJacksonValue(users), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = adminService.createUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/with-posts")
    public List<UserDTO> getUsersWithPosts() {
        return adminService.findAllWithPosts();
    }
}
