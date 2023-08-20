package com.viettran.springbootfinalpractice.model;

import java.util.List;

public interface UserProjection {
    Long getId();

    String getEmail();

    List<PostProjection> getPosts();
}
