package com.viettran.springbootfinalpractice.wrapper;

import com.viettran.springbootfinalpractice.entity.User;
import com.viettran.springbootfinalpractice.model.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = PostMapper.class)
public interface UserMapper {
    UserDTO toDTO(User user);

    List<UserDTO> toDTOs(List<User> users);
}
