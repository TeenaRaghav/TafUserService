package com.User.service.TafUserService.service;

import com.User.service.TafUserService.DTO.UserDTO;
import com.User.service.TafUserService.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final RestTemplate restTemplate;

    @Value("${taf.datastore.service.url}")
    private String url;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long id) {
        UserDTO user = restTemplate.getForObject(url + "/" + id,UserDTO.class);
        if(user != null){
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        // Make a POST request to TafDatastoreService to create a user
        return restTemplate.postForEntity(url + "/" + "register", userDTO, UserDTO.class);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO) {
        // Set the ID from the URL to the provided userDTO
        userDTO.setId(id);
        // Make a PUT request to TafDatastoreService to update the user
        restTemplate.put(url + "/" + id, userDTO);
        return ResponseEntity.ok(userDTO);
    }

//    public ResponseEntity<List<UserDTO>> getUsers() {
//        List<UserDTO> users = Collections.singletonList(restTemplate.getForObject(url, UserDTO.class));
//        return ResponseEntity.ok(users);
//    }
    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        // Use ParameterizedTypeReference to specify the response type as a List of UserDTO
        ResponseEntity<List<UserDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<UserDTO>>() {}
        );
        return response;
    }




}
