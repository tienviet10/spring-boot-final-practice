package com.viettran.springbootfinalpractice.repository;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<UserProjection> findAllBy();

    @Query("SELECT u FROM _users u")
    List<User> findAllWithPosts();

}
