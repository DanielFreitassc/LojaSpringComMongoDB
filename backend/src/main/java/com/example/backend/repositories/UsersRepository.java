package com.example.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity,UUID>{
    
}
