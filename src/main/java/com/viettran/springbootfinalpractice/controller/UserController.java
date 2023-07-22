package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.PostRequest;
import com.viettran.springbootfinalpractice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable long id) {
        return userService.getPostsForAUSer(id);
    }

    // Not use anymore
    @PostMapping("/{id}/old-posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable long id, @Valid @RequestBody Post post) {
        URI location = userService.getAllPostOLD(post, id);

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/posts")
    public List<Post> posts() {
        return userService.getPosts();
    }

    @PostMapping("/post")
    public Post newPost(@AuthenticationPrincipal User principal, @RequestBody PostRequest payload) {
        return userService.addNewPost(principal, payload);
    }
}
