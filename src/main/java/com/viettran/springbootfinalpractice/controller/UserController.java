package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.Content;
import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.HttpResponse;
import com.viettran.springbootfinalpractice.model.PostRequest;
import com.viettran.springbootfinalpractice.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Map.of;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

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
    public ResponseEntity<HttpResponse> posts() {
        List<Content> contents = userService.getPosts();
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(of("posts", contents))
                        .message("Posts retrieved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/post")
    public ResponseEntity<HttpResponse> newPost(@AuthenticationPrincipal User principal, @Valid @RequestBody PostRequest payload) {
        Post post = userService.addNewPost(principal, payload);

        return ResponseEntity.created(URI.create("")).body(
                HttpResponse.builder()
                        .timeStamp(LocalDateTime.now().toString())
                        .data(of("post", post))
                        .message("Post created successfully")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }
}
