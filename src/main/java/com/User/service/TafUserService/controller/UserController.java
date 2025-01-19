package com.User.service.TafUserService.controller;


import com.User.service.TafUserService.DTO.UserDTO;
import com.User.service.TafUserService.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
    public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return userService.getUsers();


    }
    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }

}

