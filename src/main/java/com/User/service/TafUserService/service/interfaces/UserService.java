package com.User.service.TafUserService.service.interfaces;

import com.User.service.TafUserService.DTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<UserDTO> getUserById(Long id);

    ResponseEntity<UserDTO> createUser(UserDTO userDTO);

    ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO);
    ResponseEntity<List<UserDTO>> getUsers();

}
