package com.viettran.springbootfinalpractice.wrapper;

import com.viettran.springbootfinalpractice.entity.Post;
import com.viettran.springbootfinalpractice.model.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ContentMapper.class)
public interface PostMapper {
    @Mapping(source = "type", target = "type")
    @Mapping(source = "content", target = "contentDTO")
    PostDTO toDTO(Post post);

    List<PostDTO> toDTOs(List<Post> posts);
}
