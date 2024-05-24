package com.example.backend.models;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_users")
public class UsersEntity extends RepresentationModel<UsersEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user_id;
    private String username;
    private String password_hash;
    private String email;
    private String role;    
}
