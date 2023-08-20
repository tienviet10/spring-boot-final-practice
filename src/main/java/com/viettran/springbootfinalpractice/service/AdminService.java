package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.UserDTO;
import com.viettran.springbootfinalpractice.model.UserProjection;

import java.util.List;

public interface AdminService {
    User getUser(int id);

    List<User> getUsers();

    List<UserProjection> findAllWithPosts();

    List<UserDTO> findAllWithPostsTwo();

    List<UserDTO> findAllUsersWithPostsThree();
    
    User createUser(User user);
}
