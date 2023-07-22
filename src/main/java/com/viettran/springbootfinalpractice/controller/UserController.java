package com.viettran.springbootfinalpractice.controller;

import com.viettran.springbootfinalpractice.entity.Article;
import com.viettran.springbootfinalpractice.entity.Content;
import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.exception.UserNotFoundException;
import com.viettran.springbootfinalpractice.model.PostRequest;
import com.viettran.springbootfinalpractice.repository.ContentRepository;
import com.viettran.springbootfinalpractice.repository.PostRepository;
import com.viettran.springbootfinalpractice.repository.UserRepository;
import com.viettran.springbootfinalpractice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repository;
    private final PostRepository postRepository;
    private final ContentRepository contentRepository;
    private final UserService userService;

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable long id) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        return user.get().getPosts();
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable long id, @Valid @RequestBody Post post) {
        Optional<User> user = repository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/posts")
    public List<Post> posts() {
        return userService.getPost();
    }

    @PostMapping("/users/post")
    public Post newPost(@AuthenticationPrincipal User principal, @RequestBody PostRequest payload) {
        Post post = payload.getPost();
        Article article = payload.getArticle();

        Content savedContent = contentRepository.save(article);

        post.setUser(principal);
        post.setContent(savedContent);

        return postRepository.save(post);
    }
}
