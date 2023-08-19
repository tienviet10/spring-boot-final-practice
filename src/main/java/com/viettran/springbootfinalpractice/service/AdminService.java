package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.UserDTO;

import java.util.List;

public interface AdminService {
    User getUser(int id);

    List<User> getUsers();

    List<UserDTO> findAllWithPosts();

    User createUser(User user);
}
