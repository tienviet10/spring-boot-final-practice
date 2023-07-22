package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PostRepository postRepository;

    public List<Post> getPost() {
        var allPost = postRepository.findAll();
        System.out.println(allPost);
        return allPost;
    }
}
