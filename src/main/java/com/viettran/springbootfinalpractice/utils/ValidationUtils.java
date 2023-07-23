package com.viettran.springbootfinalpractice.utils;

import com.viettran.springbootfinalpractice.entity.Article;
import com.viettran.springbootfinalpractice.entity.Post;

public class ValidationUtils {
    public static boolean invalidateArticle(Article article) {
        return isNullOrEmpty(article.getDescription()) || isNullOrEmpty(article.getTitle()) || isNullOrEmpty(article.getText()) || isNullOrEmpty(article.getAuthor());
    }

    public static boolean invalidatePost(Post post) {
        return isNullOrEmpty(post.getType());
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}
