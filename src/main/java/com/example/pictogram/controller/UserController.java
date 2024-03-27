package com.example.pictogram.controller;

import com.example.pictogram.dto.UserDTO;
import com.example.pictogram.entity.User;
import com.example.pictogram.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        try{
            User user = userService.createUser(userDTO);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
