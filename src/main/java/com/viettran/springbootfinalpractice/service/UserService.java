package com.viettran.springbootfinalpractice.service;

import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.PostRequest;

import java.net.URI;
import java.util.List;

public interface UserService {
    List<Post> getPostsForAUSer(long id);

    URI getAllPostOLD(Post post, long id);

    Post addNewPost(User principal, PostRequest payload);

    List<Post> getPosts();
}
