package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.User;

import java.util.List;

public interface AdminService {
    User getUser(int id);

    List<User> getUsers();

    User createUser(User user);
}
