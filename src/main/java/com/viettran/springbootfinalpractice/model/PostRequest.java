package com.viettran.springbootfinalpractice.model;

import com.viettran.springbootfinalpractice.entity.Article;
import com.viettran.springbootfinalpractice.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    private Post post;
    private Article article;
}
