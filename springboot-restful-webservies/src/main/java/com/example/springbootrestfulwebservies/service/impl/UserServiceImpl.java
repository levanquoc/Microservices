package com.example.springbootrestfulwebservies.service.impl;

import com.example.springbootrestfulwebservies.dto.UserDTO;
import com.example.springbootrestfulwebservies.entity.User;
import com.example.springbootrestfulwebservies.mapper.UserMapper;
import com.example.springbootrestfulwebservies.repository.UserRepository;
import com.example.springbootrestfulwebservies.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        userRepository.save(user);
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.mapToUserDTO(user.get());
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users= userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User userUpdated = userRepository.save(existingUser);
        return userUpdated;
    }

    @Override
    public void deteleUserById(long id) {
        userRepository.deleteById(id);
    }


}
