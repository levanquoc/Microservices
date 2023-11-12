package com.example.springbootrestfulwebservies.mapper;

import com.example.springbootrestfulwebservies.dto.UserDTO;
import com.example.springbootrestfulwebservies.entity.User;

public class UserMapper {
    //convert User JPA Entity into UserDTO
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO =new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }
    //convert  UserDTO into User JPA Entity
    public static User mapToUser(UserDTO userDTO) {
        User user =new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
