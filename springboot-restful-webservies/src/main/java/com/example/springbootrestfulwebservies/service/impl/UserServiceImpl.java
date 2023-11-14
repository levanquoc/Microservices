package com.example.springbootrestfulwebservies.service.impl;

import com.example.springbootrestfulwebservies.dto.UserDTO;
import com.example.springbootrestfulwebservies.entity.User;
import com.example.springbootrestfulwebservies.mapper.AutoUserMapper;
import com.example.springbootrestfulwebservies.mapper.UserMapper;
import com.example.springbootrestfulwebservies.repository.UserRepository;
import com.example.springbootrestfulwebservies.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //convert userDTO into user
        //User user = UserMapper.mapToUser(userDTO);
        //User user = modelMapper.map(userDTO,User.class);
        User user = AutoUserMapper.MAPPER.mapToUser(userDTO);
        userRepository.save(user);
        //convert user into userDTO
        //UserDTO savedUserDTO = modelMapper.map(user,UserDTO.class);\
        UserDTO savedUserDTO =AutoUserMapper.MAPPER.mapToUserDTo(user);

        return savedUserDTO;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users= userRepository.findAll();
        return users.stream().map((user)->modelMapper.map(user,UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User userUpdated = userRepository.save(existingUser);
        return modelMapper.map(userUpdated,UserDTO.class);
    }

    @Override
    public void deteleUserById(long id) {
        userRepository.deleteById(id);
    }


}
