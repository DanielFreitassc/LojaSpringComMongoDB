package com.example.backend.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend.models.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, UUID> {
    
}
