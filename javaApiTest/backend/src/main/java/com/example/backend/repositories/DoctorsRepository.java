package com.example.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.DoctorsEntity;

public interface DoctorsRepository extends JpaRepository<DoctorsEntity, UUID> {
    
}
