package com.viettran.springbootfinalpractice.model;

import com.viettran.springbootfinalpractice.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private String type;
    private Content content;
    private ContentDTO contentDTO;
}
