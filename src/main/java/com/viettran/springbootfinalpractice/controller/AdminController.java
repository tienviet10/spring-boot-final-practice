package com.viettran.springbootfinalpractice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.service.AdminService;
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
    public MappingJacksonValue getUser(@PathVariable int id) {
        // dynamic filtering, only filter out values for this endpoint only
        User user = adminService.getUser(id);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);

        SimpleBeanPropertyFilter filter =
                SimpleBeanPropertyFilter.filterOutAllExcept("id", "firstName", "lastName", "email_address", "roles");

        FilterProvider filters =
                new SimpleFilterProvider().addFilter("UserInfoNeeded", filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = adminService.getUsers();
        System.out.print("users: ");
        System.out.print(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PostMapping("/admin/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = adminService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
