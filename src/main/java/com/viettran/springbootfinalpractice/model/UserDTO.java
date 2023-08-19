package com.viettran.springbootfinalpractice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;

    private List<PostDTO> posts;

}
