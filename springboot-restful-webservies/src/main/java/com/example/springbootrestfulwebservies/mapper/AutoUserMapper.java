package com.example.springbootrestfulwebservies.mapper;

import com.example.springbootrestfulwebservies.dto.UserDTO;
import com.example.springbootrestfulwebservies.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDTO mapToUserDTo(User user);

    User mapToUser(UserDTO userDTO);
}
