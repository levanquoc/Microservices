package com.example.springbootrestfulwebservies.controller;

import com.example.springbootrestfulwebservies.dto.UserDTO;
import com.example.springbootrestfulwebservies.entity.User;
import com.example.springbootrestfulwebservies.service.UserService;
import com.example.springbootrestfulwebservies.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
        UserDTO userSaved = userService.createUser(user);
        return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> lstUser = userService.getAllUser();
        return new ResponseEntity<>(lstUser, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        user.setId(id);
        UserDTO userUpdate = userService.updateUser(user);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deteleUserById(@PathVariable long id){
        userService.deteleUserById(id);
        return new ResponseEntity<>("User successfully delete",HttpStatus.OK);
    }
}
