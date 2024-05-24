package com.example.backend.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dtos.UsersRecordDTO;
import com.example.backend.models.UsersEntity;
import com.example.backend.services.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired 
    private UsersService usersService;

    @PostMapping
    public ResponseEntity<UsersEntity> saveUser(@RequestBody @Valid UsersRecordDTO usersRecordDTO) {
        return usersService.saveUser(usersRecordDTO);
    }

    @GetMapping
    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("{user_id}")
    public ResponseEntity<Object> getUserById(@PathVariable(value = "user_id")UUID user_id) {
        return usersService.getUserById(user_id);
    }

    @PutMapping("{user_id}")
    public ResponseEntity<Object> updatUserById(@PathVariable(value = "user_id")UUID user_id, @RequestBody @Valid UsersRecordDTO usersRecordDTO) {
        return usersService.updateUserById(user_id, usersRecordDTO);
    }

    @DeleteMapping("{user_id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable(value = "user_id")UUID user_id) {
        return usersService.deleteUserById(user_id);
    }
    
}
