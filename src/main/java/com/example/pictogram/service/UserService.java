package com.example.pictogram.service;

import com.example.pictogram.dto.UserDTO;
import com.example.pictogram.entity.User;
import com.example.pictogram.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO) throws Exception {
        User existingUser = userRepository.findByUsername(userDTO.getUsername());
        if(existingUser != null)
            throw new Exception("Username already exists");
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setName(userDTO.getName());
        newUser.setPassword(userDTO.getPassword());
        return userRepository.save(newUser);

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
