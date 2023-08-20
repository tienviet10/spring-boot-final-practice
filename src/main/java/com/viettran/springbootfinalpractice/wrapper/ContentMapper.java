package com.viettran.springbootfinalpractice.wrapper;

import com.viettran.springbootfinalpractice.entity.Content;
import com.viettran.springbootfinalpractice.model.ContentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    ContentDTO toDTO(Content content);
}
