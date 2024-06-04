package com.example.backend.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.controllers.UsersController;
import com.example.backend.dtos.UsersRecordDTO;
import com.example.backend.models.UsersEntity;
import com.example.backend.repositories.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public ResponseEntity<UsersEntity> saveUser(UsersRecordDTO usersRecordDTO) {
        UsersEntity usersEntity = new UsersEntity();
        BeanUtils.copyProperties(usersRecordDTO, usersEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersRepository.save(usersEntity));
    }

    public ResponseEntity<List<UsersEntity>> getAllUsers() {
        List<UsersEntity> users = usersRepository.findAll();
        if(!users.isEmpty()) {
            for(UsersEntity usersEntity : users) {
                UUID user_id = usersEntity.getUser_id();
                usersEntity.add(linkTo(methodOn(UsersController.class).getUserById(user_id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    
    public ResponseEntity<Object> getUserById(UUID user_id) {
        Optional<UsersEntity> user = usersRepository.findById(user_id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário com este id");
        }
        user.get().add(linkTo(methodOn(UsersController.class).getAllUsers()).withRel("Lista de usuarios"));
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    public ResponseEntity<Object> updateUserById(UUID user_id, UsersRecordDTO usersRecordDTO) {
        Optional<UsersEntity> user = usersRepository.findById(user_id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário com este id");
        }
        UsersEntity usersEntity = user.get();
        BeanUtils.copyProperties(usersRecordDTO, usersEntity);
        return ResponseEntity.status(HttpStatus.OK).body(usersRepository.save(usersEntity));
    }
    
    public ResponseEntity<Object> deleteUserById(UUID user_id) {
        Optional<UsersEntity> user = usersRepository.findById(user_id);
        if(user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário com este id");
        }
        usersRepository.delete(user.get());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
