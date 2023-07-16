package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.exception.UserNotFoundException;
import com.viettran.springbootfinalpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository userRepository;

    public User getUser(int id) {
        return userRepository.findById((long) id).orElseThrow(() -> new UserNotFoundException("User not found. Id: " + id));
    }
}
