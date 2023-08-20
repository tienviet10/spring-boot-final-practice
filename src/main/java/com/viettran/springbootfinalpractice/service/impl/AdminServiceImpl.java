package com.viettran.springbootfinalpractice.service.impl;

import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.exception.UserNotFoundException;
import com.viettran.springbootfinalpractice.model.PostDTO;
import com.viettran.springbootfinalpractice.model.UserDTO;
import com.viettran.springbootfinalpractice.model.UserProjection;
import com.viettran.springbootfinalpractice.repository.UserRepository;
import com.viettran.springbootfinalpractice.service.AdminService;
import com.viettran.springbootfinalpractice.wrapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User getUser(int id) {
        return userRepository.findById((long) id).orElseThrow(() -> new UserNotFoundException("User not found. Id: " + id));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<UserProjection> findAllWithPosts() {
        return userRepository.findAllBy();
    }

    public List<UserDTO> findAllWithPostsTwo() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDto = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = convertToUserDTO(user);
            userDto.add(userDTO);
        }
        return userDto;
    }

    public List<UserDTO> findAllUsersWithPostsThree() {
        List<User> users = userRepository.findAllWithPosts();
        return userMapper.toDTOs(users);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPosts(user.getPosts().stream().map(this::convertToPostDTO).collect(Collectors.toList()));

        return userDTO;
    }

    public PostDTO convertToPostDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        postDTO.setType(post.getType());
        postDTO.setContent(post.getContent());

        return postDTO;
    }
}
