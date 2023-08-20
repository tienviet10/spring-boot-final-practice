package com.viettran.springbootfinalpractice.model;

import com.viettran.springbootfinalpractice.entity.Content;

public interface PostProjection {
    String getType();

    Content getContent();  // Assuming you have a Content class/entity
}
