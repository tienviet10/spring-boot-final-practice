package com.viettran.springbootfinalpractice.repository;

import com.viettran.springbootfinalpractice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
