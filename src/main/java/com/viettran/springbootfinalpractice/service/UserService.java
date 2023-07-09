package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        if (!EXISTING_EMAIL.equals(email)) {
            return Optional.empty();
        }
        var user = new UserEntity();
        user.setId(1L);
        user.setEmail(EXISTING_EMAIL);
        user.setPassword("$2a$12$5Yx7AsAl9Zd3eUVhsWoNg.6IlzWrJxtm5/zdPCws4zEQoh67LTV6e");
        user.setRole("ROLE_ADMIN");
        user.setExtraInfo("extra info");
        return Optional.of(user);
    }
}
