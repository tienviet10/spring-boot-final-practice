package com.viettran.springbootfinalpractice.model;

import com.viettran.springbootfinalpractice.entity.Article;
import com.viettran.springbootfinalpractice.entity.Post;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
    @Valid
    private Post post;
    @Valid
    private Article article;
}
