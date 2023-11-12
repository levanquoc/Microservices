package com.example.springbootrestfulwebservies.service;

import com.example.springbootrestfulwebservies.dto.UserDTO;
import com.example.springbootrestfulwebservies.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUser();
    User updateUser(User user);
    void deteleUserById(long id);


}
