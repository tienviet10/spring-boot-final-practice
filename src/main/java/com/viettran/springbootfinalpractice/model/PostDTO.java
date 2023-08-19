package com.viettran.springbootfinalpractice.model;

import com.viettran.springbootfinalpractice.entity.Content;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private String type;
    private Content content;
}
