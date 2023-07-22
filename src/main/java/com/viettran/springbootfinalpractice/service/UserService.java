package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.Article;
import com.viettran.springbootfinalpractice.entity.Content;
import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.exception.UserNotFoundException;
import com.viettran.springbootfinalpractice.model.PostRequest;
import com.viettran.springbootfinalpractice.repository.ContentRepository;
import com.viettran.springbootfinalpractice.repository.PostRepository;
import com.viettran.springbootfinalpractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final ContentRepository contentRepository;

    public List<Post> getPostsForAUSer(long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        return user.get().getPosts();
    }

    // Not use anymore
    public URI getAllPostOLD(Post post, long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            throw new UserNotFoundException("id:" + id);

        post.setUser(user.get());

        Post savedPost = postRepository.save(post);

        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
    }

    public Post addNewPost(User principal, PostRequest payload) {
        Post post = payload.getPost();
        Article article = payload.getArticle();

        Content savedContent = contentRepository.save(article);

        post.setUser(principal);
        post.setContent(savedContent);

        return postRepository.save(post);
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
