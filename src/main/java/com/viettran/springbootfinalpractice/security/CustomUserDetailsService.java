package com.viettran.springbootfinalpractice.security;

import com.viettran.springbootfinalpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
//    private final UserService userService;

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var user = userService.findByEmail(username).orElseThrow();
//        return UserPrincipal.builder().userId(user.getId()).email(user.getEmail()).authorities(List.of(new SimpleGrantedAuthority(user.getRole()))).password(user.getPassword()).build();
        return userRepository.findByEmail(username).orElseThrow();
    }
}
